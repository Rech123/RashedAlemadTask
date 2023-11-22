package com.example.rashedalemadtask.firsttask.presentation.ui.acitivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.rashedalemadtask.MainActivity
import com.example.rashedalemadtask.R
import com.example.rashedalemadtask.core.api.NetworkResult
import com.example.rashedalemadtask.core.api.models.BreedsResponse
import com.example.rashedalemadtask.firsttask.presentation.viewmodels.FirstViewModel
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_first.*

@AndroidEntryPoint
class FirstActivity : AppCompatActivity() {

    lateinit var firstViewModel: FirstViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        firstViewModel = ViewModelProvider(this)[FirstViewModel::class.java]

        firstButton.setOnClickListener {
            firstViewModel.onButtonclick()
        }
        button2.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
        firstViewModel.breedsRespnseLiveData.observe(this, Observer {
            Log.d("viewmodel", "onCreate: recived ${it.data?.message?.size}")
        })

        firstViewModel.networkResultBreedResponse.observe(this, Observer {
            when (it){
                is NetworkResult.Success->
                    Log.d("viewmodel", "onCreate: sccess ${it.data}")
                is NetworkResult.Loading->
                    Log.d("viewmodel", "onCreate: loading ")
                is NetworkResult.Error->
                    Log.d("viewmodel", "onCreate: error ")




            }
        })


    }


}