[app](../../index.md) / [com.timgeldof.gustfinder.screens.userPlaces](../index.md) / [UserPlacesAdapter](./index.md)

# UserPlacesAdapter

`class UserPlacesAdapter : ListAdapter<`[`Place`](../../com.timgeldof.gustfinder.database/-place/index.md)`, PlaceViewHolder>`

A [ListAdapter](#) subclass

### Parameters

`onClickDetailListener` - An OnClickListener parameter that is used to show the detail of the place

`onClickDeleteListener` - An OnClickListener parameter that is used to set the delete action on the delete button

### Types

| Name | Summary |
|---|---|
| [OnClickListener](-on-click-listener/index.md) | `class OnClickListener` |
| [PlacesCallBack](-places-call-back/index.md) | Callback class used to calculate the difference between two [Place](../../com.timgeldof.gustfinder.database/-place/index.md) lists for optimizing the [RecyclerView](#) updating efficiency.`class PlacesCallBack : ItemCallback<`[`Place`](../../com.timgeldof.gustfinder.database/-place/index.md)`>` |
| [PlaceViewHolder](-place-view-holder/index.md) | `class PlaceViewHolder : ViewHolder` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | A [ListAdapter](#) subclass`UserPlacesAdapter(onClickDetailListener: OnClickListener, onClickDeleteListener: OnClickListener)` |

### Functions

| Name | Summary |
|---|---|
| [onBindViewHolder](on-bind-view-holder.md) | `fun onBindViewHolder(holder: PlaceViewHolder, position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onCreateViewHolder](on-create-view-holder.md) | `fun onCreateViewHolder(parent: `[`ViewGroup`](https://developer.android.com/reference/android/view/ViewGroup.html)`, viewType: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): PlaceViewHolder` |
