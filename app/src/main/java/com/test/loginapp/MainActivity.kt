package com.test.loginapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
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
import com.test.loginapp.domain.navigation.AppNavigation
import com.test.loginapp.ui.theme.LoginAppTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainApp()

                   // TestRemeberCoroutineScope()
                }
            }
        }
    }
}


@Composable
fun TestRemeberCoroutineScope(modifier: Modifier = Modifier) {

    val snackbarHostState = remember {
        SnackbarHostState()
    }

    val scope = rememberCoroutineScope()


    Scaffold(
        snackbarHost = {
            SnackbarHost(snackbarHostState)
        }
    ) { padding ->

        Button(
            modifier = Modifier.padding(padding),
            onClick = {
                scope.launch {
                    snackbarHostState.showSnackbar(
                        "Saved successfully"
                    )
                }
            }
        ){

            Text("Save")
        }

    }

    }




@Composable
fun TestLaunchEffect(modifier: Modifier = Modifier) {

  //  val counter by remember { mutableStateOf(0) }

    var count by remember {
        mutableStateOf(0)
    }

    LaunchedEffect(count) {

        Log.e("counter 1","launch effect value changed")

    }

    Button(onClick = {count++}, modifier = Modifier
        .fillMaxWidth()
        .padding(20.dp)) {

      //  count++
       // print("Counter value changed ${counter}")
        Log.e("counter 2","counter ${count}")


    }

}


// ---- PARENT: Holds the state ----
@Composable
fun MainApp() {
   /* var showPosts by remember { mutableStateOf(false) }

    if (showPosts) {
        PostScreen()
    } else {
        LoginScreen(
            onLoginScreen = {
                showPosts = true
            }
        )
    }*/

    AppNavigation()

}



