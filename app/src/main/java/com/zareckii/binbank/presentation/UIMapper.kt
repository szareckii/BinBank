package com.zareckii.binbank.presentation

import com.zareckii.binbank.data.BinCloud

interface UIMapper {

    fun mapSuccess(cloud: BinCloud): UiState

    fun mapError(message: String): UiState

    class Base : UIMapper {
        override fun mapSuccess(cloud: BinCloud): UiState {
            val result = cloud.toString()
            return UiState.Success(result)
        }

        override fun mapError(message: String) = UiState.Error(message)
    }
}
