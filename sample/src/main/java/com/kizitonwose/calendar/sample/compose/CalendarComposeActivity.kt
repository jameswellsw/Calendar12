package com.kizitonwose.calendar.sample.compose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.CompositionLocalProvider

class CalendarComposeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme(colorScheme = SampleColorScheme) {
                Scaffold { padding ->
                    CompositionLocalProvider(LocalScaffoldPaddingValues provides padding) {
                        Example3Page()
                    }
                }
            }
        }
    }
}
