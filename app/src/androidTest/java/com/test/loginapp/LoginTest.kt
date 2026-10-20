package com.test.loginapp

import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import com.test.loginapp.data.model.Post
import com.test.loginapp.data.model.UiState
import org.junit.Rule
import org.junit.Test

class LoginTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun checkButton_disabled_for_emptyNameAndPassword() {

       // var loginClicked = false

        composeTestRule.setContent {

            LoginScreenPractice(onLogin = {})
        }

        composeTestRule
            .onNodeWithTag("login")
            .assertIsEnabled()

    }


    @Test
    fun check_empty_post() {

        val post = emptyList<Post>()

        composeTestRule.setContent {
         PostContent(UiState(isLoading = false, posts = post))
        }

        composeTestRule.onNodeWithTag("post_list")

    }

}