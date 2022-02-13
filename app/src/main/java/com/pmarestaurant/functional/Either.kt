package com.pmarestaurant.functional

import java.lang.Exception

open class Either<out T> {
    data class Success<T>(val data: T) : Either<T>()
    data class Error(val exception: Exception) : Either<Nothing>()
}