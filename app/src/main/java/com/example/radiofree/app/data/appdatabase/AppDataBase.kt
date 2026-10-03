package com.example.radiofree.app.data.appdatabase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.radiofree.app.data.classes.Languages
import com.example.radiofree.app.data.classes.RadioStation
import com.example.radiofree.app.data.classes.State
import com.example.radiofree.app.data.dao.RadioStatesDAO

@Database(
    entities = [
        RadioStation::class,
    ], version = 1,
    exportSchema = false,
)
abstract class AppDataBase: RoomDatabase() {
    abstract fun radiostates(): RadioStatesDAO
}