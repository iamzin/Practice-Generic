package zin.generic

abstract class DispatchService<D : Dispatch<A, P>, A : Account, P : Purpose, R : DispatchRepository<D, A, P>>(
    private val dispatchRepository: R,
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
