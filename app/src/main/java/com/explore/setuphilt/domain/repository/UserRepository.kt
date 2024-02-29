package com.explore.setuphilt.domain.repository

import androidx.lifecycle.LiveData
import com.explore.setuphilt.domain.model.User
import com.explore.setuphilt.domain.model.UserEntity

interface UserRepository {
    suspend fun getUsers(page: Int): List<User>

    suspend fun fetchUsers(page: Int): Boolean

    fun getItems(): LiveData<List<UserEntity>>
}