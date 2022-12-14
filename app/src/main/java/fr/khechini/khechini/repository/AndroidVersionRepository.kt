package fr.khechini.khechini.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import fr.khechini.khechini.architecture.CustomApplication
import fr.khechini.khechini.model.LocalDataSourceSample
import fr.khechini.khechini.model.ObjectDataSample

class AndroidVersionRepository {

    private val mAndroidVersionDao =
        CustomApplication.instance.mApplicationDatabase.androidVersionDao()

    fun selectAllAndroidVersion(): LiveData<List<ObjectDataSample>> {
        return mAndroidVersionDao.selectAll().map { list ->
            list.toObjectDataSample()
        }
    }

    fun insertAndroidVersion(objectDataSample: ObjectDataSample) {
        mAndroidVersionDao.insert(objectDataSample.toRoomObject())
    }

    fun deleteAllAndroidVersion() {
        mAndroidVersionDao.deleteAll()
    }
}

private fun ObjectDataSample.toRoomObject(): LocalDataSourceSample {
    return LocalDataSourceSample(
        name = versionName,
        code = versionCode,
        image = versionImage
    )
}

private fun List<LocalDataSourceSample>.toObjectDataSample(): List<ObjectDataSample> {
    return map { eachItem ->
        ObjectDataSample(
            versionCode = eachItem.code,
            versionName = eachItem.name,
            versionImage = eachItem.image
        )
    }
}