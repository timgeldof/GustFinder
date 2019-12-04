[app](../../index.md) / [com.timgeldof.gustfinder.screens.userMap](../index.md) / [UserMapViewModel](./index.md)

# UserMapViewModel

`class UserMapViewModel : ViewModel`

A [ViewModel](#) subclass

### Parameters

`database` - a [PlaceDatabaseDao](../../com.timgeldof.gustfinder.database/-place-database-dao/index.md) instance that is used to set the user places (myPlaces [LiveData](#))

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | A [ViewModel](#) subclass`UserMapViewModel(database: `[`PlaceDatabaseDao`](../../com.timgeldof.gustfinder.database/-place-database-dao/index.md)`)` |

### Properties

| Name | Summary |
|---|---|
| [database](database.md) | a [PlaceDatabaseDao](../../com.timgeldof.gustfinder.database/-place-database-dao/index.md) instance that is used to set the user places (myPlaces [LiveData](#))`val database: `[`PlaceDatabaseDao`](../../com.timgeldof.gustfinder.database/-place-database-dao/index.md) |
| [myPlaces](my-places.md) | `val myPlaces: LiveData<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Place`](../../com.timgeldof.gustfinder.database/-place/index.md)`>>` |
