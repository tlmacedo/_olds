from django import forms
from django.forms import ModelForm, TextInput

from leads.models import Lead


class FormLeads(ModelForm):
    nome = forms.CharField(
        required='True',
        label='Nome',
        max_length=120,
    )
    fone = forms.CharField(
        required='True',
        label='Fone',
        max_length=15,
        widget=TextInput(attrs={'type':'tel', 'class': 'text-end phone_with_ddd'}),
    )
    email = forms.EmailField(
        required='True',
        label='Email',
        max_length=250,
        # blank=True,
        # null=True,
    )

    class Meta:
        model = Lead

        fields = ['nome', 'fone', 'email']

        # widgets = {
        #     # 'senha': forms.PasswordInput(),
        #     'fone': TextInput(attrs={'data-mask':'(00) 00000-0000'}),
        # }

    # def valida_usuario(self):
    #     mailusuario = self.cleaned_data.get('email')
    #     nsenha = self.cleaned_data.get('senha')
    #     try:
    #         if not '@' in mailusuario:
    #             usuario = Usuario.objects.get(id=Colaborador.objects.get(apelido=mailusuario))
    #         else:
    #             usuario = Usuario.objects.get(email=mailusuario)
    #         if usuario is not None:
    #             if django_pbkdf2_sha256.verify(nsenha, usuario.senha) is True:
    #                 # print('Senha Validada com sucesso!!!!!!!!!!!!!!!!!!!!!!!!')
    #                 return usuario
    #             else:
    #                 print('Senha inválida')
    #                 return False
    #     except Colaborador.DoesNotExist or Usuario.DoesNotExist:
    #         return None
    #     pass
