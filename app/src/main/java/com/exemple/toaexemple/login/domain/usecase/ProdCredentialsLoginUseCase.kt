package com.exemple.toaexemple.login.domain.usecase

import com.exemple.toaexemple.core.data.DataResult
import com.exemple.toaexemple.login.domain.model.AuthToken
import com.exemple.toaexemple.login.domain.model.Credentials
import com.exemple.toaexemple.login.domain.model.InvalidCredentialsException
import com.exemple.toaexemple.login.domain.model.LoginResult
import com.exemple.toaexemple.login.domain.model.RefreshToken
import com.exemple.toaexemple.login.domain.model.Token
import com.exemple.toaexemple.login.repository.AuthTokenRepository
import com.exemple.toaexemple.login.repository.LoginRepository

class ProdCredentialsLoginUseCase(
    private val loginRepository: LoginRepository,
    private val authTokenRepository: AuthTokenRepository
) : LoginUseCase {
    override suspend fun invoke(credentials: Credentials): LoginResult {
        val loginResult = loginRepository.login(credentials = credentials)
        when (loginResult) {
            is DataResult.Success -> {
                authTokenRepository.storeAuthToken(
                    authToken = Token(
                        authToken = AuthToken(""),
                        refreshToken = RefreshToken("")
                    )
                )
                return LoginResult.Success
            }
            is DataResult.Error<*> -> {
                return when (loginResult.error) {
                    is InvalidCredentialsException -> {
                        LoginResult.Failure.InvalidCredentials
                    }

                    else -> {
                        LoginResult.Failure.Unknown
                    }
                }
            }
        }
    }
}
