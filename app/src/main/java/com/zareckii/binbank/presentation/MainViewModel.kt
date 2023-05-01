package com.zareckii.binbank.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zareckii.binbank.data.BankRepository
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(
    private val uiMapper: UIMapper,
    private val dispatchersList: DispatchersList,
    private val repository: BankRepository,
    val liveData: MutableLiveData<UiState>
    ) : ViewModel() {

        fun fetch(input: String) {
            liveData.value = UiState.Loading
            viewModelScope.launch(dispatchersList.io()) {
                val result = repository.fetch(input).map(uiMapper)
                withContext(dispatchersList.ui()) {
                    liveData.value = result
                }
            }
        }


}