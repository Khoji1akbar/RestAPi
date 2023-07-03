package com.example.restapi.utils

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.restapi.models.MyTodo
import com.example.restapi.retrofit.ApiClient
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import java.lang.Exception

class TodoViewModels : ViewModel() {
    private val liveDate = MutableLiveData<Recourse<List<MyTodo>>>()


    fun getAllTodo(): MutableLiveData<Recourse<List<MyTodo>>> {
        val apiServis = ApiClient.apiServis()
        viewModelScope.launch {
            liveDate.postValue(Recourse.loading("loading"))
            try {

                coroutineScope {
                    val list = async {
                        apiServis.getApiServis()
                    }.await()

                    liveDate.postValue(Recourse.success(list))
                }

            } catch (e: Exception) {
                liveDate.postValue(Recourse.eror(e.message))
            }
        }
        return liveDate
    }
}