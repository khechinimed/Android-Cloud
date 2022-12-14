package fr.khechini.khechini.architecture

import androidx.room.Database
import androidx.room.RoomDatabase
import fr.khechini.khechini.dao.AndroidVersionDao
import fr.khechini.khechini.model.LocalDataSourceSample

@Database(
    entities = [
        LocalDataSourceSample::class
    ],
    version = 1,
    exportSchema = false
)
abstract class CustomRoomDatabase : RoomDatabase() {

    abstract fun androidVersionDao(): AndroidVersionDao
}