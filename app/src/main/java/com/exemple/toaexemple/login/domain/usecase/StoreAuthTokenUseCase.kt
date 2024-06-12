package com.exemple.toaexemple.login.domain.usecase

interface StoreAuthTokenUseCase {
    suspend operator fun invoke(
        authToken: String
    )
}
