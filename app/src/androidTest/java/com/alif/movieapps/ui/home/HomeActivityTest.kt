package com.alif.movieapps.ui.home

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.contrib.ViewPagerActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.platform.app.InstrumentationRegistry
import com.alif.movieapps.R
import com.alif.movieapps.data.entity.DataEntity
import com.alif.movieapps.utils.EspressoIdlingResource
import org.hamcrest.Matcher
import org.junit.After
import org.junit.Before

import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class HomeActivityTest {
    private lateinit var instrumentalContext: Context
    private lateinit var movieFav: DataEntity
    private lateinit var showFav: DataEntity

    @get:Rule
    var activityRule = ActivityScenarioRule(HomeActivity::class.java)

    @Before
    fun setUp() {
        instrumentalContext = InstrumentationRegistry.getInstrumentation().targetContext
        ActivityScenario.launch(HomeActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.espressoTestIdlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.espressoTestIdlingResource)
    }



    @Test
    fun loadMovie() {
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(10))
    }


    @Test
    fun loadDetailMovie() {
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        onView(withId(R.id.detail_title)).check(matches(isDisplayed()))

        onView(withId(R.id.detail_overview)).check(matches(isDisplayed()))

        onView(withId(R.id.detail_poster)).check(matches(isDisplayed()))

        onView(withId(R.id.detail_poster_bg)).check(matches(isDisplayed()))
    }

    @Test
    fun loadShow() {
        onView(withId(R.id.nav_show)).perform(click())
        onView(withId(R.id.rv_show)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_show)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(10))
    }

    @Test
    fun loadDetailShow() {
        onView(withId(R.id.nav_show)).perform(click())
        onView(withId(R.id.rv_show)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        onView(withId(R.id.detail_title)).check(matches(isDisplayed()))

        onView(withId(R.id.detail_overview)).check(matches(isDisplayed()))

        onView(withId(R.id.detail_poster)).check(matches(isDisplayed()))

        onView(withId(R.id.detail_poster_bg)).check(matches(isDisplayed()))
    }


    @Test
    fun loadFavorite() {
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>
            (0, ClickOnButtonView()))

        onView(withId(R.id.nav_show)).perform(click())
        onView(withId(R.id.rv_show)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>
            (0, ClickOnButtonView()))


        onView(withId(R.id.nav_favorite)).perform(click())
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        onView(withId(R.id.detail_title)).check(matches(isDisplayed()))

        onView(withId(R.id.detail_overview)).check(matches(isDisplayed()))

        onView(withId(R.id.detail_poster)).check(matches(isDisplayed()))

        onView(withId(R.id.detail_poster_bg)).check(matches(isDisplayed()))

        onView(isRoot()).perform(ViewActions.pressBack())

        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>
            (0, ClickOnButtonView()))

        onView(withId(R.id.fragment_state_movie)).check(matches(withText(R.string.no_data)))
        onView(withId(R.id.view_pager)).perform(ViewPagerActions.scrollRight())

        onView(withId(R.id.rv_show)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        onView(withId(R.id.detail_title)).check(matches(isDisplayed()))

        onView(withId(R.id.detail_overview)).check(matches(isDisplayed()))

        onView(withId(R.id.detail_poster)).check(matches(isDisplayed()))

        onView(withId(R.id.detail_poster_bg)).check(matches(isDisplayed()))

        onView(isRoot()).perform(ViewActions.pressBack())

        onView(withId(R.id.rv_show)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>
            (0, ClickOnButtonView()))

        onView(withId(R.id.fragment_state_show)).check(matches(withText(R.string.no_data)))

    }


    inner class ClickOnButtonView : ViewAction {

        internal var click = click()

        override fun getConstraints(): Matcher<View> {
            return click.constraints
        }

        override fun getDescription(): String {
            return "Click on recyclerview button"
        }

        override fun perform(uiController: UiController?, view: View?) {
            click.perform(uiController, view?.findViewById(R.id.item_button_favorite))
        }

    }

}