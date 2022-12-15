package fr.khechini.khechini.chuckNorris.repository

import androidx.lifecycle.LiveData
import fr.khechini.khechini.architecture.CustomApplication
import fr.khechini.khechini.architecture.RetrofitBuilder
import fr.khechini.khechini.chuckNorris.model.ChuckNorrisRetrofit
import fr.khechini.khechini.chuckNorris.model.ChuckNorrisRoom
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ChuckNorrisQuoteRepository {

    private val chuckNorrisDao = CustomApplication.instance.mApplicationDatabase.chuckNorrisDao()

    fun selectAllChuckNorrisQuote(): LiveData<List<ChuckNorrisRoom>> {
        return chuckNorrisDao.selectAll()
    }

    private suspend fun insertChuckNorrisQuote(chuckNorrisQuote: ChuckNorrisRoom) =
        withContext(Dispatchers.IO) {
            chuckNorrisDao.insert(chuckNorrisQuote)
        }

    suspend fun deleteAllChuckNorrisQuote() = withContext(Dispatchers.IO) {
        chuckNorrisDao.deleteAll()
    }

    suspend fun fetchData() {
        insertChuckNorrisQuote(RetrofitBuilder.getChuckNorrisQuote().getRandomQuote().toRoom())
    }
}

private fun ChuckNorrisRetrofit.toRoom(): ChuckNorrisRoom {
    return ChuckNorrisRoom(
        quote = quote,
        iconUrl = iconUrl
    )
}