package com.explore.setuphilt.data.repository

import androidx.lifecycle.LiveData
import com.explore.setuphilt.data.source.LocalUserDataSource
import com.explore.setuphilt.data.source.RemoteUserDataSource
import com.explore.setuphilt.domain.model.UserEntity
import com.explore.setuphilt.domain.repository.UserRepository

class UserRepositoryImpl(
    private val remoteUserDataSource: RemoteUserDataSource,
    private val localUserDataSource: LocalUserDataSource
) : UserRepository {

    override suspend fun fetchUsers(page: Int): Boolean {
        val response = remoteUserDataSource.getUsers(page)
        if (response.isNotEmpty()) {
            localUserDataSource.saveUsers(response)
        }
        return response.isNotEmpty()
    }

    override fun getLiveUsers(): LiveData<List<UserEntity>> {
        return localUserDataSource.getLiveUsers()
    }
}
