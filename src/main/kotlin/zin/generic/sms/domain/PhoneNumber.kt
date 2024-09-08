package zin.generic.sms.domain

import jakarta.persistence.Column
import zin.generic.Account

class PhoneNumber(
    @Column(name = "_value")
    override var value: String,
) : Account(value)
