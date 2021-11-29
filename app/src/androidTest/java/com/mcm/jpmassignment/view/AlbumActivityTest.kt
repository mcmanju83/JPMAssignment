package com.mcm.jpmassignment.view

import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.mcm.jpmassignment.R
import org.junit.Rule
import org.junit.Test


class AlbumActivityTest{

    @get: Rule
    val  activityRule = ActivityScenarioRule(AlbumActivity::class.java)

    /*Showing the Recycler view*/
    @Test
    fun recyclerViewTest(){
        onView(withId(R.id.rvItems)).check(matches(isDisplayed()))
    }

}