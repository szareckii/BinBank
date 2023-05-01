package com.zareckii.binbank.data

import android.content.Context

interface ProvideResource {
    fun string(id: Int) : String

    class Base(private val context: Context) : ProvideResource{
        override fun string(id: Int): String = context.getString(id)
    }
}