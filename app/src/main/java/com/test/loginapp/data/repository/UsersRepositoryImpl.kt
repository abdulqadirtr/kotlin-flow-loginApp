package com.test.loginapp.data.repository

import com.test.loginapp.data.api.PostApi
import com.test.loginapp.data.api.User
import com.test.loginapp.data.api.UsersResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class UsersRepositoryImpl (
    private val postApi: PostApi
) : UsersRepository
{
    override suspend fun getUsers(): List<User> {
        return postApi.getUsers().users
    }


}