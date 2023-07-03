package com.example.restapi.models

import com.example.restapi.retrofit.ApiServis

class TodoRepozitory(val apiservis:ApiServis) {
    suspend fun getAllTodo()= apiservis.getApiServis()
}