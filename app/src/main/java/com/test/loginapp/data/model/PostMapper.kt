package com.test.loginapp.data.model

import com.test.loginapp.data.api.User
import com.test.loginapp.data.repository.PostWithAuthor

fun List<Post>.toPostsWithAuthors(users: List<User>): List<PostWithAuthor> {
    return this.mapNotNull { post ->
        val author = users.find { user ->
            user.id.toString() == post.userId?.toString()
        }

        // Skip posts that don't have a matching author
        if (author == null) return@mapNotNull null

        PostWithAuthor(
            postId = post.id ?: 0,
            title = post.title ?: "Untitled",
            authorName = author.username ?: author.username ?: "Unknown Author"
        )
    }
}