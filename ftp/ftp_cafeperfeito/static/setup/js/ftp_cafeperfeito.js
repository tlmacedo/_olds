// alert('Hello world!!!')

function showingPassword() {
    let $pwd = document.getElementById('password');
    let $chk = document.getElementById('showPassword');

    if ($chk.checked)
        $pwd.type = 'text';
    else
        $pwd.type = 'password';
}

var header = $('.header-base');
$(window).scroll(function (e) {
    if (header.offset().top !== 0) {
        if (!header.hasClass('shadow')) {
            header.addClass('shadow');
        }
    } else {
        header.removeClass('shadow');
    }
})


// $(function () {
//     alert('tentando')
//     var $pwd = $('#password');
//     var $chk = $('#showPassword');
//
//     $chk.on('change', function () {
//         alert('olá')
//         try {
//             $pwd.prop('type', ($chk.prop('checked') ? 'text' : 'password'))
//         } catch (error) {
//             alert('não é possivel mudar o tipo de visão!!')
//         }
//     })
// })


// $(document).ready(function () {
//     $('.numero').mask('000000000000000000000000000000')
//     $('.date').mask('00/00/0000');
//     $('.time').mask('00:00:00');
//     $('.date_time').mask('00/00/0000 00:00:00');
//     $('.cep').mask('00000-000');
//     $('.phone').mask('0000-0000');
//     $('.phone_with_ddd').mask('(00) 00000-0000');
//     $('.phone_us').mask('(000) 000-0000');
//     $('.cpf').mask('000.000.000-00', {reverse: true});
//     $('.cnpj').mask('00.000.000/0000-00', {placeholder: '__.___.___/____-__'});
//     $('.money').mask('000.000.000.000.000,00', {reverse: true});
//     $('.money2').mask('#.##0,00', {reverse: true});
//     $('.peso3').mask('#.##0,000', {reverse: true});
//     $('.ip_address').mask('0ZZ.0ZZ.0ZZ.0ZZ', {
//         translation: {
//             'Z': {
//                 pattern: /[0-9]/, optional: true
//             }
//         }
//     });
//     $('.ip_address').mask('099.099.099.099');
//     $('.percent').mask('##0,00%', {reverse: true});
//     $('.clear-if-not-match').mask('00/00/0000', {clearIfNotMatch: true});
//     $('.placeholder').mask('00/00/0000', {placeholder: '__/__/____'});
//     $('.fallback').mask('00r00r0000', {
//         translation: {
//             'r': {
//                 pattern: /[\/]/,
//                 fallback: '/'
//             },
//             placeholder: '__/__/____'
//         }
//     });
//     $('.selectonfocus').mask('00/00/0000', {selectOnFocus: true});
//
//     $('.mixed').mask('AAA 000-S0S');
// });


