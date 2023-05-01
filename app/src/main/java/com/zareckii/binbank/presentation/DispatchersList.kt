package com.zareckii.binbank.presentation

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

interface DispatchersList {

    fun ui(): CoroutineDispatcher
    fun io(): CoroutineDispatcher

    class Base : DispatchersList {

        override fun ui() = Dispatchers.Main

        override fun io() = Dispatchers.IO
    }
}