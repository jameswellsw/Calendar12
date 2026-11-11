package com.kizitonwose.calendar.sample

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.kizitonwose.calendar.sample.compose.Example3Page
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class CalendarComposeTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun example3PageDisplaysWithoutErrors() {
        composeTestRule.setContent {
            Example3Page()
        }
    }
}
