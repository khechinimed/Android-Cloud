package fr.khechini.khechini.model

sealed class MyObjectForRecyclerView(label : String)

data class ObjectDataHeaderSample(
    val header: String
) : MyObjectForRecyclerView(label = header)

data class ObjectDataSample(
    val versionName: String,
    val versionCode: Int,
    val versionImage: String,
) : MyObjectForRecyclerView(label = versionName)