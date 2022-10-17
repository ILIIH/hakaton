package com.example.auth_domain.models.models

sealed class loginState<T>(
    val data: T? = null,
    val error: ErrorEntity? = null
) {
    class Success<T>(data: T? = null) : loginState<T>(data)
    class Error<T>(throwable: ErrorEntity, data: T? = null) : loginState<T>(data, throwable)
}

sealed class ErrorEntity {

    data class DataBaceError(val measage: String = "Internal database Error ") : ErrorEntity()

    data class WrongCredentialsUsername(val measage: String = "Wrong credentials email error") : ErrorEntity()

    data class WrongCredentialsPassword(val measage: String = "Wrong credentials password error") : ErrorEntity()

    data class WrongLoginOrPass(val measage: String = "Wrong login or password error") : ErrorEntity()
}
