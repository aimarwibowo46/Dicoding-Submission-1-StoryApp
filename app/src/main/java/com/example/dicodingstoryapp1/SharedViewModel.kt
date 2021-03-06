package com.example.dicodingstoryapp1

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.dicodingstoryapp1.model.UserAuth
import kotlinx.coroutines.launch

class SharedViewModel(private val pref: UserPreference) : ViewModel() {
    fun getUser() : LiveData<UserAuth> {
        return pref.getUser().asLiveData()
    }

    fun saveUser(user: UserAuth) {
        viewModelScope.launch {
            pref.saveUser(user)
        }
    }

    fun logout() {
        viewModelScope.launch {
            pref.logout()
        }
    }
}