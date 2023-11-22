package com.example.rashedalemadtask.firsttask.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rashedalemadtask.core.api.NetworkResult
import com.example.rashedalemadtask.core.api.models.BreedsResponse
import com.example.rashedalemadtask.firsttask.domain.FirstUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class FirstViewModel @Inject constructor(private val firstUseCase: FirstUseCase) : ViewModel() {


    private var _breedsResponse: MutableLiveData<NetworkResult<BreedsResponse>> = MutableLiveData()
    var breedsRespnseLiveData: LiveData<NetworkResult<BreedsResponse>> = _breedsResponse

    private var _NetworkResultBreedResponse: MutableLiveData<NetworkResult<BreedsResponse>> =
        MutableLiveData()
    var networkResultBreedResponse: LiveData<NetworkResult<BreedsResponse>> =
        _NetworkResultBreedResponse


    fun onButtonclick() {

        Log.d("viewmodel", "onButtonclick: ")
        /* viewModelScope.launch(Dispatchers.IO) {
             firstUseCase.getAllBreeds().collect{
                 Log.d("viewmodel", "onButtonclick: ${it.data?.message?.size}")
                 _breedsResponse.postValue( it)
             }


         }

         */
        getAllBreedsOneShot()
    }

    fun getAllBreedsOneShot() {
        _NetworkResultBreedResponse.value = (NetworkResult.Loading())

        viewModelScope.launch {
            try {
                _NetworkResultBreedResponse.postValue(firstUseCase.getAllBreedsOneShot())

            } catch (e: Exception) {
                _NetworkResultBreedResponse.postValue(
                    NetworkResult.Error(
                        firstUseCase.getAllBreedsOneShot().message ?: "Something went wrong"
                    )
                )

            }
        }
    }



    override fun onCleared() {
        super.onCleared()
        Log.d("viewmodel", "onCleared: ")
    }
}
