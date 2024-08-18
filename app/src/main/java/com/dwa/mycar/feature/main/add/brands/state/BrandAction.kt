package com.dwa.mycar.feature.main.add.brands.state

sealed class BrandAction {
    object LoadBrands : BrandAction()
    data class SelectBrand(val brand: String) : BrandAction()
}