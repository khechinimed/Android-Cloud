package fr.khechini.khechini.architecture

import androidx.room.Database
import androidx.room.RoomDatabase
import fr.khechini.khechini.chuckNorris.dao.ChuckNorrisDao
import fr.khechini.khechini.chuckNorris.model.ChuckNorrisRoom
import fr.khechini.khechini.dao.AndroidVersionDao2
import fr.khechini.khechini.yourFeature.dao.AndroidVersionDao
import fr.khechini.khechini.yourFeature.model.LocalDataSourceSample


@Database(
    entities = [

        LocalDataSourceSample::class,
        ChuckNorrisRoom::class
    ],
    version = 3,
    exportSchema = false
)
abstract class CustomRoomDatabase : RoomDatabase() {

    abstract fun androidVersionDao(): AndroidVersionDao

    abstract fun androidVersionDao2() : AndroidVersionDao2

    abstract fun chuckNorrisDao() : ChuckNorrisDao
}