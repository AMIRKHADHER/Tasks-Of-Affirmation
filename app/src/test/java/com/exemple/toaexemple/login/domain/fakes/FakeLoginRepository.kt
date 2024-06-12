package com.exemple.toaexemple.login.domain.fakes

import com.exemple.toaexemple.core.data.DataResult
import com.exemple.toaexemple.login.domain.model.Credentials
import com.exemple.toaexemple.login.domain.model.LoginResponse
import com.exemple.toaexemple.login.repository.LoginRepository
import io.mockk.coEvery
import io.mockk.mockk

class FakeLoginRepository {
    val mock: LoginRepository = mockk()

    fun mockLoginWithCredentials(
        credentials: Credentials,
        result: DataResult<LoginResponse>
    ) {
        coEvery {
            mock.login(credentials)
        } returns result

    }
}