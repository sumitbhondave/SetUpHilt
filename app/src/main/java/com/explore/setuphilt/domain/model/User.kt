package com.explore.setuphilt.domain.model

data class User(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val email: String,
    val avatar: String
) {
    fun toUserEntity(): UserEntity {
        return UserEntity(id, firstName, lastName, email, avatar)
    }
}