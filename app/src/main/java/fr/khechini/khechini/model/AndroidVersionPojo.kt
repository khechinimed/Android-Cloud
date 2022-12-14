package fr.khechini.khechini.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

sealed class MyObjectForRecyclerView(label: String)


data class ObjectDataHeaderSample(
    val header: String
) : MyObjectForRecyclerView(label = header)


data class ObjectDataSample(
    val versionName: String,
    val versionCode: Int,
    val versionImage: String
) : MyObjectForRecyclerView(label = versionName)

@Entity(tableName = "android_version_object_table")
data class LocalDataSourceSample(
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "code")
    val code: Int,
    @ColumnInfo(name = "image")
    val image: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}