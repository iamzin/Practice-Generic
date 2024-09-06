package zin.generic.sms.domain

import zin.generic.Account

class PhoneNumber(
    override var account: String,
) : Account(account)
