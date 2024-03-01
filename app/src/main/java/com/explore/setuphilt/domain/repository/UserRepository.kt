package com.explore.setuphilt.domain.repository

import androidx.lifecycle.LiveData
import com.explore.setuphilt.domain.model.UserEntity

interface UserRepository {
    suspend fun fetchUsers(page: Int): Boolean

    fun getLiveUsers(): LiveData<List<UserEntity>>
}