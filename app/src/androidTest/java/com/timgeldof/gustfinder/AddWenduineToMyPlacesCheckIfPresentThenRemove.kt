package com.timgeldof.gustfinder

import android.os.Looper
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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
import kotlinx.coroutines.*
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
class AddWenduineToMyPlacesCheckIfPresentThenRemove {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)
    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    private val database = GustDatabase.getInstance(GustApplication.applicationContext()).placeDatabaseDao

    @Test
    fun addWenduineToMyPlacesCheckIfPresentThenRemove() {
        if(networkAvailable(GustApplication.applicationContext())){
        uiScope.launch {
            clearDatabase()
        }
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
            )
        )
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
        textInputEditText.perform(replaceText("wenduine"), closeSoftKeyboard())
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

        val textView = onView(
            allOf(
                withId(R.id.txt_city_name), withText("Wenduine"),
                childAtPosition(
                    allOf(
                        withId(R.id.place_content),
                        childAtPosition(
                            IsInstanceOf.instanceOf(android.widget.LinearLayout::class.java),
                            0
                        )
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textView.check(matches(withText("Wenduine")))

        val textView2 = onView(
            allOf(
                withId(R.id.txt_country), withText("Belgium"),
                childAtPosition(
                    allOf(
                        withId(R.id.place_content),
                        childAtPosition(
                            IsInstanceOf.instanceOf(android.widget.LinearLayout::class.java),
                            0
                        )
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        textView2.check(matches(withText("Belgium")))

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
