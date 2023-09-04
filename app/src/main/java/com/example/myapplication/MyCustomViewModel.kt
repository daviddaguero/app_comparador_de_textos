package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyCustomViewModel : ViewModel() {
    private val _comparisonResult = MutableLiveData<String>()
    val comparisonResult: LiveData<String> get() = _comparisonResult

    fun compareStrings(text1: String, text2: String) {
        val result: String = if (text1 == text2) {
            "Los textos son iguales"
        } else {
            "Los textos son diferentes"
        }
        _comparisonResult.value = result
    }
}
