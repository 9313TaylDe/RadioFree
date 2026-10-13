
package com.example.radiofree.app.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.radiofree.app.data.classes.RadioStation
import kotlinx.coroutines.flow.Flow

@Dao
interface RadioStatesDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertToFavorites(radioStation: RadioStation)

    @Query(
        "DELETE FROM RadioStation WHERE stationUuid = :stationUuid"
    )
    suspend fun deleteFromFavorites(stationUuid: String)

    @Query("SELECT * FROM RadioStation ORDER BY name ASC")
    fun getAllFavorites(): Flow<List<RadioStation>>

    @Query(
        "SELECT EXISTS(" +
                "SELECT 1 FROM RadioStation " +
                "WHERE stationUuid = :stationUuid)"
    )
    suspend fun isFavorite(stationUuid: String): Boolean
}
