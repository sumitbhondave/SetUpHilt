package com.explore.setuphilt.data.api

import com.explore.setuphilt.data.model.UserListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface UserApiService {
    @GET("/api/users")
    suspend fun getUsers(@Query("page") page: Int): Response<UserListResponse>
}