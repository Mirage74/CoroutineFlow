package com.balex.coroutineflow.crypto_app

sealed class State {
    data object Initial : State()
    data object Loading : State()
    data class Content(val currencyList: List<Currency>) : State()
}