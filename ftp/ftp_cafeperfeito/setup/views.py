from smtplib import SMTPException

from django.core import mail
from django.core.mail import EmailMessage, BadHeaderError
from django.template.loader import get_template
from django.views.generic import TemplateView


class HelloWorldView(TemplateView):
    template_name = 'setup/helloworld.html'


class PoliticaPrivacidade(TemplateView):
    template_name = 'setup/politica-privacidade.html'


def enviando_mails(request, lead_name, lead_phone, lead_email, urlLP):
    context = {
        'leadname': lead_name,
        'leadphone': lead_phone,
        'leademail': lead_email,
        'landing-page': urlLP,
    }

    message = get_template('leads/lead-mail.html').render(context)

    connection = mail.get_connection()
    connection.open()

    email0 = EmailMessage(
        'Novo Lead - {} [{}]'.format(lead_name, lead_phone),
        message,
        None,
        ['leads@cafeperfeito.com.br']
    )
    email0.content_subtype = 'html'

    email1 = EmailMessage(
        'Recebemos seu cadastro',
        message,
        None,
        [lead_email]
    )
    email1.content_subtype = 'html'

    # print(context)

    try:
        connection.send_messages([email0])
    except BadHeaderError:  # If mail's Subject is not properly formatted.
        print('Invalid header found.')
        return
    except SMTPException as e:  # It will catch other errors related to SMTP.
        print('There was an error sending an email.' + e)
        return
    except:  # It will catch All other possible errors.
        print("Mail Sending Failed!")
        return
    # connection.send_messages([email0, email1])

    connection.close()

    # print('emails enviados!!!!')
