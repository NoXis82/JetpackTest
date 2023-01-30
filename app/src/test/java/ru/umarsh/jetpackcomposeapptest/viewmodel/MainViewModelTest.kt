package ru.umarsh.jetpackcomposeapptest.viewmodel

import app.cash.turbine.test
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class MainViewModelTest {
    private lateinit var testViewModel: MainViewModel
    private lateinit var testDispatcher: TestDispatchers

    @Before
    fun setUp() {
        testDispatcher = TestDispatchers()
        testViewModel = MainViewModel(testDispatcher)
    }

    @Test
    fun `countDownFlow, properly from 5 to 0`() = runBlocking {
        testViewModel.countDownFlow.test {
            for (i in 10 downTo 0) {
                testDispatcher.testDispatcher.advanceTimeBy(1000L)
                val emission = awaitItem()
                assertThat(emission).isEqualTo(i)
            }
            cancelAndConsumeRemainingEvents()
        }
    }

    @Test
    fun `squareNumber, number squared`() = runBlocking {
        val job = launch {
            testViewModel.countSharedFlow.test {
                val emission = awaitItem()
                assertThat(emission).isEqualTo(9)
                cancelAndConsumeRemainingEvents()
            }
        }
        testViewModel.squareNumber(3)
        job.join()
        job.cancel()
    }
}