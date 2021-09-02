from django.urls import path

from adsGoogle.views import AdsCafeEmGraoFormView, AdsCafeArabicaFormView, \
    AdsCafeCafeteriaFormView, AdsCafeCafeteiraFormView, AdsCafeExpressoFormView, \
    AdsComprarCafeArabicaGraoFormView, AdsComprarCafeCafeteriaFormView, \
    AdsComprarCafeEspecialFormView, AdsComprarCafeGraoFormView, \
    AdsComprarCafeGraoOnlineFormView, AdsComprarCafeParaExpressoFormView, \
    AdsComprarCafeRestauranteFormView, AdsComprarCafeTorradoGraoFormView, \
    AdsLpCafeGrao_FormView

app_name = 'adsGoogle'

urlpatterns = [
    # path('comprar-cafe-arabica-grao/', AdsComprarCafeArabicaGraoFormView.as_view(),
    #      name='adsg-comprar-cafe-arabica-grao'),
    # path('comprar-cafe-cafeteria/', AdsComprarCafeCafeteriaFormView.as_view(), name='adsg-comprar-cafe-cafeteria'),
    # path('comprar-cafe-especial/', AdsComprarCafeEspecialFormView.as_view(), name='adsg-comprar-cafe-especial'),
    # path('comprar-cafe-grao/', AdsComprarCafeGraoFormView.as_view(), name='adsg-comprar-cafe-grao'),
    # path('comprar-cafe-grao-online/', AdsComprarCafeGraoOnlineFormView.as_view(), name='adsg-comprar-cafe-grao-online'),
    # path('comprar-cafe-para-expresso/', AdsComprarCafeParaExpressoFormView.as_view(),
    #      name='adsg-comprar-cafe-para-expresso'),
    # path('comprar-cafe-restaurante/', AdsComprarCafeRestauranteFormView.as_view(),
    #      name='adsg-comprar-cafe-restaurante'),
    # path('comprar-cafe-torrado-grao/', AdsComprarCafeTorradoGraoFormView.as_view(),
    #      name='adsg-comprar-cafe-torrado-grao'),
    #
    # path('cafe-em-grao/', AdsCafeEmGraoFormView.as_view(), name='adsg-cafe-em-grao'),
    # path('cafe-arabica/', AdsCafeArabicaFormView.as_view(), name='adsg-cafe-arabica'),
    # path('cafe-cafeteria/', AdsCafeCafeteriaFormView.as_view(), name='adsg-cafe-cafeteria'),
    # path('cafe-cafeteira/', AdsCafeCafeteiraFormView.as_view(), name='adsg-cafe-cafeteira'),
    # path('cafe-expresso/', AdsCafeExpressoFormView.as_view(), name='adsg-cafe-expresso'),

    path('cafe-grao/', AdsLpCafeGrao_FormView.as_view(), name='lp-cafe-grao'),


]
