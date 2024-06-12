package com.exemple.toaexemple.login.ui

import com.exemple.toaexemple.login.domain.model.Email
import com.exemple.toaexemple.login.domain.model.Password

data class LoginViewState(
    val username: Email,
    val password: Password,
    val showProgressBar: Boolean = false
)
