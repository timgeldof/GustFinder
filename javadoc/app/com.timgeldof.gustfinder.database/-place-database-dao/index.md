[app](../../index.md) / [com.timgeldof.gustfinder.database](../index.md) / [PlaceDatabaseDao](./index.md)

# PlaceDatabaseDao

`interface PlaceDatabaseDao`

### Functions

| Name | Summary |
|---|---|
| [clear](clear.md) | `abstract fun clear(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [get](get.md) | `abstract fun get(key: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): LiveData<`[`Place`](../-place/index.md)`>` |
| [getAllPlaces](get-all-places.md) | `abstract fun getAllPlaces(): LiveData<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Place`](../-place/index.md)`>>` |
| [insert](insert.md) | `abstract fun insert(place: `[`Place`](../-place/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [removePlace](remove-place.md) | `abstract fun removePlace(key: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
