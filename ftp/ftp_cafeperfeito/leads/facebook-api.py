
from facebook_business.adobjects.adaccount import AdAccount
from facebook_business.adobjects.campaign import Campaign
from facebook_business.api import FacebookAdsApi

from setup import settings

access_token = settings.FACEBOOK_ACCESS_TOKEN
app_secret = '<APP_SECRET>'
app_id = '<APP_ID>'
id = '<AD_ACCOUNT_ID>'
FacebookAdsApi.init(access_token=access_token)

fields = [
]
params = {
  'name': 'My campaign',
  'objective': 'LINK_CLICKS',
  'status': 'PAUSED',
  'special_ad_categories': [],
}
print(AdAccount(id).create_campaign(
  fields=fields,
  params=params,
))

