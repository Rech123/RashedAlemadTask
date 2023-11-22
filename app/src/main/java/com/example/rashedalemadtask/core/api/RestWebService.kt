package com.example.rashedalemadtask.core.api

import com.example.rashedalemadtask.core.api.models.BreedsResponse
import com.example.rashedalemadtask.core.util.Globalvars
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface RestWebService {

    @GET(Globalvars.API_ALL_BREEDS)
    suspend fun getAllBreeds(): Response<BreedsResponse>
}