package zin.generic

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.NoRepositoryBean

@NoRepositoryBean
interface DispatchRepository<D : Dispatch<A, P>, A : Account, P : Purpose> : JpaRepository<D, Long> {
    fun findByAccount(account: A): D?
}
