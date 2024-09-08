package zin.generic.email.domain

import jakarta.persistence.Column
import zin.generic.Account

class EmailAddress(
    @Column(name = "_value")
    override var value: String,
) : Account(value)
