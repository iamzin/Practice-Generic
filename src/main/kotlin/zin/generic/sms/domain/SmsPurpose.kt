package zin.generic.sms.domain

import zin.generic.Purpose

enum class SmsPurpose : Purpose {
    PASSWORD_RESET,
    ACCOUNT_ACTIVATION,
}
