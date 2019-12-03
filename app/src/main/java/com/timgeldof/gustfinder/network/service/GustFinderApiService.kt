package com.timgeldof.gustfinder.network.service

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.timgeldof.gustfinder.network.models.searchApi.ApiSearchResponse
import com.timgeldof.gustfinder.network.models.marineWeatherApi.ApiWeatherResponse

import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

val BASE_URL: String =
    "http://api.worldweatheronline.com/"
/**
 * instance of class [Moshi]
 */
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()
/**
 * instance of class [Retrofit]
 */
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()
/**
 * interface used by retrofit to implement API calls
 */
interface GustFinderApiService {
    @GET("premium/v1/search.ashx?key=4e2cb7498c154ab9a3d155550191811&num_of_results=5&format=json")
    fun getLocationSearchResultsAsync(@Query("query") query: String): Deferred<ApiSearchResponse>

    @GET("premium/v1/marine.ashx?key=4e2cb7498c154ab9a3d155550191811&format=json")
    fun getForecastAsync(@Query("q") query: String): Deferred<ApiWeatherResponse>
}
/**
 * contains a lazily instantiated instance of [GustFinderApiService]
 */
object GustFinderApi {
    val retrofitService: GustFinderApiService by lazy {
        retrofit.create(GustFinderApiService::class.java)
    }
}