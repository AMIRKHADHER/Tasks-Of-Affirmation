package com.exemple.toaexemple.login.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.exemple.toaexemple.login.domain.model.Email
import com.exemple.toaexemple.login.domain.model.Password

@Composable
fun LoginScreen(){
    LoginContent(
        viewState = LoginViewState(
            password = Password(""),
            username = Email("")
        ),
        onLoginClicked = {},
        onPasswordChanged = {},
        modifier = Modifier,
        onEmailChanged = {},
        onSignUpClicked = {}
    )

}