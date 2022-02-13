package com.pmarestaurant.restaurantlist.view

import com.pmarestaurant.model.Restaurant

sealed class RestaurantListViewState{
    object Processing: RestaurantListViewState()
    data class DataReceived(val restaurants: List<Restaurant>): RestaurantListViewState()
    data class ErrorReceived(val message: String): RestaurantListViewState()
}
