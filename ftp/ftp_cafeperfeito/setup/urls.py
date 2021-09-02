"""setup URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/3.2/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  path('', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  path('', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.urls import include, path
    2. Add a URL to urlpatterns:  path('blog/', include('blog.urls'))
"""
from django.conf import settings
from django.conf.urls.static import static
from django.contrib import admin
from django.urls import path, include

from setup.views import HelloWorldView, PoliticaPrivacidade

app_label = 'setup'

urlpatterns = [
    path('admin/', admin.site.urls),
    path('sidtm/', include('sidtm.urls')),
    path('lp/', include('adsGoogle.urls')),
    # path('adsg/', include('adsGoogle.urls')),
    # path('leads/', include('leads.urls')),
    # path('', HelloWorldView.as_view(), name='hello'),
    path('politica-privacidade/', PoliticaPrivacidade.as_view(), name='privacy-policy'),
]

if settings.DEBUG:
    urlpatterns = urlpatterns + static(settings.STATIC_URL, document_root=settings.STATIC_ROOT)
    # urlpatterns = urlpatterns + static(settings.MEDIA_URL, document_root=settings.MEDIA_ROOT)
