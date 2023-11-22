package com.example.rashedalemadtask.firsttask.data.repository

import com.example.rashedalemadtask.core.api.NetworkResult
import com.example.rashedalemadtask.core.api.models.BreedsResponse
import kotlinx.coroutines.flow.Flow

interface FirstRepository {

   fun  getAllBreeds() :Flow<NetworkResult<BreedsResponse>>
   suspend fun getAllBreedsOneShot():NetworkResult<BreedsResponse>
}