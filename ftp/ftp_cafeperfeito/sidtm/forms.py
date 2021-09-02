from django import forms
from django.forms import ModelForm, PasswordInput
from passlib.handlers.django import django_pbkdf2_sha256

from sidtm.models import Usuario


class FormLogin(ModelForm):
    email = forms.CharField(
        required='True',
        label='Email',
        max_length=250,
        # blank=True,
        # null=True,
    )
    senha = forms.CharField(
        required='True',
        label='Senha',
        max_length=20,
        widget=PasswordInput(attrs={'type': 'password'}),
    )

    class Meta:
        model = Usuario

        fields = ['email', 'senha']

    def validar_usuario(self):
        mail_usuario = self.cleaned_data.get('email')
        senha_usuario = self.cleaned_data.get('senha')
        try:
            if not '@' in mail_usuario:
                usuario = Usuario.objects.get(apelido=mail_usuario)
            else:
                usuario = Usuario.objects.get(email=mail_usuario)
            if usuario is not None:
                if django_pbkdf2_sha256.verify(senha_usuario, usuario.senha) is True:
                    return usuario
                else:
                    return False
        except Usuario.DoesNotExist:
            return None
        pass
