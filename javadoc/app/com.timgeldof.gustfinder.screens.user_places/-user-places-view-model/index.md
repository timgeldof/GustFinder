[app](../../index.md) / [com.timgeldof.gustfinder.screens.user_places](../index.md) / [UserPlacesViewModel](./index.md)

# UserPlacesViewModel

`class UserPlacesViewModel : AndroidViewModel`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `UserPlacesViewModel(database: `[`PlaceDatabaseDao`](../../com.timgeldof.gustfinder.database/-place-database-dao/index.md)`, application: `[`Application`](https://developer.android.com/reference/android/app/Application.html)`)` |

### Properties

| Name | Summary |
|---|---|
| [database](database.md) | `val database: `[`PlaceDatabaseDao`](../../com.timgeldof.gustfinder.database/-place-database-dao/index.md) |
| [myPlaces](my-places.md) | `val myPlaces: LiveData<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Place`](../../com.timgeldof.gustfinder.database/-place/index.md)`>>` |
| [navigateToSelectedPlace](navigate-to-selected-place.md) | `val navigateToSelectedPlace: LiveData<`[`Place`](../../com.timgeldof.gustfinder.database/-place/index.md)`>` |
| [placesString](places-string.md) | `val placesString: LiveData<`[`Spanned`](https://developer.android.com/reference/android/text/Spanned.html)`!>!` |

### Functions

| Name | Summary |
|---|---|
| [displayPlaceDetails](display-place-details.md) | `fun displayPlaceDetails(place: `[`Place`](../../com.timgeldof.gustfinder.database/-place/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [displayPlaceDetailsComplete](display-place-details-complete.md) | `fun displayPlaceDetailsComplete(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [formatPlaces](format-places.md) | `fun formatPlaces(places: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Place`](../../com.timgeldof.gustfinder.database/-place/index.md)`>, resources: `[`Resources`](https://developer.android.com/reference/android/content/res/Resources.html)`): `[`Spanned`](https://developer.android.com/reference/android/text/Spanned.html) |
| [getPlacesFromDB](get-places-from-d-b.md) | `fun getPlacesFromDB(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onCleared](on-cleared.md) | `fun onCleared(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [removeAllPlacesFromDatabase](remove-all-places-from-database.md) | `fun removeAllPlacesFromDatabase(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
