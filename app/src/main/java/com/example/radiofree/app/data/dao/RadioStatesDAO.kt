package com.example.radiofree.app.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.radiofree.app.data.classes.RadioStation
import kotlinx.coroutines.flow.Flow

@Dao

interface RadioStatesDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertToFavorites(radioStation: RadioStation)

    @Delete()
    suspend fun deleteFromFavorites(radioStation: RadioStation)

    @Query("SELECT * FROM RadioStation")
     fun getAllFavorites(): Flow<List<RadioStation>>

    @Query("SELECT EXISTS(SELECT 1 FROM RadioStation WHERE  stationUuid  = :stationUuid )")
    suspend fun isFavorite(stationUuid:String): Boolean
}