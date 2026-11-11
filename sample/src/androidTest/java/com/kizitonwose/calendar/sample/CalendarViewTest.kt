package com.kizitonwose.calendar.sample

import android.view.View
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.kizitonwose.calendar.core.CalendarDay
import com.kizitonwose.calendar.sample.utils.TestDayViewContainer
import com.kizitonwose.calendar.sample.utils.getView
import com.kizitonwose.calendar.sample.utils.runOnMain
import com.kizitonwose.calendar.sample.view.CalendarViewActivity
import com.kizitonwose.calendar.view.CalendarView
import com.kizitonwose.calendar.view.MonthDayBinder
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.lang.Thread.sleep
import java.time.YearMonth

@RunWith(AndroidJUnit4::class)
@LargeTest
class CalendarViewTest {
    @get:Rule
    val homeScreenRule = ActivityScenarioRule(CalendarViewActivity::class.java)

    private val currentMonth = YearMonth.now()

    @Test
    fun dayBinderIsCalledOnDayChanged() {
        val calendarView = homeScreenRule.getView<CalendarView>(R.id.exThreeCalendar)

        var boundDay: CalendarDay? = null
        val changedDate = currentMonth.atDay(4)

        runOnMain {
            calendarView.dayBinder = object : MonthDayBinder<TestDayViewContainer> {
                override fun create(view: View) = TestDayViewContainer(view)
                override fun bind(container: TestDayViewContainer, data: CalendarDay) {
                    boundDay = data
                }
            }
        }

        sleep(2000)

        runOnMain {
            calendarView.notifyDateChanged(changedDate)
        }

        sleep(2000)

        assertEquals(changedDate, boundDay?.date)
    }
}
