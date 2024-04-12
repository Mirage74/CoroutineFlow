package com.balex.coroutineflow.crypto_app

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart


class CryptoViewModel : ViewModel() {

    private val repository = CryptoRepository

    //private val _state = MutableLiveData<State>(State.Initial)
    //val state: LiveData<State> = _state

    val state: LiveData<State> = repository.getCurrencyList()

        .filter { it.isNotEmpty() }
        .map { State.Content(currencyList = it) as State }
        .onStart {
            emit(State.Loading)
        }
        //.onEach { _state.value =  it }
        //.launchIn(viewModelScope)
        .asLiveData()


}