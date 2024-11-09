package com.haunp.mybookstore.data.repository

import com.haunp.mybookstore.data.local.dao.UserDao
import com.haunp.mybookstore.data.model.entity.User

interface UserRepository {
    suspend fun login(username: String, password: String): User?
    suspend fun register(user: User)
}