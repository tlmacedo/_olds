from django.conf import settings
from django.conf.urls import url
from django.contrib.auth import logout
from django.contrib.auth.views import LogoutView
from django.urls import path

from sidtm.views import LoginFormView, HomeTemplateView, HomeTemplateViewTest, logout_request

app_name = 'sidtm'

urlpatterns = [
    path('', LoginFormView.as_view(), name='login'),
    path('home/', HomeTemplateView.as_view(), name='home'),
    path('home-test/', HomeTemplateViewTest.as_view(), name='home-test'),
    path('logout', logout_request, name='logout'),
]
