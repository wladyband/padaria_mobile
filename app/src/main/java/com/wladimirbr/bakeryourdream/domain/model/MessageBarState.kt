package com.wladimirbr.bakeryourdream.domain.model


data class MessageBarState(
    val message: String? = null,
    val error: Exception? = null
)