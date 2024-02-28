package com.explore.setuphilt.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey val id: Int,
    val firstName: String?,
    val lastName: String?,
    val email: String?,
    val avatar: String?
)