[app](../../index.md) / [com.timgeldof.gustfinder](../index.md) / [GustApplication](index.md) / [attachBaseContext](./attach-base-context.md)

# attachBaseContext

`protected fun attachBaseContext(base: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Overrides the attachBaseContext from the [Application](https://developer.android.com/reference/android/app/Application.html) class and installs MultiDex into the [Context](https://developer.android.com/reference/android/content/Context.html) in order to support over 64K methods

### Parameters

`base` - parameter of class [Context](https://developer.android.com/reference/android/content/Context.html) which contains information about the application environment