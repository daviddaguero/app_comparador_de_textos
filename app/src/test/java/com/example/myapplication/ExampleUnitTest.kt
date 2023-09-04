package com.example.myapplication

import org.junit.Test

import org.junit.Assert.*

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import org.junit.Before
import org.junit.Rule
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class MyCustomViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule() // Para cambiar el executor principal

    @Mock
    private lateinit var observer: Observer<String>

    private lateinit var viewModel: MyCustomViewModel

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this) // Inicializa las anotaciones Mockito
        viewModel = MyCustomViewModel()
        viewModel.comparisonResult.observeForever(observer)
    }

    @Test
    fun testCompareStrings_WhenStringsAreEqual() {
        // Arrange
        val text1 = "Hello"
        val text2 = "Hello"

        // Act
        viewModel.compareStrings(text1, text2)

        // Assert
        Mockito.verify(observer).onChanged("Los textos son iguales")
    }

    @Test
    fun testCompareStrings_WhenStringsAreDifferent() {
        // Arrange
        val text1 = "Hello"
        val text2 = "World"

        // Act
        viewModel.compareStrings(text1, text2)

        // Assert
        Mockito.verify(observer).onChanged("Los textos son diferentes")
    }
}
