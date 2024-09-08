package zin.generic

import org.springframework.transaction.annotation.Transactional

@Transactional
abstract class DispatchService<D : Dispatch<A, P>, A : Account, P : Purpose>(
    private val dispatchRepository: DispatchRepository<D, A, P>,
) {
    fun register(
        account: A,
        message: String,
        purpose: P,
    ): D {
        val dispatch: D = createDispatch(account, message, purpose)
        return dispatchRepository.save(dispatch)
    }

    fun send(account: A): String {
        val dispatch: D =
            dispatchRepository.findByAccount(account)
                ?: throw IllegalArgumentException("$account not found")

        return dispatch.buildRequest()
            .also { println(it) }
    }

    abstract fun createDispatch(
        account: A,
        message: String,
        purpose: P,
    ): D
}
