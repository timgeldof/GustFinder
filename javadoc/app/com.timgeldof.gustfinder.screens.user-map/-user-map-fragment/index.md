[app](../../index.md) / [com.timgeldof.gustfinder.screens.userMap](../index.md) / [UserMapFragment](./index.md)

# UserMapFragment

`class UserMapFragment : Fragment, OnMapReadyCallback`

A simple [Fragment](#) subclass.
The [MapView](#) documentation tells us that we need to call the lifecycle methods of the mapview toghether with that of the parent fragment/activity

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | A simple [Fragment](#) subclass. The [MapView](#) documentation tells us that we need to call the lifecycle methods of the mapview toghether with that of the parent fragment/activity`UserMapFragment()` |

### Properties

| Name | Summary |
|---|---|
| [binding](binding.md) | `lateinit var binding: <ERROR CLASS>` |
| [mapView](map-view.md) | `lateinit var mapView: MapView` |
| [myGoogleMap](my-google-map.md) | `lateinit var myGoogleMap: GoogleMap` |
| [viewModel](view-model.md) | `lateinit var viewModel: `[`UserMapViewModel`](../-user-map-view-model/index.md) |

### Functions

| Name | Summary |
|---|---|
| [onCreateView](on-create-view.md) | `fun onCreateView(inflater: `[`LayoutInflater`](https://developer.android.com/reference/android/view/LayoutInflater.html)`, container: `[`ViewGroup`](https://developer.android.com/reference/android/view/ViewGroup.html)`?, savedInstanceState: `[`Bundle`](https://developer.android.com/reference/android/os/Bundle.html)`?): `[`View`](https://developer.android.com/reference/android/view/View.html)`?` |
| [onDestroy](on-destroy.md) | `fun onDestroy(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onLowMemory](on-low-memory.md) | `fun onLowMemory(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onMapReady](on-map-ready.md) | When the map is ready, the markers are places onto the map using the [placeMarker](place-marker.md) method`fun onMapReady(googleMap: GoogleMap?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onPause](on-pause.md) | `fun onPause(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onResume](on-resume.md) | `fun onResume(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onStart](on-start.md) | `fun onStart(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onStop](on-stop.md) | `fun onStop(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onViewCreated](on-view-created.md) | Calls the superclass onViewCreatedMethod and sets the [MapView](#) property to that of the binding object`fun onViewCreated(view: `[`View`](https://developer.android.com/reference/android/view/View.html)`, savedInstanceState: `[`Bundle`](https://developer.android.com/reference/android/os/Bundle.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [placeMarker](place-marker.md) | Creates a marker with the coordinates from the [Place](../../com.timgeldof.gustfinder.database/-place/index.md) parameter. It adds the name of the area as well as the region to the info box`fun placeMarker(place: `[`Place`](../../com.timgeldof.gustfinder.database/-place/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
