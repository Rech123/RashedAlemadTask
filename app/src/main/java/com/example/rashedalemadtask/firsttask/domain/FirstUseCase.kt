package com.example.rashedalemadtask.firsttask.domain

import com.example.rashedalemadtask.core.api.NetworkResult
import com.example.rashedalemadtask.core.api.models.BreedsResponse
import kotlinx.coroutines.flow.Flow

interface FirstUseCase {
    fun getAllBreeds(): Flow<NetworkResult<BreedsResponse>>
   suspend fun getAllBreedsOneShot(): NetworkResult<BreedsResponse>
}