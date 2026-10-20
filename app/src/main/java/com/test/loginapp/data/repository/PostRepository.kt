package com.test.loginapp.data.repository

import com.test.loginapp.data.api.PostResponse
import com.test.loginapp.data.model.Post
import kotlinx.coroutines.flow.Flow

interface PostRepository {
    suspend fun getPosts(): List<Post>

}