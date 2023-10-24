package com.wladimirbr.bakeryourdream.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class ApiRequest(
    val tokenId: String
)