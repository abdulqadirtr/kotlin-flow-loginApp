package com.test.loginapp.data.repository

import com.test.loginapp.data.api.PostApi
import com.test.loginapp.data.model.Post
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PostRepositoryImpl(
    private val postApi: PostApi
) : PostRepository {

    override suspend fun getPosts(): List<Post> {
        return postApi.getPost().posts
    }

}