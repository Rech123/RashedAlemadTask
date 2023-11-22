package com.example.rashedalemadtask.firsttask.data.local

import com.example.rashedalemadtask.core.api.NetworkResult
import com.example.rashedalemadtask.core.api.models.BreedsResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FirstLocalDataSoruceImpl @Inject constructor() :FirstLocalDataSource {
    override fun getAllBreeds(): Flow<NetworkResult<BreedsResponse>> {
        TODO("Not yet implemented")
    }


}