package com.test.loginapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.test.loginapp.data.model.PostsUiState
import com.test.loginapp.data.model.UiState
import com.test.loginapp.domain.PostViewModel
import kotlinx.coroutines.flow.StateFlow

@Composable
fun PostScreen(viewModel: PostViewModel = viewModel()) {
    LaunchedEffect(Unit) {
        viewModel.fetchPosts() // trigger fetch once when screen appears
    }
    PostContent(viewModel.uiState)
}
@Composable
fun PostContent(uiState : UiState) {

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Text("Post Screen",  modifier = Modifier
            .padding(bottom = 8.dp)
            .testTag("postScreen"))

        when {
           uiState.isLoading -> Text("Loading...")
           uiState.errorMessage != null -> Text("Error: ${uiState.errorMessage}")
            else -> {
                LazyColumn (modifier = Modifier.testTag("post_list")) {
                    items(uiState.posts) { post ->
                        val safeTitle = post.title ?: "Untitled"
                        val safeId = post.id ?: 0
                        Text(
                            safeTitle + safeId,
                            modifier = Modifier
                                .padding(vertical = 8.dp)
                                .testTag("post_${safeId}")
                        )
                    }
                }
            }
        }
    }

}

