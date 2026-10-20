package com.test.loginapp

import com.test.loginapp.data.model.Post
import com.test.loginapp.data.repository.PostRepository

class FakeRepository : PostRepository{
    override suspend fun getPosts(): List<Post> {
        return listOf(
            Post(1, "First post"),
            Post(2, title= "Second post")
        )
    }
}