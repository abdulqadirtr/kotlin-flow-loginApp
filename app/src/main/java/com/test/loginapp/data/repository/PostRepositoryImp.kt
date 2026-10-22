package com.test.loginapp.data.repository

import com.test.loginapp.data.api.PostApi
import com.test.loginapp.data.api.PostResponse
import com.test.loginapp.data.model.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

class PostRepositoryImpl(
    private val postApi: PostApi
) : PostRepository {
    override fun getPosts(): Flow<List<Post>> = flow {
        val response = postApi.getPostWithFlow().posts
        delay(15_000)
        emit(response)


    }.flowOn(Dispatchers.IO)

}