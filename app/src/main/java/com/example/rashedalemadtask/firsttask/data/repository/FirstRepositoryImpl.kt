package com.example.rashedalemadtask.firsttask.data.repository

import android.util.Log
import com.example.rashedalemadtask.core.api.NetworkResult
import com.example.rashedalemadtask.core.api.models.BreedsResponse
import com.example.rashedalemadtask.firsttask.data.local.FirstLocalDataSource
import com.example.rashedalemadtask.firsttask.data.remote.FirstRemoteDataSource
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject
import kotlin.math.log

class FirstRepositoryImpl @Inject constructor(
    val firstRemoteDataSource: FirstRemoteDataSource,
    val firstLocalDataSource: FirstLocalDataSource
) : FirstRepository {
    private val coroutineScope = CoroutineScope(Dispatchers.IO)
    override fun getAllBreeds(): Flow<NetworkResult<BreedsResponse>> {

        return firstRemoteDataSource.getAllBreeds()
    }

    override suspend fun getAllBreedsOneShot(): NetworkResult<BreedsResponse> =
        withContext(Dispatchers.IO) {
            try {
                val data = firstRemoteDataSource.getAllBreedsOneShot()
                data.data?.let { NetworkResult.Success(it) }

            } catch (e: Exception) {
                NetworkResult.Error(e.message.toString())

            }

        }!!

    suspend fun longRunningOperation(): MutableStateFlow<NetworkResult<BreedsResponse>> {
        val flow = MutableStateFlow<NetworkResult<BreedsResponse>>(NetworkResult.Loading())
        coroutineScope.async(Dispatchers.Default) {
            try {
                delay(3000)
                Log.d("viewmodel", "longRunningOperation: ")
                val data = firstRemoteDataSource.getAllBreedsOneShot()
                data.data?.let { NetworkResult.Success(it) }
                flow.emit(data)
            } catch (e: java.lang.Exception) {
                flow.emit(NetworkResult.Error(e.message ?: "Something Went Wrong"))
            }
            finally {
                coroutineScope.cancel()
                Log.d("viewmodel", "longRunningOperation: finally block  ${coroutineScope.isActive}")
            }

        }.await()

        return flow
    }


    suspend fun addBreed() {
        withContext(Dispatchers.IO) {
            // will make one shot operation , if we know the the data will be in a single , however to the db
            // then will make it here simple and effeinet
            // flow of data , means the operation which done from otherside need to be updated on ther side automatically
            // local database
        }
    }


}