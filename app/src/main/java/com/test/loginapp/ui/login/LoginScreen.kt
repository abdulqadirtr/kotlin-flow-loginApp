package com.test.loginapp.ui.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.test.loginapp.ui.theme.LoginAppTheme


@Composable
fun LoginScreen(onLoginScreen : () -> Unit ) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }


    // Button will be true only if both fields have text (excluding spaces)
    val isButtonEnabled = username.isNotBlank() && password.isNotBlank()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top

    ) {

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
                .testTag("usernameInput")
        )

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
                .testTag("passwordInput")
        )


        Button(
            onClick = { onLoginScreen() },
            modifier = Modifier
                .fillMaxWidth()
                .testTag("loginButton"),
            enabled = isButtonEnabled
        ) {
            Text("Login")
        }

        HeaderCard("Welcome") { }
    }
}

@Composable
fun HeaderCard(title: String,
               onButtonClick: () -> Unit ) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .testTag("headerColumn")
    ) {
        Text(
            text = title,
            modifier = Modifier.testTag("headerTitle")
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = onButtonClick,
            modifier = Modifier.testTag("actionButton")
        ) {
            Text("Click Me")
        }
    }

}


@Composable
fun LoginScreenPractice(
    onLogin: () -> Unit
) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val enabled = username.isNotBlank() && password.isNotBlank()

    Column {
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            modifier = Modifier.testTag("username")
        )

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            modifier = Modifier.testTag("password")
        )

        Button(
            onClick = onLogin,
            enabled = enabled,
            modifier = Modifier.testTag("login")
        ) {
            Text("Login")
        }
    }
}



@Preview(showBackground = true)
@Composable
fun LoginScreen() {
    LoginAppTheme {
        // LoginScreen()
    }
}