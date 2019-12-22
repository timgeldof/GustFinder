package com.timgeldof.gustfinder

import android.util.Log
import android.view.View
import android.view.ViewGroup
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
import org.hamcrest.BaseMatcher

@LargeTest
@RunWith(AndroidJUnit4::class)
class AddThreePlacesToMyPlacesCheckWhetherTheyArePresentAndRemoveThemAll {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)
    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    private val database = GustDatabase.getInstance(GustApplication.applicationContext()).placeDatabaseDao
    @Test
    fun addThreePlacesToMyPlacesAndRemoveThemAll() {
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
            textInputEditText.perform(replaceText("Aveiro"), closeSoftKeyboard())
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

            val floatingActionButton2 = onView(
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
            floatingActionButton2.perform(click())

            val textInputEditText2 = onView(
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
            textInputEditText2.perform(click())

            val textInputEditText3 = onView(
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
            textInputEditText3.perform(replaceText("Oostende"), closeSoftKeyboard())
            Thread.sleep(5000)
            val appCompatButton2 = onView(
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
            appCompatButton2.perform(click())

            val floatingActionButton3 = onView(
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
            floatingActionButton3.perform(click())

            val textInputEditText4 = onView(
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
            textInputEditText4.perform(click())

            val textInputEditText5 = onView(
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
            textInputEditText5.perform(click())

            val textInputEditText6 = onView(
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
            textInputEditText6.perform(replaceText("loppem"), closeSoftKeyboard())
            Thread.sleep(5000)
            val textInputEditText7 = onView(
                allOf(
                    withId(R.id.add_place_text_field), withText("loppem"),
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
            textInputEditText7.perform(click())

            val textInputEditText8 = onView(
                allOf(
                    withId(R.id.add_place_text_field), withText("loppem"),
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
            textInputEditText8.perform(replaceText("zarau"))
            Thread.sleep(5000)
            val textInputEditText9 = onView(
                allOf(
                    withId(R.id.add_place_text_field), withText("zarau"),
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
            textInputEditText9.perform(closeSoftKeyboard())

            val appCompatButton3 = onView(
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
            appCompatButton3.perform(click())

            val textView = onView(
                allOf(
                    withId(R.id.txt_city_name), withText("Zarautz"),
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
            textView.check(matches(withText("Zarautz")))

            val textView2 = onView(
                allOf(
                    withId(R.id.txt_city_name), withText("Zarautz"),
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
            textView2.check(matches(withText("Zarautz")))

            val textView3 = onView(
                allOf(
                    withId(R.id.txt_city_name), withText("Oostende"),
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
            textView3.check(matches(withText("Oostende")))

            val textView4 = onView(
                allOf(
                    withId(R.id.txt_city_name), withText("Aveiro"),
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
            textView4.check(matches(withText("Aveiro")))

            val textView5 = onView(
                allOf(
                    withId(R.id.txt_city_name), withText("Aveiro"),
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
            textView5.check(matches(withText("Aveiro")))

            val appCompatImageView = onView(
                allOf(
                    getElementFromMatchAtPosition(allOf(withId(R.id.delete_button)), 0),
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

            val appCompatImageView2 = onView(
                allOf(
                    getElementFromMatchAtPosition(allOf(withId(R.id.delete_button)), 0),
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
            appCompatImageView2.perform(click())

            val appCompatImageView3 = onView(
                allOf(
                    getElementFromMatchAtPosition(allOf(withId(R.id.delete_button)), 0),
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
            appCompatImageView3.perform(click())
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
    private fun getElementFromMatchAtPosition(
        matcher: Matcher<View>,
        position: Int
    ): Matcher<View> {
        return object : BaseMatcher<View>() {
            internal var counter = 0
            override fun matches(item: Any): Boolean {
                if (matcher.matches(item)) {
                    if (counter == position) {
                        counter++
                        return true
                    }
                    counter++
                }
                return false
            }

            override fun describeTo(description: Description) {
                description.appendText("Element at hierarchy position $position")
            }
        }
    }
    suspend fun clearDatabase() {
        withContext(Dispatchers.IO) {
            database.clear()
        }
    }
}
