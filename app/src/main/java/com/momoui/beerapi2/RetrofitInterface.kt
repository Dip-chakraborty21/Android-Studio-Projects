package com.momoui.beerapi2


import com.momoui.beerapi2.models.BeerResponseItem
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitInterface {
    @GET("beers")
    suspend fun getAllBeers(): Response<BeerResponseItem>
}