from django.contrib.auth import authenticate, login, logout
from django.contrib.auth.mixins import LoginRequiredMixin
from django.shortcuts import redirect
from django.urls import reverse_lazy
from django.views.generic import TemplateView, FormView

from sidtm.forms import FormLogin
from sidtm.models import Usuario, AuthUser


# def add_user_context(usuario, context):
#     context['usuarioLogado'] = usuario
#     context['usuarioLogadoImagem'] = None
#     if usuario.imagem is not None:
#         context['usuarioLogadoImagem'] = blob2base64(usuario.imagem)
#     return context

def logout_request(request):
    logout(request)
    return redirect('sidtm:login')

class LoginFormView(FormView):
    model = Usuario
    form_class = FormLogin
    template_name = 'sidtm/login.html'
    success_url = reverse_lazy('sidtm:home')

    def post(self, request, *args, **kwargs):
        form = self.form_class(request.POST)
        if form.is_valid():
            mail_usuario = form.cleaned_data['email']
            senha_usuario = form.cleaned_data['senha']
            # usuario = form.validar_usuario()
            # if usuario is None:
            #     messages.info(request, 'usuário não existe')
            # else:
            #     if usuario is False:
            #         messages.error(request, 'usuário ou senha inválido')
            #     else:
            #         userDjango = AuthUser.objects.get(id=usuario.id)
            #         user = authenticate(username=userDjango.username, password=form.cleaned_data['senha'])
            #         login(request, user)
            #         return self.form_valid(form)
            if not '@' in mail_usuario:
                userDjango = AuthUser.objects.get(username=mail_usuario)
            else:
                userDjango = AuthUser.objects.get(email=mail_usuario)
            if userDjango is not None:
                user = authenticate(username=userDjango.username, password=senha_usuario)
                login(request, user)
                return self.form_valid(form)

        return self.form_invalid(**{'form': form})


class HomeTemplateView(LoginRequiredMixin, TemplateView):
    login_url = '/'

    template_name = 'sidtm/home.html'

    # def get_context_data(self, **kwargs):
    #     return add_user_context(Usuario.objects.get(id=self.request.user.id),
    #                             super(HomeTemplateView, self).get_context_data(**kwargs))


class HomeTemplateViewTest(TemplateView):
    template_name = 'sidtm/home.html'

    # def get_context_data(self, **kwargs):
    #     return add_user_context(Usuario.objects.get(id=1),
    #                             super(HomeTemplateViewTest, self).get_context_data(**kwargs))
