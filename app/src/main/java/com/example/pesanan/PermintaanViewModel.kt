package com.example.pesanan

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class PermintaanViewModel : ViewModel() {
    // Mutable state for the permintaan status
    private val _permintaanStatus = mutableStateOf("Permintaan sedang diproses")
    val permintaanStatus: State<String> = _permintaanStatus // Correct type

    // Function to update the status
    fun updatePermintaanStatus(newStatus: String) {
        _permintaanStatus.value = newStatus
    }
}