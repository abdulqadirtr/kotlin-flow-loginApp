package com.test.loginapp.data.repository

import com.test.loginapp.data.api.ApiService

object PostNetworkServiceLoader {

    val postRepository : PostRepository by lazy {

        PostRepositoryImpl(ApiService.postApi)
    }

    val usersRepository : UsersRepository by lazy {
        UsersRepositoryImpl(ApiService.postApi)
    }

    val authorRepository : AuthorsPost by lazy {
        AuthorsPostImp(ApiService.postApi)
    }

    // ⭐ Added Use Case provider to wire everything together cleanly
    fun provideGetPostsUseCase(): GetPostsWithAuthorsUseCase {
        return GetPostsWithAuthorsUseCase(authorRepository)
    }
}