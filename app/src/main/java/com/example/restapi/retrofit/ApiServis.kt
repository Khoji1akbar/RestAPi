package com.example.restapi.retrofit

import com.example.restapi.models.MyTodo
import retrofit2.http.GET

interface ApiServis {

    @GET("plan/")
     suspend fun getApiServis():List<MyTodo>
}