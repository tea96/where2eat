package com.pmarestaurant.data

import com.pmarestaurant.data.RetrofitBuilder.retrofit

object ApiServiceProvider {

    val restaurantApiService = retrofit.create(RestaurantApiService::class.java)
}