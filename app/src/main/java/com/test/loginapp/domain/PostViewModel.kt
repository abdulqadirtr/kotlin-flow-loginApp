package com.test.loginapp.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.loginapp.data.api.PostResponse
import com.test.loginapp.data.model.PostsUiState
import com.test.loginapp.data.repository.PostNetworkServiceLoader
import com.test.loginapp.data.repository.PostRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class PostViewModel(private val repository: PostRepository = PostNetworkServiceLoader.postRepository) :
    ViewModel() {


    private val _uiPostState = MutableStateFlow<PostsUiState>(PostsUiState.Loading)
    val uiPostState = _uiPostState.asStateFlow()

    /*  In your ViewModel snippet, using Compose's mutableStateOf inside the ViewModel tightly
      couples your ViewModel to the Compose UI framework.

      var uiState by mutableStateOf(UiState())
          private set

     */

    fun fetchPosts() {
        viewModelScope.launch {

            val posts = repository.getPosts()

            // Optional: Set loading state if refreshing
            _uiPostState.value = PostsUiState.Loading

            posts.catch { exception ->
                _uiPostState.value = PostsUiState.Error(exception.localizedMessage ?: "Unknow Error")
            }.collect { postResponses ->
                _uiPostState.value = PostsUiState.Success(postResponses)
            }

        }
    }



}