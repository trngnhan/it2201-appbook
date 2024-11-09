package com.haunp.mybookstore.data.repository

import com.haunp.mybookstore.data.model.entity.User

interface AdminRepository {
    suspend fun login(username: String, password: String): User?
    suspend fun insert(user: User)
    suspend fun update(user: User)
    suspend fun delete(user: User)
    suspend fun getAllUsers(): List<User>
}