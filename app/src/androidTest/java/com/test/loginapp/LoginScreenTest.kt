package com.test.loginapp

import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.hasParent
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.isDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollTo
import androidx.compose.ui.test.performScrollToNode
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.printToLog
import androidx.lifecycle.viewmodel.compose.viewModel
import com.test.loginapp.data.model.Post
import com.test.loginapp.data.model.UiState
import com.test.loginapp.domain.PostViewModel
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test


class LoginScreenTest {


    @get:Rule
    val composeTestRule = createComposeRule()

    val repository = FakeRepository()

    val postViewModel = PostViewModel(repository)


    @Test
    fun loginWithValidCredentials_navigatesToPosts() {

        composeTestRule.setContent {
            MainApp()
        }

        // Enter username
        composeTestRule
            .onNodeWithTag("usernameInput")
            .performTextInput("emilys")

        // Enter password
        composeTestRule
            .onNodeWithTag("passwordInput")
            .performTextInput("1234")

        // Click Login
        composeTestRule
            .onNodeWithTag("loginButton")
            .performClick()

        composeTestRule.onRoot().printToLog("loginButton")

        // Verify Posts screen
        composeTestRule
            .onNodeWithTag("postScreen")
            .assertIsDisplayed()
    }


    @Test
    fun postTitle_isDisplayed()
    {

        val testPost = List(10){ index ->
            Post(index, "post_${index}")

        }

        composeTestRule.setContent {
            PostContent(UiState(posts = testPost))
        }

      //  Thread.sleep(1000)

        composeTestRule
            .onNodeWithTag("post_1")
            .performScrollTo()

        composeTestRule.onNodeWithTag("post_1")
            .assertIsDisplayed()
    }

    @Test
    fun whenPostsLoaded_displaysListAndScrollsToItem(){
        val testPost = List(100){ id ->
            Post(id = id, title = "post_$id")
        }

        // Act
        composeTestRule.setContent {
            PostContent(UiState(posts = testPost))
        }

        composeTestRule.onNodeWithTag("post_list")
            .performScrollToNode(hasTestTag("post_75"))

        // Verify item 75 is now visible after scrolling
        composeTestRule
            .onNodeWithTag("post_75")
            .assertIsDisplayed()

    }



   //Ctrl + Shift comment
    @Test
    fun is_theLoadingState_visible(){

        composeTestRule.setContent {
            PostContent(uiState = UiState(isLoading = true))
        }


        composeTestRule
            .onNodeWithText("Loading...")
            .assertIsDisplayed()

    }

    @Test
    fun is_theErrorState_visibl(){

        composeTestRule.setContent {
            PostContent(uiState = UiState(errorMessage = "Test Error"))
        }

        composeTestRule
            .onNodeWithText("Error: Test Error")
            .assertIsDisplayed()
    }

    @Test
    fun loginButton_enabled_whenCredentialsEntered(){

        composeTestRule.setContent {
            LoginScreen(onLoginScreen = {})
        }

        composeTestRule.onNodeWithTag("loginButton")
            .assertIsNotEnabled()

    }

    @Test
    fun heirarchy_test_with_button(){
        composeTestRule.setContent {
            HeaderCard("welcome", onButtonClick = {})
        }


        composeTestRule.onRoot().printToLog("HierarchyTest")

        //1 first verify parent colum exist ok
        val columNode = composeTestRule.onNodeWithTag("headerColumn")
        columNode.assertExists()

        composeTestRule
            .onNode(
                hasTestTag("headerTitle") and
                        hasParent(hasTestTag("headerColumn"))
            )
            .assertTextEquals("welcome")

        composeTestRule
            .onNode(hasTestTag("actionButton") and
                    hasParent(hasTestTag("headerColumn"))
            )
            .assertHasClickAction()
    }


    @Test
    fun fetchPosts_handles_delay()  {
      //  postViewModel.fetchPosts()



    }

}