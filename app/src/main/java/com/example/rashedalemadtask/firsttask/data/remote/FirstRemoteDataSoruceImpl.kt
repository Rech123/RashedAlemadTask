package com.example.rashedalemadtask.firsttask.data.remote

import android.util.Log
import com.example.rashedalemadtask.core.api.NetworkResult
import com.example.rashedalemadtask.core.api.RestWebService
import com.example.rashedalemadtask.core.api.models.BreedsResponse
import com.example.rashedalemadtask.core.base.BaseApiResponse
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import javax.inject.Inject
import javax.xml.parsers.DocumentBuilderFactory

class FirstRemoteDataSoruceImpl @Inject constructor(val restWebService: RestWebService) :
    FirstRemoteDataSource, BaseApiResponse() {
    private val dispatcher = newFixedThreadPoolContext(3, "IO")
    private val coroutineScope = CoroutineScope(Dispatchers.IO )


    suspend fun getAllBreedsNew(){
        withContext(Dispatchers.IO) {
            safeApiCall { restWebService.getAllBreeds() }
        }
    }
    override fun getAllBreeds(): Flow<NetworkResult<BreedsResponse>> {
       // getAllBreedsInBackground()

       return flow<NetworkResult<BreedsResponse>> {
           delay(3000)

           emit( safeApiCall { restWebService.getAllBreeds() })

       }.flowOn(dispatcher)
    }

    override suspend fun getAllBreedsOneShot(): NetworkResult<BreedsResponse> {
        return safeApiCall { restWebService.getAllBreeds() }
    }

    fun getAllBreedsInBackground(){

       Log.d("viewmodel", "getAllBreedsInBackground: started ")

       flow<NetworkResult<BreedsResponse>> {
           Log.d("viewmodel", "getAllBreeds: remote before ${Thread.currentThread().name}")

           delay(3000)

           emit(safeApiCall { restWebService.getAllBreeds() })
           Log.d("viewmodel", "getAllBreeds: remote after ${Thread.currentThread().name}")

       }.flowOn(dispatcher)

coroutineScope.launch (dispatcher){
    delay(3000)
    safeApiCall { restWebService.getAllBreeds() }
}.invokeOnCompletion {
    Log.d("viewmodel", "getAllBreedsInBackground: comleted ")
}
   }
}