[app](../../index.md) / [com.timgeldof.gustfinder.screens.placeDetail](../index.md) / [PlaceDetailViewModel](./index.md)

# PlaceDetailViewModel

`class PlaceDetailViewModel : ViewModel`

A [ViewModel](#) subclass

### Parameters

`place` - the place of which the details need to be shown

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | A [ViewModel](#) subclass`PlaceDetailViewModel(place: `[`Place`](../../com.timgeldof.gustfinder.database/-place/index.md)`)` |

### Properties

| Name | Summary |
|---|---|
| [place](place.md) | the place of which the details need to be shown`val place: `[`Place`](../../com.timgeldof.gustfinder.database/-place/index.md) |
| [status](status.md) | `val status: LiveData<`[`ApiStatus`](../../com.timgeldof.gustfinder.screens.add-place/-api-status/index.md)`>` |
| [weather](weather.md) | `val weather: LiveData<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Weather`](../../com.timgeldof.gustfinder.network.models.marine-weather-api/-weather/index.md)`>>` |

### Functions

| Name | Summary |
|---|---|
| [shareWeatherIntent](share-weather-intent.md) | Creates a share intent to share the forecasts of the current day`fun shareWeatherIntent(): `[`Intent`](https://developer.android.com/reference/android/content/Intent.html) |
