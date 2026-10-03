package com.example.radiofree.app.data.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.radiofree.app.connection.ApiResponde
import com.example.radiofree.app.data.appdatabase.Repository
import com.example.radiofree.app.data.classes.Languages
import com.example.radiofree.app.data.classes.State
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ViewModelClass(val repository: Repository) : ViewModel() {
    private val _languages = MutableStateFlow<List<Languages>>(emptyList())
    val languages: StateFlow<List<Languages>> = _languages.asStateFlow()
    fun pegarLinguiagens() {
        viewModelScope.launch {
            try {
                _languages.value = repository.getAllLanguages()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}