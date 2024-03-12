package com.mozverse.mozimtestapp.domain.usecase

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

@OptIn(ExperimentalContracts::class)
sealed class DataState<T> {
    class Loading<T> : DataState<T>()

    class EmptyData<T> : DataState<T>()
    data class Error<T>(val exception: Throwable) : DataState<T>()

    data class Success<T>(val data: T) : DataState<T>()


    fun isLoading(): Boolean {
        contract {
            returns(true) implies (this@DataState is Loading)
        }
        return this is Loading
    }

    fun isEmptyData(): Boolean {
        contract {
            returns(true) implies (this@DataState is EmptyData)
        }
        return this is EmptyData
    }

    fun isSuccess(): Boolean {
        contract {
            returns(true) implies (this@DataState is Success)
        }
        return this is Success
    }

    fun data(): T? {
        contract {
            returnsNotNull() implies (this@DataState is Success)
        }
        return if (this is Success) this.data else null
    }

    fun isError(): Boolean {
        contract {
            returns(true) implies (this@DataState is Error)
        }
        return this is Error
    }

    fun errorMessage(): String? {
        contract {
            returnsNotNull() implies (this@DataState is Error)
        }
        return if (this is Error) this.exception.message else null
    }

    fun exception(): Throwable? {
        contract {
            returnsNotNull() implies (this@DataState is Error)
        }
        return if (this is Error) this.exception else null
    }

}