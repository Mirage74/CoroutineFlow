package com.balex.coroutineflow.lessons.lesson2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class UsersViewModel : ViewModel() {

    private val repository = UsersRepository

    private val _users = MutableLiveData<List<String>>()
    val users: LiveData<List<String>> = _users

    init {
        loadUsers()
        //Log.d("UsersViewModel", "UsersViewModel init")
    }

    fun addUser(user: String) {
        viewModelScope.launch {
            repository.addUser(user)
        }
    }

//    fun loadUsers() {
//        viewModelScope.launch {
//            _users.value = UsersRepository.loadUsers()
//        }
//    }

    private fun loadUsers() {
        viewModelScope.launch {
                 repository.loadUsers()
                .collect {
                    _users.value = it
                }
        }
    }


}