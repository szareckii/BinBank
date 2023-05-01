package com.zareckii.binbank

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.zareckii.binbank.data.BankRepository
import com.zareckii.binbank.data.BankService
import com.zareckii.binbank.data.ProvideResource
import com.zareckii.binbank.presentation.DispatchersList
import com.zareckii.binbank.presentation.MainViewModel
import com.zareckii.binbank.presentation.UIMapper
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class App : Application() {

    lateinit var viewModel: MainViewModel

    override fun onCreate() {
        super.onCreate()
        viewModel = MainViewModel(
            UIMapper.Base(),
            DispatchersList.Base(),
            BankRepository.Base(
                Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://lookup.binlist.net")
                    .build()
                    .create(BankService::class.java),
                ProvideResource.Base(this)
            ),
            MutableLiveData()
        )
    }
}