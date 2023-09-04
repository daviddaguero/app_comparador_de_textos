package com.example.myapplication

import org.junit.Assert.*
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityUITest {

    private lateinit var scenario: ActivityScenario<MainActivity>

    @Before
    fun setUp() {
        // Inicializa la actividad utilizando ActivityScenario
        scenario = ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun testTextComparison() {
        // Ingresa texto en el primer EditText
        onView(withId(R.id.editText1)).perform(typeText("Texto1"), closeSoftKeyboard())

        // Ingresa texto en el segundo EditText
        onView(withId(R.id.editText2)).perform(typeText("Texto2"), closeSoftKeyboard())

        // Realiza una acción de clic en el botón con el ID 'myButton'
        onView(withId(R.id.compareButton)).perform(click())

        // Verifica que el resultado esperado esté en el TextView con el ID 'resultTextView'
        onView(withId(R.id.resultTextView)).check(matches(withText("Los textos son diferentes")))
    }
}
