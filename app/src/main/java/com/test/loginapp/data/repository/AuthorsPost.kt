package com.test.loginapp.data.repository

import com.test.loginapp.data.api.User
import com.test.loginapp.data.model.Post
import kotlinx.coroutines.flow.Flow

interface AuthorsPost {

    fun getPosts(): Flow<List<Post>>
    fun getUsers(): Flow<List<User>>
}