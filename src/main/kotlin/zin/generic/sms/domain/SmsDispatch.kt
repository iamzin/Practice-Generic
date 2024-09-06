package zin.generic.sms.domain

import jakarta.persistence.*
import zin.generic.Dispatch

@Entity
class SmsDispatch(
    id: Long? = null,
    account: PhoneNumber,
    message: String,
    purpose: SmsPurpose,
) : Dispatch<PhoneNumber, SmsPurpose>(id, account, message, purpose) {
    companion object {
        fun create(
            account: PhoneNumber,
            message: String,
            purpose: SmsPurpose,
        ) = SmsDispatch(account = account, message = message, purpose = purpose)
    }
}
