package com.explore.setuphilt.data.repository

import androidx.lifecycle.LiveData
import com.explore.setuphilt.data.source.LocalUserDataSource
import com.explore.setuphilt.data.source.RemoteUserDataSource
import com.explore.setuphilt.domain.model.User
import com.explore.setuphilt.domain.model.UserEntity
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
            localUserDataSource.saveUsers(response.map {
                UserEntity(it.id, it.first_name, it.last_name, it.email, it.avatar)
            })
            return localUserDataSource.getUsers()
                .map { User(it.id, it.firstName, it.lastName, it.email, it.avatar) }
        } else {
            throw IOException("Error fetching users: $response")
        }
    }

    override suspend fun fetchUsers(page: Int): Boolean {
        val response = remoteUserDataSource.getUsers(page)
        return response.isNotEmpty()
    }

    override fun getItems(): LiveData<List<UserEntity>> {
        return localUserDataSource.getLiveUsers()
    }
}
