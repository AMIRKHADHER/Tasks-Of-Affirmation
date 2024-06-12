package com.exemple.toaexemple.login.repository

import com.exemple.toaexemple.core.data.DataResult
import com.exemple.toaexemple.login.domain.model.Credentials
import com.exemple.toaexemple.login.domain.model.LoginResponse

interface LoginRepository {

    suspend fun login(
        credentials: Credentials,
    ): DataResult<LoginResponse>

    fun storeAuthToken(
        authToken: String
    )
}
