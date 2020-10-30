package com.example.weathertz

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelLocality: ViewModel() {
    val getPermission = MutableLiveData(false)
}