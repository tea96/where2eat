package com.pmarestaurant.descriptiondetails.view

import com.pmarestaurant.model.Restaurant

open class DescriptionDetailsViewState {
    object Processing: DescriptionDetailsViewState()
    data class DataReceived(val restaurant: Restaurant) : DescriptionDetailsViewState()
    data class ErrorReceived(val message: String): DescriptionDetailsViewState()
}