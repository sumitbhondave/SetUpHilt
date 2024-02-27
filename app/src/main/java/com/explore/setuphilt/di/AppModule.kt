package com.explore.setuphilt.di

import android.app.Application
import android.content.Context
import com.explore.setuphilt.data.api.UserApiService
import com.explore.setuphilt.data.database.UserDao
import com.explore.setuphilt.data.database.UserDatabase
import com.explore.setuphilt.data.repository.UserRepositoryImpl
import com.explore.setuphilt.data.source.LocalUserDataSource
import com.explore.setuphilt.data.source.RemoteUserDataSource
import com.explore.setuphilt.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }

    @Provides
    fun provideUserRepository(
        remoteUserDataSource: RemoteUserDataSource,
        localUserDataSource: LocalUserDataSource
    ): UserRepository {
        return UserRepositoryImpl(remoteUserDataSource, localUserDataSource)
    }

    @Provides
    fun provideUserApiService(): UserApiService {
        return Retrofit.Builder()
            .baseUrl("https://reqres.in")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserApiService::class.java)
    }

    @Provides
    fun provideDatabase(context: Context): UserDatabase {
        return UserDatabase.getInstance(context)
    }

    @Provides
    fun provideUserDao(database: UserDatabase): UserDao {
        return database.userDao()
    }

    @Provides
    fun provideRemoteUserDataSource(
        userApiService: UserApiService
    ): RemoteUserDataSource {
        return RemoteUserDataSource(userApiService)
    }

    @Provides
    fun provideLocalUserDataSource(
        userDao: UserDao
    ): LocalUserDataSource {
        return LocalUserDataSource(userDao)
    }
}
