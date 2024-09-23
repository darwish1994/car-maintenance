package com.dwa.mycar.feature.add.brands.state

sealed class BrandAction {
    object LoadBrands : BrandAction()
    data class SelectBrand(val brand: String) : BrandAction()
}