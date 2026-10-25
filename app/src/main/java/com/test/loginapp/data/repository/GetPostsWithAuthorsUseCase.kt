package com.test.loginapp.data.repository

import com.test.loginapp.data.model.toPostsWithAuthors
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine

class GetPostsWithAuthorsUseCase(
    private val repository: AuthorsPost
) {
    // Using the 'invoke' operator lets you call this class like a function
    operator fun invoke(): Flow<List<PostWithAuthor>> {
        return repository.getPosts()
            .combine(repository.getUsers()) { posts, users ->
                posts.toPostsWithAuthors(users) // Your mapper extension function
            }
    }
}