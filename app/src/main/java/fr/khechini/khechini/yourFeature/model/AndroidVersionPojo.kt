package fr.khechini.khechini.yourFeature.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

sealed class MyObjectForRecyclerView(label: String)

/** Object used in UI */
data class ObjectDataHeaderSample(
    val header: String
) : MyObjectForRecyclerView(label = header)


data class ObjectDataSample(
    val versionName: String,
    val versionCode: Int,
    val versionImage: String
) : MyObjectForRecyclerView(label = versionName)

/** Object used for room (DDB) */
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
