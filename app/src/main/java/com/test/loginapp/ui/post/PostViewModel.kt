package com.test.loginapp.ui.post

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.loginapp.data.model.UiState
import com.test.loginapp.data.repository.PostNetworkServiceLoader
import com.test.loginapp.data.repository.PostRepository
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class PostViewModel(private val repository: PostRepository = PostNetworkServiceLoader.postRepository)  : ViewModel() {


    //var posts by mutableStateOf<List<Post>>(emptyList())
      //  private set

    // Single source of state truth
    var uiState by mutableStateOf(UiState())
        private set

    // One-time side effects channel (for navigation/snackbars)
    private val _sideEffect = Channel<PostSideEffect>()
    val sideEffect = _sideEffect.receiveAsFlow()


    // Single entry point for all UI intents
     fun onIntent(intent: PostIntent) {
         viewModelScope.launch {
             when (intent) {
                 is PostIntent.LoadPosts,
                 is PostIntent.RefreshPosts -> fetchPosts()

                 is PostIntent.PostClicked -> {

                         _sideEffect.send(PostSideEffect.NavigateToDetail(intent.postId))
                 }
             }
         }
    }

    suspend fun fetchPosts() {

        viewModelScope.launch {
            uiState = uiState.copy(isLoading = true, errorMessage = null)
            try {
                val posts = repository.getPosts()
                uiState = uiState.copy(posts = posts, isLoading = false)
            } catch (e: Exception) {
                uiState = uiState.copy(
                    errorMessage = e.message ?: "An unexpected error occurred",
                    isLoading = false
                )
                _sideEffect.send(PostSideEffect.ShowSnackbar("Failed to load posts"))
            }
        }
    }
}