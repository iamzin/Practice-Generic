package zin.generic.email.domain.repository

import zin.generic.DispatchRepository
import zin.generic.email.domain.EmailAddress
import zin.generic.email.domain.EmailDispatch
import zin.generic.email.domain.EmailPurpose

interface EmailRepository : DispatchRepository<EmailDispatch, EmailAddress, EmailPurpose> {
    override fun findByAccount(account: EmailAddress): EmailDispatch?
}
