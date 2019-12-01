[app](../../index.md) / [com.timgeldof.gustfinder.network.models.marine_weather_api](../index.md) / [Weather](./index.md)

# Weather

`data class Weather`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Weather(date: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, astronomy: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Astronomy`](../-astronomy/index.md)`>?, maxtempC: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, maxtempF: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, mintempC: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, mintempF: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, hourly: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Hourly`](../-hourly/index.md)`>)` |

### Properties

| Name | Summary |
|---|---|
| [astronomy](astronomy.md) | `val astronomy: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Astronomy`](../-astronomy/index.md)`>?` |
| [date](date.md) | `val date: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [hourly](hourly.md) | `val hourly: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Hourly`](../-hourly/index.md)`>` |
| [maxtempC](maxtemp-c.md) | `val maxtempC: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [maxtempF](maxtemp-f.md) | `val maxtempF: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [mintempC](mintemp-c.md) | `val mintempC: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [mintempF](mintemp-f.md) | `val mintempF: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |

### Functions

| Name | Summary |
|---|---|
| [getMaxTempFormatted](get-max-temp-formatted.md) | `fun getMaxTempFormatted(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [getMinTempFormatted](get-min-temp-formatted.md) | `fun getMinTempFormatted(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
