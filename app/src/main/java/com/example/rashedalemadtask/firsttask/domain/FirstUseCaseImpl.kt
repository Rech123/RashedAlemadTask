package com.example.rashedalemadtask.firsttask.domain

import android.util.Log
import com.example.rashedalemadtask.core.api.NetworkResult
import com.example.rashedalemadtask.core.api.models.BreedsResponse
import com.example.rashedalemadtask.firsttask.data.repository.FirstRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FirstUseCaseImpl @Inject constructor (private val firstRepository: FirstRepository) :FirstUseCase {

    override fun getAllBreeds(): Flow<NetworkResult<BreedsResponse>> {
        Log.d("viewmodel", "onButtonclick:use case ")

        return firstRepository.getAllBreeds()
    }

    override suspend fun getAllBreedsOneShot(): NetworkResult<BreedsResponse> {
        return firstRepository.getAllBreedsOneShot()
    }
}