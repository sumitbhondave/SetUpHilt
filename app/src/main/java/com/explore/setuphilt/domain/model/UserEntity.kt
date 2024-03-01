package com.explore.setuphilt.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey val id: Int,
    val first_name: String?,
    val last_name: String?,
    val email: String?,
    val avatar: String?
)