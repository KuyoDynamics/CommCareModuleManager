package com.kuyodynamics.commcaresurveymanager.network

/**
 * A generic class that holds a value with its loading status.
 * @param <T>
 */
sealed class ResultDTO<out T : Any> {

    data class Success<out T : Any>(val data: T) : ResultDTO<T>()
    data class Error(val exception: Exception) : ResultDTO<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
        }
    }
}