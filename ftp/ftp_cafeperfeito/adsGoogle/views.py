from django.urls import reverse_lazy
from django.views.generic import TemplateView, FormView

from leads.forms import FormLeads
from leads.views import cadastrar_lead


class ObrigadoView(TemplateView):
    template_name = 'leads/obrigado.html'


class AdsLpCafeGrao_FormView(FormView):
    form_class = FormLeads
    context = {'form': form_class}
    template_name = 'landing-page/lp-cafe-grao.html'
    success_url = reverse_lazy('leads:leads-obrigado')

    def post(self, request, *args, **kwargs):
        return cadastrar_lead(self, request, 'adsLpCafeGrao')


class AdsComprarCafeArabicaGraoFormView(FormView):
    form_class = FormLeads
    context = {'form': form_class}
    template_name = 'adsg/comprar-cafe-arabica-grao.html'
    success_url = reverse_lazy('leads:leads-obrigado')

    def post(self, request, *args, **kwargs):
        return cadastrar_lead(self, request, 'adsComprarCafeArabicaGrao')

class AdsComprarCafeCafeteriaFormView(FormView):
    form_class = FormLeads
    context = {'form': form_class}
    template_name = 'adsg/comprar-cafe-cafeteria.html'
    success_url = reverse_lazy('leads:leads-obrigado')

    def post(self, request, *args, **kwargs):
        return cadastrar_lead(self, request, 'adsComprarCafeCafeteria')

class AdsComprarCafeEspecialFormView(FormView):
    form_class = FormLeads
    context = {'form': form_class}
    template_name = 'adsg/comprar-cafe-especial.html'
    success_url = reverse_lazy('leads:leads-obrigado')

    def post(self, request, *args, **kwargs):
        return cadastrar_lead(self, request, 'adsComprarCafeEspecial')

class AdsComprarCafeGraoFormView(FormView):
    form_class = FormLeads
    context = {'form': form_class}
    template_name = 'adsg/comprar-cafe-grao.html'
    success_url = reverse_lazy('leads:leads-obrigado')

    def post(self, request, *args, **kwargs):
        return cadastrar_lead(self, request, 'adsComprarCafeGrao')

class AdsComprarCafeGraoOnlineFormView(FormView):
    form_class = FormLeads
    context = {'form': form_class}
    template_name = 'adsg/comprar-cafe-grao-online.html'
    success_url = reverse_lazy('leads:leads-obrigado')

    def post(self, request, *args, **kwargs):
        return cadastrar_lead(self, request, 'adsComprarCafeGraoOnline')

class AdsComprarCafeParaExpressoFormView(FormView):
    form_class = FormLeads
    context = {'form': form_class}
    template_name = 'adsg/comprar-cafe-para-expresso.html'
    success_url = reverse_lazy('leads:leads-obrigado')

    def post(self, request, *args, **kwargs):
        return cadastrar_lead(self, request, 'adsComprarCafeParaExpresso')

class AdsComprarCafeRestauranteFormView(FormView):
    form_class = FormLeads
    context = {'form': form_class}
    template_name = 'adsg/comprar-cafe-restaurante.html'
    success_url = reverse_lazy('leads:leads-obrigado')

    def post(self, request, *args, **kwargs):
        return cadastrar_lead(self, request, 'adsComprarCafeRestaurante')

class AdsComprarCafeTorradoGraoFormView(FormView):
    form_class = FormLeads
    context = {'form': form_class}
    template_name = 'adsg/comprar-cafe-torrado-grao.html'
    success_url = reverse_lazy('leads:leads-obrigado')

    def post(self, request, *args, **kwargs):
        return cadastrar_lead(self, request, 'adsComprarCafeTorradoGrao')








class AdsCafeEmGraoFormView(FormView):
    form_class = FormLeads
    context = {'form': form_class}
    template_name = 'adsg/cafe-em-grao.html'
    success_url = reverse_lazy('leads:leads-obrigado')

    def post(self, request, *args, **kwargs):
        return cadastrar_lead(self, request, 'adsCafeEmGrao')


class AdsCafeArabicaFormView(FormView):
    form_class = FormLeads
    context = {'form': form_class}
    template_name = 'adsg/cafe-arabica.html'
    success_url = reverse_lazy('leads:leads-obrigado')

    def post(self, request, *args, **kwargs):
        return cadastrar_lead(self, request, 'adsCafeArabica')


class AdsCafeCafeteriaFormView(FormView):
    form_class = FormLeads
    context = {'form': form_class}
    template_name = 'adsg/cafe-cafeteria.html'
    success_url = reverse_lazy('leads:leads-obrigado')

    def post(self, request, *args, **kwargs):
        return cadastrar_lead(self, request, 'adsCafeCafeteria')


class AdsCafeCafeteiraFormView(FormView):
    form_class = FormLeads
    context = {'form': form_class}
    template_name = 'adsg/cafe-cafeteira.html'
    success_url = reverse_lazy('leads:leads-obrigado')

    def post(self, request, *args, **kwargs):
        return cadastrar_lead(self, request, 'adsCafeCafeteira')


class AdsCafeExpressoFormView(FormView):
    form_class = FormLeads
    context = {'form': form_class}
    template_name = 'adsg/cafe-expresso.html'
    success_url = reverse_lazy('leads:leads-obrigado')

    def post(self, request, *args, **kwargs):
        return cadastrar_lead(self, request, 'adsCafeExpresso')
