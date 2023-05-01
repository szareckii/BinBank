package com.zareckii.binbank.data

import retrofit2.http.GET
import retrofit2.http.Path

interface BankService {

    @GET("{number}")
    suspend fun fetch(@Path("number", encoded = true) number: String): BinCloud
}