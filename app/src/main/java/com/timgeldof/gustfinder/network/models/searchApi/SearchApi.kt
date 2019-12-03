package com.timgeldof.gustfinder.network.models.searchApi
/**
 * Contains a [List] of [Result] for the given query parameters of the api call
 */
data class SearchApi(

    val result: List<Result>
)