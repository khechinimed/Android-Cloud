package fr.khechini.khechini.chuckNorris.remote

import fr.khechini.khechini.chuckNorris.model.ChuckNorrisRetrofit
import retrofit2.http.GET

interface ChuckNorrisQuoteEndpoint {

    @GET("random")
    suspend fun getRandomQuote() : ChuckNorrisRetrofit
}