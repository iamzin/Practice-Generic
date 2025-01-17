package zin.generic.email.application

import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestConstructor
import org.springframework.transaction.annotation.Transactional
import zin.generic.email.domain.EmailAddress
import zin.generic.email.domain.EmailDispatch
import zin.generic.email.domain.EmailPurpose

@SpringBootTest
@Transactional
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class EmailDispatchServiceTest(
    private val emailService: EmailService,
) {
    @Test
    fun `register and send email`() {
        val account = EmailAddress("eunzin.park@gmail.com")

        // register
        val emailDispatch: EmailDispatch = emailService.register(account, "Hello, World!", EmailPurpose.NEWSLETTER)

        emailDispatch.id shouldNotBe null
        // send
        val result: String = emailService.send(account)

        result shouldBe "Sending to $account with message: Hello, World!"
    }
}
