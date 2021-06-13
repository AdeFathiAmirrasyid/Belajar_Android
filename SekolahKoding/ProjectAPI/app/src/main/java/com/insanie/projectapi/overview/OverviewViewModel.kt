package com.insanie.projectapi.overview



import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.insanie.projectapi.network.GithubApi
import com.insanie.projectapi.network.GithubData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch



class OverviewViewModel : ViewModel(){

    private val _items = MutableLiveData<List<GithubData>>()
    val items : LiveData<List<GithubData>>
        get() = _items


    private val _response = MutableLiveData<String>()
    val response : LiveData<String>
        get() = _response

    private var vmJob = Job()
    private var crScope = CoroutineScope(vmJob + Dispatchers.Main)
    init {
        iniData()
    }

    private fun iniData(){

        _response.value = "Loading...."
        crScope.launch {
            try {
                val result = GithubApi.retrofitService.showList()

                if (result.size > 0){
                    _items.value = result
                    _response.value = "OK"
                }
            } catch (t: Throwable) {

                _response.value = "FAILED,Internet OFF"
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        vmJob.cancel()
    }
}