package com.exemple.toaexemple.ui.login

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.exemple.toaexemple.ui.components.PrimaryButton
import com.exemple.toaexemple.ui.components.SecondaryButton
import com.exemple.toaexemple.ui.theme.TOAExempleTheme

@Composable
fun LoginContent(
    viewState: LoginViewState
) {
    Scaffold(
        contentColor = MaterialTheme.colorScheme.primary
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),


        ) {
            Spacer(modifier = Modifier.weight(1f))
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
    loginViewState: LoginViewState,
) {
    TOAExempleTheme {
        LoginContent(
            viewState = LoginViewState(
                username = "",
                password = ""
            )
        )
    }
}