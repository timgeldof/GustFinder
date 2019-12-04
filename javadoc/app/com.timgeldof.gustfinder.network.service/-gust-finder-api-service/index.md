[app](../../index.md) / [com.timgeldof.gustfinder.network.service](../index.md) / [GustFinderApiService](./index.md)

# GustFinderApiService

`interface GustFinderApiService`

interface used by retrofit to implement API calls

### Functions

| Name | Summary |
|---|---|
| [getForecastAsync](get-forecast-async.md) | `abstract fun getForecastAsync(query: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Deferred<`[`ApiWeatherResponse`](../../com.timgeldof.gustfinder.network.models.marine-weather-api/-api-weather-response/index.md)`>` |
| [getLocationSearchResultsAsync](get-location-search-results-async.md) | `abstract fun getLocationSearchResultsAsync(query: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Deferred<`[`ApiSearchResponse`](../../com.timgeldof.gustfinder.network.models.search-api/-api-search-response/index.md)`>` |
