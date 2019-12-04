[app](../../index.md) / [com.timgeldof.gustfinder.screens.addPlace](../index.md) / [AddPlaceAdapter](./index.md)

# AddPlaceAdapter

`class AddPlaceAdapter : ListAdapter<`[`Result`](../../com.timgeldof.gustfinder.network.models.search-api/-result/index.md)`, PlaceViewHolder>`

Adapts Place objects to be shown in the recyclerview of the Add Place screen

### Parameters

`onClickListener` - [OnClickListener](-on-click-listener/index.md) that is used to bind to a button which adds a place to the places_table in the database

**Return**
The result of executing the operation

### Types

| Name | Summary |
|---|---|
| [OnClickListener](-on-click-listener/index.md) | Contains an onClick method used to bind a clickListener to the [AddPlaceItemBinding](#) with the Place instance`class OnClickListener` |
| [PlaceViewHolder](-place-view-holder/index.md) | Contains the binding object of [AddPlaceItemBinding](#) class and is responsible for binding the result of the API`class PlaceViewHolder : ViewHolder` |
| [ResultCallBack](-result-call-back/index.md) | Used to see if the [Result](../../com.timgeldof.gustfinder.network.models.search-api/-result/index.md) differs from the previous data elements to optimize resource usage`class ResultCallBack : ItemCallback<`[`Result`](../../com.timgeldof.gustfinder.network.models.search-api/-result/index.md)`>` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | Adapts Place objects to be shown in the recyclerview of the Add Place screen`AddPlaceAdapter(onClickListener: OnClickListener)` |

### Functions

| Name | Summary |
|---|---|
| [onBindViewHolder](on-bind-view-holder.md) | Binds the [Place](../../com.timgeldof.gustfinder.database/-place/index.md) object to the viewholder`fun onBindViewHolder(holder: PlaceViewHolder, position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onCreateViewHolder](on-create-view-holder.md) | `fun onCreateViewHolder(parent: `[`ViewGroup`](https://developer.android.com/reference/android/view/ViewGroup.html)`, viewType: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): PlaceViewHolder` |
