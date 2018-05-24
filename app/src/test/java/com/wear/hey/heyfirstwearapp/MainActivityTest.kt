package com.wear.hey.heyfirstwearapp

import android.widget.TextView
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

internal class MainActivityTest {
    @Test
    fun should_initialize_counter_value_to_zero() {
        // given
        val mainActivity = MainActivity()

        // when
        val counter: TextView = mainActivity.findViewById(R.id.counter)

        // then
        assertThat(counter.text).isEqualTo("0")
    }
}