package com.insanie.fakeapi.work

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.insanie.fakeapi.database.SampleDatabase
import com.insanie.fakeapi.database.UserRepository
import retrofit2.HttpException

class RefreshDataWorker (appContext : Context,params : WorkerParameters)
    :CoroutineWorker(appContext,params){
    override suspend fun doWork(): Result {
        //any task background
        val userDao = SampleDatabase.getInstanse(applicationContext).userDAO()
        val repository = UserRepository(userDao)

        try {
            repository.refreshUsers()
            return Result.success()
        }catch (e : HttpException){
            return Result.retry()
        }
    }
}