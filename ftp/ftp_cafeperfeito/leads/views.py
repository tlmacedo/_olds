from django.urls import reverse_lazy
from django.views.generic import TemplateView, FormView

from setup.views import enviando_mails


def cadastrar_lead(self, request, urlLP):
    form = self.form_class(request.POST)
    if form.is_valid():
        form.save()
        enviando_mails(request, form.cleaned_data['nome'], form.cleaned_data['fone'], form.cleaned_data['email'])
        # sendmail(request, 'Thiago', '8168-6148', 'tl.macedo@hotmail.com')
        return self.form_valid(form)
    return self.form_invalid(**{'form': form})


class LeadsObriagoTemplateView(TemplateView):
    template_name = 'leads/obrigado.html'
