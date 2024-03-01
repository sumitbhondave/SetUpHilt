package com.explore.setuphilt.data.model

import com.explore.setuphilt.domain.model.UserEntity

data class UserListResponse(
    val data: List<UserEntity>
)