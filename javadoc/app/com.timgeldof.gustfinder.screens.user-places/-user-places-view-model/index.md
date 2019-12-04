[app](../../index.md) / [com.timgeldof.gustfinder.screens.userPlaces](../index.md) / [UserPlacesViewModel](./index.md)

# UserPlacesViewModel

`class UserPlacesViewModel : ViewModel`

Subclass of the [ViewModel](#) class

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | Subclass of the [ViewModel](#) class`UserPlacesViewModel(database: `[`PlaceDatabaseDao`](../../com.timgeldof.gustfinder.database/-place-database-dao/index.md)`)` |

### Properties

| Name | Summary |
|---|---|
| [database](database.md) | `val database: `[`PlaceDatabaseDao`](../../com.timgeldof.gustfinder.database/-place-database-dao/index.md) |
| [myPlaces](my-places.md) | `val myPlaces: LiveData<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Place`](../../com.timgeldof.gustfinder.database/-place/index.md)`>>` |
| [navigateToSelectedPlace](navigate-to-selected-place.md) | `val navigateToSelectedPlace: LiveData<`[`Place`](../../com.timgeldof.gustfinder.database/-place/index.md)`>` |

### Functions

| Name | Summary |
|---|---|
| [displayPlaceDetails](display-place-details.md) | Sets the navigation [LiveData](#) which triggers a navigation in the fragment when changed`fun displayPlaceDetails(place: `[`Place`](../../com.timgeldof.gustfinder.database/-place/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [displayPlaceDetailsComplete](display-place-details-complete.md) | Resets the navigation [LiveData](#) which triggers a navigation in the fragment when changed`fun displayPlaceDetailsComplete(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [getPlacesFromDB](get-places-from-d-b.md) | Fetches the places from the database and sets it to the value of the _myPlaces [LiveData](#) property within a coroutine`fun getPlacesFromDB(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onCleared](on-cleared.md) | `fun onCleared(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [removePlaceFromDatabase](remove-place-from-database.md) | Removes the place from database user_places table within a coroutine`fun removePlaceFromDatabase(place: `[`Place`](../../com.timgeldof.gustfinder.database/-place/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
