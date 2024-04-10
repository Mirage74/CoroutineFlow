package com.balex.coroutineflow.crypto_app

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

//5.55

class CryptoViewModel : ViewModel() {

    private val repository = CryptoRepository

    private val _state = MutableLiveData<State>(State.Initial)
    val state: LiveData<State> = _state

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            val currentState = _state.value
            if (currentState !is State.Content || currentState.currencyList.isEmpty()) {
                _state.value = State.Loading
            }

            repository.getCurrencyList()
                .collect {
                    _state.value = State.Content(it)
                }




//            while (true) {
//                val currentState = _state.value
//                if (currentState !is State.Content || currentState.currencyList.isEmpty()) {
//                    _state.value = State.Loading
//                }
//                val currencyList = repository.getCurrencyList()
//                _state.value = State.Content(currencyList = currencyList)
//                delay(3000)
//            }
        }
    }
}