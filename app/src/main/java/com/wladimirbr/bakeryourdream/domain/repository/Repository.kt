package com.wladimirbr.bakeryourdream.domain.repository

import com.wladimirbr.bakeryourdream.domain.model.ApiRequest
import com.wladimirbr.bakeryourdream.domain.model.ApiResponse
import com.wladimirbr.bakeryourdream.domain.model.UserUpdate
import kotlinx.coroutines.flow.Flow
interface Repository {
    suspend fun saveSignedInState(signedIn: Boolean)
    fun readSignedInState(): Flow<Boolean>
    suspend fun verifyTokenOnBackend(request: ApiRequest): ApiResponse


}