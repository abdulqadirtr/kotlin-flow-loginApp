package com.test.loginapp.data.repository

import com.test.loginapp.data.api.User
import com.test.loginapp.data.api.UsersResponse
import kotlinx.coroutines.flow.Flow

interface UsersRepository {

   suspend fun getUsers() : List<User>

}