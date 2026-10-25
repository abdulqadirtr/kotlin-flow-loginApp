package com.test.loginapp.data.api

import com.test.loginapp.data.model.Post
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface PostApi {

    @GET("posts")
    suspend fun getPost(): PostResponse

    @GET("users")
    suspend fun getUsers(): UsersResponse
}