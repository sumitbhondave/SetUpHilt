package com.explore.setuphilt.data.source

import com.explore.setuphilt.data.api.UserApiService
import com.explore.setuphilt.domain.model.UserEntity

class RemoteUserDataSource(private val userApiService: UserApiService) {
    suspend fun getUsers(page: Int): List<UserEntity> {
        val response = userApiService.getUsers(page)
        if (response.isSuccessful) {
            return response.body()?.data ?: emptyList()
        }
        return emptyList()
    }
}