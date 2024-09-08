package zin.generic.email.application

import org.springframework.stereotype.Service
import zin.generic.DispatchService
import zin.generic.email.domain.EmailAddress
import zin.generic.email.domain.EmailDispatch
import zin.generic.email.domain.EmailPurpose
import zin.generic.email.domain.repository.EmailRepository

@Service
class EmailService(
    emailRepository: EmailRepository,
) : DispatchService<EmailDispatch, EmailAddress, EmailPurpose>(emailRepository) {
    override fun createDispatch(
        account: EmailAddress,
        message: String,
        purpose: EmailPurpose,
    ): EmailDispatch {
        return EmailDispatch(account = account, message = message, purpose = purpose)
    }
}
