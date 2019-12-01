[app](../../index.md) / [com.timgeldof.gustfinder.screens.user_places](../index.md) / [UserPlacesAdapter](./index.md)

# UserPlacesAdapter

`class UserPlacesAdapter : Adapter<PlaceViewHolder>`

### Types

| Name | Summary |
|---|---|
| [OnClickListener](-on-click-listener/index.md) | `class OnClickListener` |
| [PlaceViewHolder](-place-view-holder/index.md) | `class PlaceViewHolder : ViewHolder` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `UserPlacesAdapter(onClickListener: OnClickListener)` |

### Properties

| Name | Summary |
|---|---|
| [data](data.md) | `var data: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Place`](../../com.timgeldof.gustfinder.database/-place/index.md)`>` |

### Functions

| Name | Summary |
|---|---|
| [getItemCount](get-item-count.md) | `fun getItemCount(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [onBindViewHolder](on-bind-view-holder.md) | `fun onBindViewHolder(holder: PlaceViewHolder, position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onCreateViewHolder](on-create-view-holder.md) | `fun onCreateViewHolder(parent: `[`ViewGroup`](https://developer.android.com/reference/android/view/ViewGroup.html)`, viewType: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): PlaceViewHolder` |
