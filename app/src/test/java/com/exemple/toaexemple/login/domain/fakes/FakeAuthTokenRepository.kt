package com.exemple.toaexemple.login.domain.fakes

import com.exemple.toaexemple.login.domain.model.Token
import com.exemple.toaexemple.login.repository.AuthTokenRepository
import io.mockk.coVerify
import io.mockk.mockk

class FakeAuthTokenRepository {
    val mock: AuthTokenRepository = mockk(relaxed = true)

    fun verifyTokenStored(authToken: Token) {
        coVerify {
            mock.storeAuthToken(authToken)
        }
    }
    fun verifyNoTokenStored() {
        coVerify(exactly = 0) {
            mock.storeAuthToken(any())
        }
    }
}
