package com.dwa.mycar.feature.add

import com.dwa.mycar.feature.add.brands.state.BrandAction
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@HiltAndroidTest
class TestCreateProfile {

    @Inject
    lateinit var viewModel: CreateProfileViewModel

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Before
    fun init() {
        hiltRule.inject()
    }



    @Test
    fun testLoadData() {
        viewModel.onBrandUiAction(BrandAction.LoadBrands)

    }


}