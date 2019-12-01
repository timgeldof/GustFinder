[app](../../index.md) / [com.timgeldof.gustfinder.screens.place_detail](../index.md) / [PlaceDetailViewModel](./index.md)

# PlaceDetailViewModel

`class PlaceDetailViewModel : ViewModel`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `PlaceDetailViewModel(place: `[`Place`](../../com.timgeldof.gustfinder.database/-place/index.md)`)` |

### Properties

| Name | Summary |
|---|---|
| [place](place.md) | `val place: `[`Place`](../../com.timgeldof.gustfinder.database/-place/index.md) |
| [weather](weather.md) | `val weather: LiveData<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Weather`](../../com.timgeldof.gustfinder.network.models.marine_weather_api/-weather/index.md)`>>` |

### Functions

| Name | Summary |
|---|---|
| [getForecasts](get-forecasts.md) | `fun getForecasts(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
