package zin.generic

interface CreateDispatch<D : Dispatch<A, P>, A : Account, P : Purpose> {
    fun create(
        account: A,
        message: String,
        purpose: P,
    ): D
}
