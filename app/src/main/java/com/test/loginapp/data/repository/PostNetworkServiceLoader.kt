package com.test.loginapp.data.repository

import com.test.loginapp.data.api.ApiService

object PostNetworkServiceLoader {

    val postRepository : PostRepository by lazy {

        PostRepositoryImpl(ApiService.postApi)
    }
}