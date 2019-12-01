[app](../../index.md) / [com.timgeldof.gustfinder.screens.add_place](../index.md) / [AddPlaceViewModel](./index.md)

# AddPlaceViewModel

`class AddPlaceViewModel : AndroidViewModel`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `AddPlaceViewModel(database: `[`PlaceDatabaseDao`](../../com.timgeldof.gustfinder.database/-place-database-dao/index.md)`, application: `[`Application`](https://developer.android.com/reference/android/app/Application.html)`)` |

### Properties

| Name | Summary |
|---|---|
| [database](database.md) | `val database: `[`PlaceDatabaseDao`](../../com.timgeldof.gustfinder.database/-place-database-dao/index.md) |
| [response](response.md) | `val response: LiveData<`[`ApiSearchResponse`](../../com.timgeldof.gustfinder.network.models.search_api/-api-search-response/index.md)`>` |
| [status](status.md) | `val status: LiveData<`[`ApiStatus`](../-api-status/index.md)`>` |

### Functions

| Name | Summary |
|---|---|
| [getSearchResults](get-search-results.md) | `fun getSearchResults(query: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [insertPlaceIntoDatabase](insert-place-into-database.md) | `suspend fun insertPlaceIntoDatabase(place: `[`Place`](../../com.timgeldof.gustfinder.database/-place/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onCleared](on-cleared.md) | `fun onCleared(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
