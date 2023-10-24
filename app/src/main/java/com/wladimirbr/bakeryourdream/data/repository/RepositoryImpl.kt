package com.wladimirbr.bakeryourdream.data.repository


import com.wladimirbr.bakeryourdream.data.remote.BackEndAPI
import com.wladimirbr.bakeryourdream.domain.model.ApiRequest
import com.wladimirbr.bakeryourdream.domain.model.ApiResponse
import com.wladimirbr.bakeryourdream.domain.repository.DataStoreOperations
import com.wladimirbr.bakeryourdream.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val dataStoreOperations: DataStoreOperations,
    private val BackEndAPI: BackEndAPI
) : Repository {
    override suspend fun saveSignedInState(signedIn: Boolean) {
        dataStoreOperations.saveSignedInState(signedIn = signedIn)
    }

    override fun readSignedInState(): Flow<Boolean> {
        return dataStoreOperations.readSignedInState()
    }

    override suspend fun verifyTokenOnBackend(request: ApiRequest): ApiResponse {
        return try {
            BackEndAPI.verifyTokenOnBackend(request = request)
        } catch (e: Exception) {
            ApiResponse(success = false, error = e)
        }
    }

}