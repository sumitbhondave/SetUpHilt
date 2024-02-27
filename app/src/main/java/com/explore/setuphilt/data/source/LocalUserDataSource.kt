package com.explore.setuphilt.data.source

import com.explore.setuphilt.data.database.UserDao
import com.explore.setuphilt.domain.model.User

class LocalUserDataSource(private val userDao: UserDao) {
    suspend fun getUsers(): List<User> {
        return userDao.getUsers()
    }

    suspend fun saveUsers(users: List<User>) {
        userDao.insertUsers(users)
    }
}