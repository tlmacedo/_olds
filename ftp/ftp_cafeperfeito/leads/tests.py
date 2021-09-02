from facebook_business.api import FacebookAdsApi
from facebook_business.adobjects.adaccount import AdAccount

from setup import settings

my_app_id = '152615743520803'
my_app_secret = '{appsecret}'
my_access_token = settings.FACEBOOK_ACCESS_TOKEN
FacebookAdsApi.init(my_app_id, my_app_secret, my_access_token)
my_account = AdAccount('act_{{adaccount-id}}')
campaigns = my_account.get_campaigns()
print(campaigns)