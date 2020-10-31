package com.example.weathertz.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelLocality: ViewModel() {
    val getPermission = MutableLiveData(false)
}