package com.test.loginapp.data.api

import com.test.loginapp.data.model.Post
import kotlinx.serialization.Serializable

@Serializable
data class PostResponse(
    val posts: List<Post>,
    val total: Int,
    val skip: Int,
    val limit: Int
)
