package com.example.radiofree.app.data.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.radiofree.app.connection.ApiResponde
import com.example.radiofree.app.data.appdatabase.Repository
import com.example.radiofree.app.data.classes.Languages
import com.example.radiofree.app.data.classes.RadioStation
import com.example.radiofree.app.data.classes.State
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ViewModelClass(val repository: Repository) : ViewModel() {
    private val _languages = MutableStateFlow<List<Languages>>(emptyList())
    val languages: StateFlow<List<Languages>> = _languages.asStateFlow()
    private val _radios = MutableStateFlow<List<RadioStation>>(emptyList())
    val radios: StateFlow<List<RadioStation>> = _radios.asStateFlow()


    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _hasError = MutableStateFlow(false)
    val hasError: StateFlow<Boolean> = _hasError.asStateFlow()

    val _playing = MutableStateFlow<String?>(null)
    val playing: StateFlow<String?> = _playing.asStateFlow()
    val _isFavorite = MutableStateFlow<List<RadioStation>>(emptyList())
    val isFavorite: StateFlow<List<RadioStation>> = _isFavorite.asStateFlow()
    fun setPlayingStationUiid(uiid: String?) {
        _playing.value = uiid
    }

    fun isPlayingStation(uuid: String): Boolean {

        return _playing.value == uuid

    }

    fun addAosFavoritos(radioStation: RadioStation){
        viewModelScope.launch {
            repository.addToFavorites(radioStation)
        }
    }

    fun pegarTodasAsEstacoesDeRadios() {
        if (_isLoading.value) return

        viewModelScope.launch {
            _isLoading.value = true
            _hasError.value = false

            try {
                _radios.value = repository.getAllStations()
            } catch (e: Exception) {
                _hasError.value = true

                android.util.Log.e(
                    "RadioFreeAPI",
                    "Falha ao carregar estações de rádio",
                    e
                )
            } finally {
                _isLoading.value = false
            }
        }
    }


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