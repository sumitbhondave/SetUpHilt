package com.explore.setuphilt.data.work

import android.content.Context
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import java.util.concurrent.TimeUnit

object DownloadUser {

    fun initialize(context: Context) {
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        val userFetchRequest = PeriodicWorkRequestBuilder<DownloadUserWorker>(
            repeatInterval = 10, // repeat every 10 seconds
            repeatIntervalTimeUnit = TimeUnit.SECONDS
        ).setConstraints(constraints).addTag("user_unique_work").build()

        WorkManager.getInstance(context).apply {
            enqueue(userFetchRequest)
        }
    }
}