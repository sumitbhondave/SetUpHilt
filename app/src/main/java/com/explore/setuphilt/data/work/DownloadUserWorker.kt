package com.explore.setuphilt.data.work

import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.explore.setuphilt.domain.repository.UserRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@HiltWorker
class DownloadUserWorker @AssistedInject constructor(
    @Assisted appContext: Context,
    @Assisted params: WorkerParameters,
    private val userRepository: UserRepository
) : CoroutineWorker(appContext, params) {
    override suspend fun doWork(): Result {
        Log.d("sumit", "doWork: ")
        return withContext(Dispatchers.IO) {
            val result = userRepository.fetchUsers(0)
            if (result) {
                Log.d("sumit", "doWork: success")
                return@withContext Result.success()
            } else {
                Log.d("sumit", "doWork: failure")
                return@withContext Result.failure()
            }
        }
    }
}