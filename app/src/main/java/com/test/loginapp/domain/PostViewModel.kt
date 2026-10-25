package com.test.loginapp.domain

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.loginapp.data.model.Post
import com.test.loginapp.data.model.UiState
import com.test.loginapp.data.repository.GetPostsWithAuthorsUseCase
import com.test.loginapp.data.repository.PostNetworkServiceLoader
import com.test.loginapp.data.repository.PostRepository
import com.test.loginapp.data.repository.UsersRepository
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class PostViewModel(private val getPostsWithAuthorsUseCase: GetPostsWithAuthorsUseCase = PostNetworkServiceLoader.provideGetPostsUseCase())  : ViewModel() {


    //var posts by mutableStateOf<List<Post>>(emptyList())
      //  private set
private val _eventChannel = Channel<String>()
    val uiEvent = _eventChannel.receiveAsFlow()
    // Single source of state truth
    var uiState by mutableStateOf(UiState())
        private set


    init {
        triggerAction()
    }

    fun triggerAction() {
        // 2. Send a one-time message into the channel
        _eventChannel.trySend("Navigate to Details Screen")
    }


    fun fetchPosts() {
        viewModelScope.launch {
            uiState = uiState.copy(isLoading = true, errorMessage = null)

            getPostsWithAuthorsUseCase()
                .catch { e ->
                    uiState = uiState.copy(
                        errorMessage = e.message ?: "An unexpected error occurred",
                        isLoading = false
                    )
                }
                .collect { combinedList ->
                    uiState = uiState.copy(
                        posts = combinedList,
                        isLoading = false
                    )
                }
        }
    }

}