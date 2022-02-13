package com.pmarestaurant.data

import com.pmarestaurant.model.Restaurant
import retrofit2.Call
import retrofit2.http.GET

interface RestaurantApiService {

    @GET("c81267e1fd4d2b541874")
    fun getRestaurant(): Call<List<Restaurant>>
}