package com.exemple.toaexemple.login.domain.usecase

import com.exemple.toaexemple.login.domain.model.Credentials
import com.exemple.toaexemple.login.domain.model.LoginResult

@JvmInline
value class Email(val value: String)

@JvmInline
value class Password(val value: String)
interface LoginUseCase {
    suspend operator fun invoke(
        credentials: Credentials
    ): LoginResult
}

/*
interface StoreTokenUseCase {
    suspend fun invoke(
        authToken: String
    )
}

class LoginUseCaseImpl(
    private val storeTokenUseCase: StoreTokenUseCase
) : LoginUseCase {
    override suspend fun invoke(email: Email, password: Password): LoginResult {
        storeTokenUseCase.invoke()
    }

}
*/
