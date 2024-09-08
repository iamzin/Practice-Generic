package zin.generic.sms.domain.repository

import zin.generic.DispatchRepository
import zin.generic.sms.domain.PhoneNumber
import zin.generic.sms.domain.SmsDispatch
import zin.generic.sms.domain.SmsPurpose

interface SmsRepository : DispatchRepository<SmsDispatch, PhoneNumber, SmsPurpose> {
    override fun findByAccount(account: PhoneNumber): SmsDispatch?
}
