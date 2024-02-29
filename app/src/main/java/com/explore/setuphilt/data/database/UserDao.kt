package com.explore.setuphilt.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.explore.setuphilt.domain.model.UserEntity

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    suspend fun getUsers(): List<UserEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUsers(users: List<UserEntity>)

    @Query("SELECT * FROM user")
    fun getLiveUsers(): LiveData<List<UserEntity>>
}