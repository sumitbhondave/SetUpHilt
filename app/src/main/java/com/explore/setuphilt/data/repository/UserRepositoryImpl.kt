package com.explore.setuphilt.data.repository

import com.explore.setuphilt.data.source.LocalUserDataSource
import com.explore.setuphilt.data.source.RemoteUserDataSource
import com.explore.setuphilt.domain.model.User
import com.explore.setuphilt.domain.repository.UserRepository
import java.io.IOException

class UserRepositoryImpl(
    private val remoteUserDataSource: RemoteUserDataSource,
    private val localUserDataSource: LocalUserDataSource
) :
    UserRepository {
    override suspend fun getUsers(page: Int): List<User> {
        val response = remoteUserDataSource.getUsers(page)
        if (response.isNotEmpty()) {
            localUserDataSource.saveUsers(response)
            return localUserDataSource.getUsers()
        } else {
            throw IOException("Error fetching users: $response")
        }
    }
}
