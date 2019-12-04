[app](../../index.md) / [com.timgeldof.gustfinder.screens.placeDetail](../index.md) / [PlaceDetailAdapter](./index.md)

# PlaceDetailAdapter

`class PlaceDetailAdapter : ListAdapter<`[`Weather`](../../com.timgeldof.gustfinder.network.models.marine-weather-api/-weather/index.md)`, PlaceDetailViewHolder>`

### Types

| Name | Summary |
|---|---|
| [PlaceDetailViewHolder](-place-detail-view-holder/index.md) | `class PlaceDetailViewHolder : ViewHolder` |
| [WeatherDiffCallback](-weather-diff-callback/index.md) | Callback class used to calculate the difference between two [Weather](../../com.timgeldof.gustfinder.network.models.marine-weather-api/-weather/index.md) lists for optimizing the recyclerview efficiency.`class WeatherDiffCallback : ItemCallback<`[`Weather`](../../com.timgeldof.gustfinder.network.models.marine-weather-api/-weather/index.md)`>` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `PlaceDetailAdapter()` |

### Functions

| Name | Summary |
|---|---|
| [onBindViewHolder](on-bind-view-holder.md) | `fun onBindViewHolder(holder: PlaceDetailViewHolder, position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onCreateViewHolder](on-create-view-holder.md) | `fun onCreateViewHolder(parent: `[`ViewGroup`](https://developer.android.com/reference/android/view/ViewGroup.html)`, viewType: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): PlaceDetailViewHolder` |
