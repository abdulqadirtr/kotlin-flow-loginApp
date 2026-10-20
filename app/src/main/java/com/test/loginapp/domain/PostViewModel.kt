package com.test.loginapp.domain

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.loginapp.data.model.Post
import com.test.loginapp.data.model.UiState
import com.test.loginapp.data.repository.PostNetworkServiceLoader
import com.test.loginapp.data.repository.PostRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class PostViewModel(private val repository: PostRepository = PostNetworkServiceLoader.postRepository)  : ViewModel() {


    //var posts by mutableStateOf<List<Post>>(emptyList())
      //  private set

    // Single source of state truth
    var uiState by mutableStateOf(UiState())
        private set

    fun fetchPosts() {
        viewModelScope.launch {
            //isLoading = true
            // We use .copy() because your UiState is a data class, and .copy() lets you update specific properties while keeping the others unchanged.
            uiState = uiState.copy(isLoading = true, errorMessage = null)
            try {
                val posts = repository.getPosts()
               // uiState = UiState(posts = posts)   // ⭐ calls Repository, not ApiService
                uiState = uiState.copy(posts = posts, isLoading = false)
            } catch (e: Exception) {
                uiState = uiState.copy(
                    errorMessage = e.message ?: "An unexpected error occurred",
                    isLoading = false
                )
            }
        }
    }
}