package com.example.restapi

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.restapi.adabter.Adabter
import com.example.restapi.databinding.ActivityMainBinding
import com.example.restapi.utils.Status
import com.example.restapi.utils.TodoViewModels

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var adabter: Adabter
    private lateinit var todoViewModels: TodoViewModels
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        todoViewModels  = ViewModelProvider(this).get(TodoViewModels::class.java)

        adabter = Adabter()
        binding.rv.adapter = Adabter()
        todoViewModels.getAllTodo()
            .observe(this){
                when(it.status){
                    Status.LOADING->{
                        Log.d(TAG , "onCreate:  Loading")
                    }
                    Status.EROR->{
                        Log.d(TAG , "onCreate: EROR${it.massage}")
                    }
                    Status.SUCCESS->{
                        Log.d(TAG , "onCreate:${it.data}")
                        adabter.list = it?.data!!
                        adabter.notifyDataSetChanged()
                    }
                }
            }
    }
}