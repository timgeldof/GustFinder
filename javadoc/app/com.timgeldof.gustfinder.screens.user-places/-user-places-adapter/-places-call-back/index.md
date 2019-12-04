[app](../../../index.md) / [com.timgeldof.gustfinder.screens.userPlaces](../../index.md) / [UserPlacesAdapter](../index.md) / [PlacesCallBack](./index.md)

# PlacesCallBack

`class PlacesCallBack : ItemCallback<`[`Place`](../../../com.timgeldof.gustfinder.database/-place/index.md)`>`

Callback class used to calculate the difference between two [Place](../../../com.timgeldof.gustfinder.database/-place/index.md) lists for optimizing the [RecyclerView](#) updating efficiency.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | Callback class used to calculate the difference between two [Place](../../../com.timgeldof.gustfinder.database/-place/index.md) lists for optimizing the [RecyclerView](#) updating efficiency.`PlacesCallBack()` |

### Functions

| Name | Summary |
|---|---|
| [areContentsTheSame](are-contents-the-same.md) | `fun areContentsTheSame(oldItem: `[`Place`](../../../com.timgeldof.gustfinder.database/-place/index.md)`, newItem: `[`Place`](../../../com.timgeldof.gustfinder.database/-place/index.md)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [areItemsTheSame](are-items-the-same.md) | `fun areItemsTheSame(oldItem: `[`Place`](../../../com.timgeldof.gustfinder.database/-place/index.md)`, newItem: `[`Place`](../../../com.timgeldof.gustfinder.database/-place/index.md)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
