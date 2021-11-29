package com.mcm.jpmassignment.viewmodel

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mcm.jpmassignment.model.Albums
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AblumViewModelTest {

    private lateinit var viewModel: AblumViewModel

    @Before
    fun setUp() {
        viewModel = AblumViewModel()
    }

    @Test
    fun getData() {
        val list = viewModel.getTitles().value
        list?.onFailure {
            return@onFailure
        }
        list?.onSuccess {
            return@onSuccess
        }
    }
}
