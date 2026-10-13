package com.example.radiofree.app.data.appdatabase

import androidx.compose.runtime.mutableStateOf
import com.example.radiofree.app.connection.ApiResponde
import com.example.radiofree.app.data.classes.CodecsCountrysCode
import com.example.radiofree.app.data.classes.Languages
import com.example.radiofree.app.data.classes.RadioStation
import com.example.radiofree.app.data.classes.State
import com.example.radiofree.app.data.dao.RadioStatesDAO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.UUID

class Repository(
    private val apiResponde: ApiResponde, val radioStatesDAO: RadioStatesDAO
) {
    val _languages = MutableStateFlow<List<Languages>>(emptyList())
    val languages: StateFlow<List<Languages>> = _languages.asStateFlow()

    val _isFavorite = MutableStateFlow(false)
    val isFavorite: StateFlow<Boolean> = _isFavorite


    suspend fun checkFavotire(statiUUID: String) {
        _isFavorite.value = radioStatesDAO.isFavorite(statiUUID)
    }

    suspend fun addToFavorites(radioStation: RadioStation) {
        radioStatesDAO.insertToFavorites(radioStation)
        _isFavorite.value = radioStatesDAO.isFavorite(radioStation.stationUuid)
    }

    suspend fun removeFromFavorites(radioStation: String) {
        radioStatesDAO.deleteFromFavorites(radioStation)
        _isFavorite.value = radioStatesDAO.isFavorite(radioStation)
    }

    fun getAllFavotires(): Flow<List<RadioStation>> {
        return radioStatesDAO.getAllFavorites()
    }

    suspend fun getAllStations(
        order: String = "name",
        reverse: Boolean = false,
        hideBroken: Boolean = true,
        offset: Int = 0,
        limit: Int = 100
    ): List<RadioStation> {
        return apiResponde.getAllStations(
            order = order,
            reverse = reverse,
            hideBroken = hideBroken,
            offset = offset,
            limit = limit
        )
    }

    suspend fun getStationById(
        searchTerm: String,
        order: String = "name",
        reverse: Boolean = false,
        hideBroken: Boolean = false,
        offset: Int = 0,
        limit: Int = 100
    ): List<RadioStation> {
        return apiResponde.getStationById(
            searchTerm = searchTerm,
            order = order,
            reverse = reverse,
            hideBroken = hideBroken,
            offset = offset,
            limit = limit
        )
    }

    suspend fun getByName(
        searchTerm: String,
        order: String = "name",
        reverse: Boolean = false,
        hideBroken: Boolean = false,
        offset: Int = 0,
        limit: Int = 100
    ): List<RadioStation> {
        return apiResponde.getByName(
            searchTerm = searchTerm,
            order = order,
            reverse = reverse,
            hideBroken = hideBroken,
            offset = offset,
            limit = limit
        )
    }

    suspend fun getByNameExact(
        searchTerm: String,
        order: String = "name",
        reverse: Boolean = false,
        hideBroken: Boolean = false,
        offset: Int = 0,
        limit: Int = 100
    ): List<RadioStation> {
        return apiResponde.getByNameExact(
            searchTerm = searchTerm,
            order = order,
            reverse = reverse,
            hideBroken = hideBroken,
            offset = offset,
            limit = limit
        )
    }

    suspend fun getByCodec(
        searchTerm: String,
        order: String = "name",
        reverse: Boolean = false,
        hideBroken: Boolean = false,
        offset: Int = 0,
        limit: Int = 100
    ): List<RadioStation> {
        return apiResponde.getByCodec(
            searchTerm = searchTerm,
            order = order,
            reverse = reverse,
            hideBroken = hideBroken,
            offset = offset,
            limit = limit
        )
    }

    suspend fun getByCodecExact(
        searchTerm: String,
        order: String = "name",
        reverse: Boolean = false,
        hideBroken: Boolean = false,
        offset: Int = 0,
        limit: Int = 100
    ): List<RadioStation> {
        return apiResponde.getByCodecExact(
            searchTerm = searchTerm,
            order = order,
            reverse = reverse,
            hideBroken = hideBroken,
            offset = offset,
            limit = limit
        )
    }

    suspend fun getByCountry(
        searchTerm: String,
        order: String = "name",
        reverse: Boolean = false,
        hideBroken: Boolean = false,
        offset: Int = 0,
        limit: Int = 100
    ): List<RadioStation> {
        return apiResponde.getByCountry(
            searchTerm = searchTerm,
            order = order,
            reverse = reverse,
            hideBroken = hideBroken,
            offset = offset,
            limit = limit
        )
    }

    suspend fun getByCountryExact(
        searchTerm: String,
        order: String = "name",
        reverse: Boolean = false,
        hideBroken: Boolean = false,
        offset: Int = 0,
        limit: Int = 100
    ): List<RadioStation> {
        return apiResponde.getByCountryExact(
            searchTerm = searchTerm,
            order = order,
            reverse = reverse,
            hideBroken = hideBroken,
            offset = offset,
            limit = limit
        )
    }

    suspend fun getByCountryCodeExact(
        searchTerm: String,
        order: String = "name",
        reverse: Boolean = false,
        hideBroken: Boolean = false,
        offset: Int = 0,
        limit: Int = 100
    ): List<RadioStation> {
        return apiResponde.getByCountryCodeExact(
            searchTerm = searchTerm,
            order = order,
            reverse = reverse,
            hideBroken = hideBroken,
            offset = offset,
            limit = limit
        )
    }

    suspend fun getByState(
        searchTerm: String,
        order: String = "name",
        reverse: Boolean = false,
        hideBroken: Boolean = false,
        offset: Int = 0,
        limit: Int = 100
    ): List<RadioStation> {
        return apiResponde.getByState(
            searchTerm = searchTerm,
            order = order,
            reverse = reverse,
            hideBroken = hideBroken,
            offset = offset,
            limit = limit
        )
    }

    suspend fun getByStateExact(
        searchTerm: String,
        order: String = "name",
        reverse: Boolean = false,
        hideBroken: Boolean = false,
        offset: Int = 0,
        limit: Int = 100
    ): List<RadioStation> {
        return apiResponde.getByStateExact(
            searchTerm = searchTerm,
            order = order,
            reverse = reverse,
            hideBroken = hideBroken,
            offset = offset,
            limit = limit
        )
    }

    suspend fun getByLanguage(
        searchTerm: String,
        order: String = "name",
        reverse: Boolean = false,
        hideBroken: Boolean = false,
        offset: Int = 0,
        limit: Int = 100
    ): List<RadioStation> {
        return apiResponde.getByLanguage(
            searchTerm = searchTerm,
            order = order,
            reverse = reverse,
            hideBroken = hideBroken,
            offset = offset,
            limit = limit
        )
    }

    suspend fun getByLanguageExact(
        searchTerm: String,
        order: String = "name",
        reverse: Boolean = false,
        hideBroken: Boolean = false,
        offset: Int = 0,
        limit: Int = 100
    ): List<RadioStation> {
        return apiResponde.getByLanguageExact(
            searchTerm = searchTerm,
            order = order,
            reverse = reverse,
            hideBroken = hideBroken,
            offset = offset,
            limit = limit
        )
    }

    suspend fun getByTag(
        searchTerm: String,
        order: String = "name",
        reverse: Boolean = false,
        hideBroken: Boolean = false,
        offset: Int = 0,
        limit: Int = 100
    ): List<RadioStation> {
        return apiResponde.getByTag(
            searchTerm = searchTerm,
            order = order,
            reverse = reverse,
            hideBroken = hideBroken,
            offset = offset,
            limit = limit
        )
    }

    suspend fun getByTagExact(
        searchTerm: String,
        order: String = "name",
        reverse: Boolean = false,
        hideBroken: Boolean = false,
        offset: Int = 0,
        limit: Int = 100
    ): List<RadioStation> {
        return apiResponde.getByTagExact(
            searchTerm = searchTerm,
            order = order,
            reverse = reverse,
            hideBroken = hideBroken,
            offset = offset,
            limit = limit
        )
    }

    suspend fun getAllCodecs(): List<CodecsCountrysCode> {
        return apiResponde.getByCodecs()
    }

    suspend fun getCodecsFilter(
        filter: String,
        order: String = "name",
        reverse: Boolean = false,
        hideBroken: Boolean = true,
        offset: Int = 0,
        limit: Int = 100
    ): List<CodecsCountrysCode> {
        return apiResponde.getCodecsFilter(
            filter = filter,
            order = order,
            reverse = reverse,
            hideBroken = hideBroken,
            offset = offset,
            limit = limit
        )
    }

    suspend fun getAllCountries(): List<CodecsCountrysCode> {
        return apiResponde.getByCountries()
    }

    suspend fun getCountriesFilter(
        filter: String,
        order: String = "name",
        reverse: Boolean = false,
        hideBroken: Boolean = true,
        offset: Int = 0,
        limit: Int = 100
    ): List<CodecsCountrysCode> {
        return apiResponde.getCountriesFilter(
            filter = filter,
            order = order,
            reverse = reverse,
            hideBroken = hideBroken,
            offset = offset,
            limit = limit
        )
    }

    suspend fun getAllStates(): List<State> {
        return apiResponde.getAllStates()
    }

    suspend fun getStateByFilter(
        filter: String,
        order: String = "name",
        reverse: Boolean = false,
        hideBroken: Boolean = true,
        offset: Int = 0,
        limit: Int = 100
    ): List<State> {
        return apiResponde.getStateByFilter(
            filter = filter,
            order = order,
            reverse = reverse,
            hideBroken = hideBroken,
            offset = offset,
            limit = limit
        )
    }

    suspend fun getStateByCountryFilter(
        country: String,
        filter: String,
        order: String = "name",
        reverse: Boolean = false,
        hideBroken: Boolean = true,
        offset: Int = 0,
        limit: Int = 100
    ): List<State> {
        return apiResponde.getStateByCountryFilter(
            country = country,
            filter = filter,
            order = order,
            reverse = reverse,
            hideBroken = hideBroken,
            offset = offset,
            limit = limit
        )
    }


    suspend fun getAllLanguages(): List<Languages> {
        return apiResponde.getByLanguages(
            offset = 0,
            limit = 100
        )
    }

    suspend fun getByLanguageFilter(
        filter: String,
        order: String = "name",
        reverse: Boolean = false,
        hideBroken: Boolean = true,
        offset: Int = 0,
        limit: Int = 100
    ): List<Languages> {
        return apiResponde.getByLanguageFilter(
            filter = filter,
            order = order,
            reverse = reverse,
            hideBroken = hideBroken,
            offset = offset,
            limit = limit
        )
    }
}
