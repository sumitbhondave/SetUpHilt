package com.explore.setuphilt.domain.model

data class User(
    val id: Int,
    val first_name: String?,
    val last_name: String?,
    val email: String?,
    val avatar: String?
)