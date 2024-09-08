package zin.generic.sms.application

import org.springframework.stereotype.Service
import zin.generic.DispatchService
import zin.generic.sms.domain.PhoneNumber
import zin.generic.sms.domain.SmsDispatch
import zin.generic.sms.domain.SmsPurpose
import zin.generic.sms.domain.repository.SmsRepository

@Service
class SmsService(
    smsRepository: SmsRepository,
) : DispatchService<SmsDispatch, PhoneNumber, SmsPurpose>(smsRepository)
