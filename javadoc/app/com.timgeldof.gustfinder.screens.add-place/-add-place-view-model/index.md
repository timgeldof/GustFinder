[app](../../index.md) / [com.timgeldof.gustfinder.screens.addPlace](../index.md) / [AddPlaceViewModel](./index.md)

# AddPlaceViewModel

`class AddPlaceViewModel : ViewModel`

Subclass of the [AndroidViewModel](#)

``` kotlin
//Unresolved: com.mycompany.SomethingTest.simple
```

### Parameters

`database` - [PlaceDatabaseDao](../../com.timgeldof.gustfinder.database/-place-database-dao/index.md) to be used in this class to insert the new Place

`application` -

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | Subclass of the [AndroidViewModel](#)`AddPlaceViewModel(database: `[`PlaceDatabaseDao`](../../com.timgeldof.gustfinder.database/-place-database-dao/index.md)`)` |

### Properties

| Name | Summary |
|---|---|
| [database](database.md) | [PlaceDatabaseDao](../../com.timgeldof.gustfinder.database/-place-database-dao/index.md) to be used in this class to insert the new Place`val database: `[`PlaceDatabaseDao`](../../com.timgeldof.gustfinder.database/-place-database-dao/index.md) |
| [response](response.md) | `val response: LiveData<`[`ApiSearchResponse`](../../com.timgeldof.gustfinder.network.models.search-api/-api-search-response/index.md)`>` |
| [status](status.md) | `val status: LiveData<`[`ApiStatus`](../-api-status/index.md)`>` |

### Functions

| Name | Summary |
|---|---|
| [getSearchResults](get-search-results.md) | Sets the value of the _response [LiveData](#) to the api response by using debounce implemented with coroutines`fun getSearchResults(query: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [insertPlaceIntoDatabase](insert-place-into-database.md) | Inserts place into the places_table in a coroutine within the IO context`suspend fun insertPlaceIntoDatabase(place: `[`Place`](../../com.timgeldof.gustfinder.database/-place/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onCleared](on-cleared.md) | `fun onCleared(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
