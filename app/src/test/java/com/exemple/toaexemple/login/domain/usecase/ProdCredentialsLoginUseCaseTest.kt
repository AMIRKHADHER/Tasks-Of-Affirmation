package com.exemple.toaexemple.login.domain.usecase

import com.exemple.toaexemple.core.data.DataResult
import com.exemple.toaexemple.login.domain.fakes.FakeAuthTokenRepository
import com.exemple.toaexemple.login.domain.fakes.FakeLoginRepository
import com.exemple.toaexemple.login.domain.model.AuthToken
import com.exemple.toaexemple.login.domain.model.Credentials
import com.exemple.toaexemple.login.domain.model.Email
import com.exemple.toaexemple.login.domain.model.LoginResponse
import com.exemple.toaexemple.login.domain.model.LoginResult
import com.exemple.toaexemple.login.domain.model.Password
import com.exemple.toaexemple.login.domain.model.RefreshToken
import com.exemple.toaexemple.login.domain.model.Token
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class ProdCredentialsLoginUseCaseTest {
    private val defaultCredentials = Credentials(
        email = Email("testy@mctestface.com"),
        password = Password("Hunter2"),
    )

    private val defaultToken = Token(
        authToken = AuthToken("Auth"),
        refreshToken = RefreshToken("Refresh"),
    )

    private lateinit var loginRepository: FakeLoginRepository
    private lateinit var tokenRepository: FakeAuthTokenRepository

    @Before
    fun setUp() {
        loginRepository = FakeLoginRepository()
        tokenRepository = FakeAuthTokenRepository()
    }

    @Test
    fun `test succssful login`() = runTest {
        val response = LoginResponse(
            authToken = Token(
                authToken = AuthToken(""),
                refreshToken = RefreshToken("")
            )
        )
        val result = DataResult.Success(response)

        val loginRepository = FakeLoginRepository().apply {
            mockLoginWithCredentials(
                credentials = defaultCredentials,
                result = result
            )
        }

        val prodCredentialsLoginUseCase = ProdCredentialsLoginUseCase(
            loginRepository = loginRepository.mock,
            authTokenRepository = tokenRepository.mock
        )
        val expexteResult = prodCredentialsLoginUseCase(
            Credentials(
                Email(""),
                Password("")
            )
        )
        assertThat(expexteResult).isEqualTo(
            LoginResult.Success
        )
    }
}
