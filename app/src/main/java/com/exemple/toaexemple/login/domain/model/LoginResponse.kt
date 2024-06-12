package com.exemple.toaexemple.login.domain.model

data class LoginResponse(
    val authToken: Token
)

sealed class LoginResult() {
    object  Success : LoginResult()

    sealed class Failure : LoginResult() {
        object InvalidCredentials : Failure()
        object Unknown : Failure()
    }
}