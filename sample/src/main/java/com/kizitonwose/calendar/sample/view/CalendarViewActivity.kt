package com.kizitonwose.calendar.sample.view

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat.Type.systemBars
import androidx.core.view.updatePadding
import com.kizitonwose.calendar.sample.R
import com.kizitonwose.calendar.sample.databinding.CalendarViewActivityBinding

class CalendarViewActivity : AppCompatActivity() {
    internal lateinit var binding: CalendarViewActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CalendarViewActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.activityToolbar)
        applyInsets(binding)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.homeContainer, Example3Fragment())
                .commit()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> onBackPressedDispatcher.onBackPressed().let { true }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun applyInsets(binding: CalendarViewActivityBinding) {
        ViewCompat.setOnApplyWindowInsetsListener(
            binding.root,
        ) { _, windowInsets ->
            val insets = windowInsets.getInsets(systemBars())
            binding.activityAppBar.updatePadding(top = insets.top)
            binding.homeContainer.updatePadding(
                left = insets.left,
                right = insets.right,
                bottom = insets.bottom,
            )
            windowInsets
        }
    }
}
