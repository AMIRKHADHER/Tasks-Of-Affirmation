package com.exemple.toaexemple.ui.login

import androidx.compose.runtime.Composable

@Composable
fun LoginScreen(){
    LoginContent(
        viewState = LoginViewState(
            password = "",
            username = ""
        )
    )

}