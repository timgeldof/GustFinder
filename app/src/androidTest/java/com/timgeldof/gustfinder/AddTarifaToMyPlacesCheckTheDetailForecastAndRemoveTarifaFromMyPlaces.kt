package com.timgeldof.gustfinder

import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withClassName
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.timgeldof.gustfinder.database.GustDatabase
import com.timgeldof.gustfinder.network.networkAvailable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.core.IsInstanceOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class AddTarifaToMyPlacesCheckTheDetailForecastAndRemoveTarifaFromMyPlaces {

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    private val database = GustDatabase.getInstance(GustApplication.applicationContext()).placeDatabaseDao

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun addTarifaToMyPlacesCheckTheDetailForecastAndRemoveTarifaFromMyPlaces() {
        // clear database if any places are present
        uiScope.launch {
            clearDatabase()
        }
        if (networkAvailable(GustApplication.applicationContext())) {
            val appCompatTextView = onView(
            allOf(
                withId(R.id.text_my_places), withText("My places"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.cardView),
                        0
                    ),
                    0
                ),
                isDisplayed()
            ))
        appCompatTextView.perform(click())

        val floatingActionButton = onView(
            allOf(
                withId(R.id.add_place_button),
                childAtPosition(
                    allOf(
                        withId(R.id.main_content),
                        childAtPosition(
                            withId(R.id.myNavHostFragment),
                            0
                        )
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        floatingActionButton.perform(click())

        val textInputEditText = onView(
            allOf(
                withId(R.id.add_place_text_field),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("com.google.android.material.textfield.TextInputLayout")),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText.perform(replaceText("tarifa"), closeSoftKeyboard())
        Thread.sleep(5000)
        val appCompatButton = onView(
            allOf(
                withId(R.id.button),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("androidx.cardview.widget.CardView")),
                        0
                    ),
                    3
                ),
                isDisplayed()
            )
        )
        appCompatButton.perform(click())

        val linearLayout = onView(
            allOf(
                withId(R.id.place_content),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("androidx.cardview.widget.CardView")),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        linearLayout.perform(click())
        Thread.sleep(5000)
        val imageView = onView(
            allOf(
                withId(R.id.img_morning_forecast),
                childAtPosition(
                    childAtPosition(
                        IsInstanceOf.instanceOf(android.widget.LinearLayout::class.java),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        imageView.check(matches(isDisplayed()))
        Espresso.pressBack()
        Thread.sleep(5000)
        val appCompatImageView = onView(
            allOf(
                withId(R.id.delete_button),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("androidx.cardview.widget.CardView")),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatImageView.perform(click())
        } else {
            Log.i("TEST", "Test only suitable when the device is online")
        }
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>,
        position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent) &&
                        view == parent.getChildAt(position)
            }
        }
    }
    suspend fun clearDatabase() {
        withContext(Dispatchers.IO) {
            database.clear()
        }
    }
}
