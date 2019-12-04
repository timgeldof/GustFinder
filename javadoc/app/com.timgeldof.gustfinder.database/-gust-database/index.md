[app](../../index.md) / [com.timgeldof.gustfinder.database](../index.md) / [GustDatabase](./index.md)

# GustDatabase

`abstract class GustDatabase : RoomDatabase`

GustDatabase extends the [RoomDatabase](#) class for usage within the Gustfinder app

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | GustDatabase extends the [RoomDatabase](#) class for usage within the Gustfinder app`GustDatabase()` |

### Properties

| Name | Summary |
|---|---|
| [placeDatabaseDao](place-database-dao.md) | This property of class [PlaceDatabaseDao](../-place-database-dao/index.md) is publicly available to all classes to support api calls`abstract val placeDatabaseDao: `[`PlaceDatabaseDao`](../-place-database-dao/index.md) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [getInstance](get-instance.md) | Returns an instance of GustDatabase using the singleton pattern`fun getInstance(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`): `[`GustDatabase`](./index.md) |
