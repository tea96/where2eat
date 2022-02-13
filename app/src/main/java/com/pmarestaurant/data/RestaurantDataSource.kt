package com.pmarestaurant.data

import com.pmarestaurant.functional.Either
import com.pmarestaurant.model.Restaurant
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import java.lang.Exception

interface IrestaurantDataSource{
    suspend fun getRestaurant(): Either<List<Restaurant>>
}

class restaurantDataSource(private val apiService: RestaurantApiService):
    IrestaurantDataSource {

    override suspend fun getRestaurant() = handleCall(apiService.getRestaurant())

    private suspend fun <T> handleCall(call: Call<T>): Either<T> {
        return withContext(Dispatchers.IO){
            val response = call.execute()
            if(response.isSuccessful){
                Either.Success(response.body()!!)
            }else{
                Either.Error(Exception(response.message()))
            }
        }
    }
}