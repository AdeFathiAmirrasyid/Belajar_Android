package com.insanie.fakeapi.overview

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.insanie.fakeapi.database.SampleDatabase
import com.insanie.fakeapi.database.User
import com.insanie.fakeapi.database.UserDAO
import com.insanie.fakeapi.database.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class  OverviewViewModel (application : Application) : AndroidViewModel(application) {

    //add repository

    private val repository : UserRepository
    private val userDAO : UserDAO

    private val _items : LiveData<List<User>>
    val items : LiveData<List<User>>
        get() = _items

    private val _response = MutableLiveData<String>()
    val response : LiveData<String>
        get() = _response




    private var vmJob = Job()
    private val crScope = CoroutineScope(vmJob + Dispatchers.Main)

    init {

        userDAO  = SampleDatabase.getInstanse(application).userDAO()
        repository = UserRepository(userDAO)
        _response.value = "Loading ....."

        crScope.launch{
            try{
                 repository.refreshUsers()
            }catch (t: Throwable){
                _response.value = "Failed, Internet OFF"
            }
        }

        _items = repository.users
        _response.value = "OK"

    }

    override fun onCleared() {
        super.onCleared()
        vmJob.cancel()
    }

}


