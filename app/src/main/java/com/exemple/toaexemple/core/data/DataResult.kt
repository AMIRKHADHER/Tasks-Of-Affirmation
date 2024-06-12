package com.exemple.toaexemple.core.data

sealed class DataResult<out T> {
    data class Success<out T>(val data: T) : DataResult<T>()
    data class Error<out T>(val error: Throwable) : DataResult<Nothing>()
}

