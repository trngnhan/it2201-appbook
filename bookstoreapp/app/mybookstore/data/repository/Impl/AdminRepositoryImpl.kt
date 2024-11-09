package com.haunp.mybookstore.data.repository.Impl

import com.haunp.mybookstore.data.local.dao.UserDao
import com.haunp.mybookstore.data.model.entity.User
import com.haunp.mybookstore.data.repository.AdminRepository

class AdminRepositoryImpl(private val userDao: UserDao) : AdminRepository {
    override suspend fun login(username: String, password: String): User? {
        return userDao.login(username, password)
    }

    override suspend fun insert(user: User) {
        userDao.insertUser(user)
    }

    override suspend fun update(user: User) {
        userDao.updateUser(user)
    }

    override suspend fun delete(user: User) {
        userDao.deleteUser(user)
    }

    override suspend fun getAllUsers(): List<User> {
        return userDao.getAllUsers()
    }

}