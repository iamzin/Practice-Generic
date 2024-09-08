package zin.generic

import org.springframework.transaction.annotation.Transactional
import java.lang.reflect.ParameterizedType
import kotlin.reflect.KClass
import kotlin.reflect.full.companionObject

@Transactional
abstract class DispatchService<D : Dispatch<A, P>, A : Account, P : Purpose>(
    private val dispatchRepository: DispatchRepository<D, A, P>,
) {
    init {
        (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments.also { typeArguments ->
            dispatchClass = (typeArguments[0] as Class<D>).kotlin
        }
    }

    private var dispatchClass: KClass<D>

    fun register(
        account: A,
        message: String,
        purpose: P,
    ): D {
        val companionObject: KClass<*> = dispatchClass.companionObject!!
        val instance = companionObject.objectInstance!! as CreateDispatch<D, A, P>

        val dispatch: D = instance.create(account, message, purpose)
        return dispatchRepository.save(dispatch)
    }

    fun send(account: A): String {
        val dispatch: D =
            dispatchRepository.findByAccount(account)
                ?: throw IllegalArgumentException("$account not found")

        return dispatch.buildRequest()
            .also { println(it) }
    }
}
