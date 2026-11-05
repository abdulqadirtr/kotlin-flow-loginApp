package com.test.loginapp.ui.post

import com.test.loginapp.data.model.Post

data class PostUiState(
    val post : List<Post> = emptyList(),
    val loading : Boolean = false,
    val error : String? = null
)

// 2. INTENT: Actions the user can trigger from the UI
sealed interface PostIntent {
    object LoadPosts : PostIntent
    object RefreshPosts : PostIntent
    data class PostClicked(val postId: Int) : PostIntent
}

// 3. SIDE EFFECTS: One-time events (Navigation, Snackbars)
sealed interface PostSideEffect {
    data class NavigateToDetail(val postId: Int) : PostSideEffect
    data class ShowSnackbar(val message: String) : PostSideEffect
}