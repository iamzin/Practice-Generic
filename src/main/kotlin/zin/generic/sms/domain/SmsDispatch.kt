package zin.generic.sms.domain

import jakarta.persistence.Entity
import zin.generic.CreateDispatch
import zin.generic.Dispatch

@Entity
class SmsDispatch(
    id: Long? = null,
    account: PhoneNumber,
    message: String,
    purpose: SmsPurpose,
) : Dispatch<PhoneNumber, SmsPurpose>(id, account, message, purpose) {
    companion object : CreateDispatch<SmsDispatch, PhoneNumber, SmsPurpose> {
        override fun create(
            account: PhoneNumber,
            message: String,
            purpose: SmsPurpose,
        ) = SmsDispatch(account = account, message = message, purpose = purpose)
    }
}
