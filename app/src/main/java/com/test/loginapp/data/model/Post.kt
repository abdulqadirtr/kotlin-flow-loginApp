package com.test.loginapp.data.model

import com.test.loginapp.data.api.PostResponse
import kotlinx.serialization.Serializable
@Serializable
data class Post(
    val id: Int? = null,
    val title: String? = null,
    val body: String? = null,
    val tags: List<String>? = null,
    val reactions: Reactions? = null,
    val views: Int? = null,
    val userId: Int? = null,
)

@Serializable
data class Reactions(
    val likes: Int? = null,
    val dislikes: Int? = null,
)

data class UiState(
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val posts: List<Post> = emptyList()
)

sealed class PostsUiState{
    data object Loading : PostsUiState()
    data class Success(val posts : List<Post>) : PostsUiState()
    data class Error(val exception: String) : PostsUiState()
}
