package com.example.restapi.utils

data class Recourse<out T>(val status: Status, val data :T?, val massage:String){
    companion object {
        fun <T> success(data: T): Recourse<T> {
            return Recourse(Status.SUCCESS, data, null.toString())
        }

        fun <T> eror(massage: String?): Recourse<T> {
            return Recourse(Status.EROR, null, massage!!)
        }

        fun <T> loading(massage: String?): Recourse<T> {
            return Recourse(Status.LOADING, null, massage!!)
        }
    }
}
