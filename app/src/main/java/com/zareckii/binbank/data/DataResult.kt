package com.zareckii.binbank.data

import com.zareckii.binbank.presentation.UIMapper
import com.zareckii.binbank.presentation.UiState

interface DataResult {

    fun map(mapper: UIMapper): UiState

    data class Success(val cloud: BinCloud) : DataResult {
        override fun map(mapper: UIMapper): UiState = mapper.mapSuccess(cloud)
    }

    data class Error(val message: String) : DataResult {
        override fun map(mapper: UIMapper): UiState = mapper.mapError(message)
    }
}