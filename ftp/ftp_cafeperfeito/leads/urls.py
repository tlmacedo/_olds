from django.urls import path

from leads.views import LeadsObriagoTemplateView

app_name = 'leads'

urlpatterns = [
    path('obrigado/', LeadsObriagoTemplateView.as_view(), name='leads-obrigado'),
]
