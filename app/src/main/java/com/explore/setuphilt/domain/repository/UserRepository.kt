package com.explore.setuphilt.domain.repository

import com.explore.setuphilt.domain.model.User

interface UserRepository {
    suspend fun getUsers(page: Int): List<User>
}
