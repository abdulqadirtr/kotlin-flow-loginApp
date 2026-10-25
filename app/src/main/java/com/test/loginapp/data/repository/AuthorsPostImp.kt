package com.test.loginapp.data.repository

import com.test.loginapp.data.api.PostApi
import com.test.loginapp.data.api.User
import com.test.loginapp.data.model.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class AuthorsPostImp(private val postApi: PostApi) : AuthorsPost {

    override fun getPosts(): Flow<List<Post>> = flow {
        emit(postApi.getPost().posts)
    }.flowOn(Dispatchers.IO)

    override fun getUsers(): Flow<List<User>> = flow {
        emit(postApi.getUsers().users)
    }.flowOn(Dispatchers.IO)
}