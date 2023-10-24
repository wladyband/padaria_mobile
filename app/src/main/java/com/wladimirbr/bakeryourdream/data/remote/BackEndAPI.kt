package com.wladimirbr.bakeryourdream.data.remote

import com.wladimirbr.bakeryourdream.domain.model.ApiRequest
import com.wladimirbr.bakeryourdream.domain.model.ApiResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface BackEndAPI {
    @POST("/users/extract-aud")
    suspend fun verifyTokenOnBackend(
        @Body request: ApiRequest
    ) : ApiResponse
}