package com.exemple.toaexemple.login.ui

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.exemple.toaexemple.R
import com.exemple.toaexemple.login.domain.model.Email
import com.exemple.toaexemple.login.domain.model.Password
import com.exemple.toaexemple.ui.components.PrimaryButton
import com.exemple.toaexemple.ui.components.SecondaryButton
import com.exemple.toaexemple.ui.components.TOAExempleTextField
import com.exemple.toaexemple.ui.theme.TOAExempleTheme


private const val APP_LOGO_WIDTH_PERCENTAGE = 0.75F

@Composable
fun LoginContent(
    viewState: LoginViewState,
    onEmailChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onLoginClicked: () -> Unit,
    onSignUpClicked: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Surface(
        contentColor = MaterialTheme.colorScheme.primary
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),


        ) {
            Spacer(modifier = Modifier.weight(1f))
            AppLogo()
            TOAExempleTextField(text = viewState.username.value, onTextChanged = {}, labelText = "user name")
            TOAExempleTextField(text = viewState.password.value, onTextChanged = {}, labelText = "password")
            PrimaryButton(text = "Click me", onClick = { /*TODO*/ }
            )
            Spacer(modifier = Modifier.height(12.dp))
            SecondaryButton(
                text = "Singn in",
                onClick = { /*TODO*/ },
                contentColor = MaterialTheme.colorScheme.secondary
            )


        }
    }


}
@Composable
private fun AppLogo(
    modifier: Modifier = Modifier,
) {
    Image(
        painterResource(id = R.drawable.ic_toa_checkmark),
        contentDescription = stringResource(R.string.app_logo_content_description),
        modifier = modifier
            .fillMaxWidth(APP_LOGO_WIDTH_PERCENTAGE),
    )
}

@Preview(
    name = "Night Mode - Empty",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Preview(
    name = "Day Mode - Empty",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
)
@Suppress("UnusedPrivateMember")
@Composable
private fun LoginContentPreview(
    modifier: Modifier,
    onLoginClicked: () -> Unit,
    onSignUpClicked: () -> Unit,
    onPasswordChanged: (String) -> Unit,
    onEmailChanged: (String) -> Unit,
    viewState: LoginViewState
) {
    TOAExempleTheme {
        LoginContent(
            viewState = LoginViewState(
                username = Email(""),
                password = Password("")
            ),
            modifier = modifier,
            onLoginClicked = {},
            onPasswordChanged = {},
            onEmailChanged = {},
            onSignUpClicked = {}
        )
    }
}