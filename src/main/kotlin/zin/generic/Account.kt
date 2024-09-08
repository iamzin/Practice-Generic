package zin.generic

import jakarta.persistence.Embeddable

@Embeddable
abstract class Account(
    open var value: String,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Account) return false

        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }

    override fun toString(): String {
        return value
    }
}
