package com.haunp.mybookstore.data.repository.Impl

import com.haunp.mybookstore.data.local.dao.UserDao
import com.haunp.mybookstore.data.local.db.BookDatabase
import com.haunp.mybookstore.data.model.entity.User
import com.haunp.mybookstore.data.repository.UserRepository

class UserRepositoryImpl(private val userDao: UserDao) : UserRepository{
    override suspend fun login(username: String, password: String): User? {
        return userDao.login(username, password)
    }

    override suspend fun register(user: User) {
        userDao.insertUser(user)
    }

}