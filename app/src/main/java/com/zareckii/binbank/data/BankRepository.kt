package com.zareckii.binbank.data

import com.zareckii.binbank.R
import java.net.UnknownHostException

interface BankRepository {

    suspend fun fetch(input: String): DataResult

    class Base(
        private val service: BankService,
        private val provideResource: ProvideResource
    ) : BankRepository {

        override suspend fun fetch(input: String): DataResult {
            return try {
                val result = service.fetch(input)
                DataResult.Success(result)
            } catch (e: Exception) {

                val messageId = if (e is UnknownHostException)
                    R.string.no_connection_message
                else
                    R.string.sevice_unavailable
                DataResult.Error(provideResource.string(messageId))
            }
        }
    }
}
