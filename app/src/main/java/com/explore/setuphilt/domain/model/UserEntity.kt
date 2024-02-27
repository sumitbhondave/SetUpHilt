package com.explore.setuphilt.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.explore.setuphilt.domain.model.User

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey val id: Int,
    val firstName: String,
    val lastName: String,
    val email: String,
    val avatar: String
) {
    fun toUser(): User {
        return User(id, firstName, lastName, email, avatar)
    }
}
