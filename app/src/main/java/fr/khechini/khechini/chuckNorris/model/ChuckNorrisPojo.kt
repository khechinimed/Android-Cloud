package fr.khechini.khechini.chuckNorris.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/** Object use for Ui */
data class ChuckNorrisUi(
    val quote: String,
    val iconUrl: String
)

/** Object use for room */
@Entity(tableName = "chuck_norris_quote")
data class ChuckNorrisRoom(
    @ColumnInfo(name = "quote_text")
    val quote: String,

    @ColumnInfo(name = "quote_icon_url")
    val iconUrl: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}

/** Object use for retrofit */
data class ChuckNorrisRetrofit(
    @Expose
    @SerializedName("value")
    val quote: String,

    @Expose
    @SerializedName("icon_url")
    val iconUrl: String
)