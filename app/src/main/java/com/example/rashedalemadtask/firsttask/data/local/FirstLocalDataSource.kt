package com.example.rashedalemadtask.firsttask.data.local

import com.example.rashedalemadtask.core.api.NetworkResult
import com.example.rashedalemadtask.core.api.models.BreedsResponse
import kotlinx.coroutines.flow.Flow

interface FirstLocalDataSource {

    fun getAllBreeds(): Flow<NetworkResult<BreedsResponse>>
}