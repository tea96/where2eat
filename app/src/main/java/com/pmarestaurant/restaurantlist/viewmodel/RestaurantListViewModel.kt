package com.pmarestaurant.restaurantlist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pmarestaurant.data.IrestaurantDataSource
import com.pmarestaurant.functional.Either
import com.pmarestaurant.functional.ICoroutineContextProvider
import com.pmarestaurant.restaurantlist.view.RestaurantListViewState
import kotlinx.coroutines.launch

class RestaurantListViewModel (
    private val dataSource: IrestaurantDataSource,
    private val coroutineContextProvider: ICoroutineContextProvider
    ): ViewModel(){
        private val _state = MutableLiveData<RestaurantListViewState>()
        val state: LiveData<RestaurantListViewState>
            get() = _state

        fun getrestaurant(){
            viewModelScope.launch ( coroutineContextProvider.io ){
                _state.postValue(RestaurantListViewState.Processing)

                _state.postValue(
                    when(val result = dataSource.getRestaurant()){
                        is Either.Success -> RestaurantListViewState.DataReceived(result.data)
                        is Either.Error -> RestaurantListViewState.ErrorReceived(result.exception.toString())
                        else -> RestaurantListViewState.Processing
                    }
                )
            }
        }
}