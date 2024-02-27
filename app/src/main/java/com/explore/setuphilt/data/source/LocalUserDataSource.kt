package com.explore.setuphilt.data.source

import com.explore.setuphilt.data.database.UserDao
import com.explore.setuphilt.domain.model.UserEntity

class LocalUserDataSource(private val userDao: UserDao) {
    suspend fun getUsers(): List<UserEntity> {
        return userDao.getUsers()
    }

    suspend fun saveUsers(users: List<UserEntity>) {
        userDao.insertUsers(users)
    }
}