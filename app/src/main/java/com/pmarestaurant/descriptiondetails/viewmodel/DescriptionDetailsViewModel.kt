package com.pmarestaurant.descriptiondetails.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pmarestaurant.data.restaurantDataSource
import com.pmarestaurant.functional.Either
import com.pmarestaurant.descriptiondetails.view.DescriptionDetailsViewState
import kotlinx.coroutines.launch

class DescriptionDetailsViewModel (private val dataSource: restaurantDataSource): ViewModel() {
    private val _state = MutableLiveData<DescriptionDetailsViewState>()
    val state: LiveData<DescriptionDetailsViewState>
        get() = _state

    fun getrestaurant(id: Int){
        viewModelScope.launch {
            _state.postValue(DescriptionDetailsViewState.Processing)

            _state.postValue(
                when(val result = dataSource.getRestaurant()){
                    is Either.Success -> DescriptionDetailsViewState.DataReceived(result.data[id])
                    is Either.Error -> DescriptionDetailsViewState.ErrorReceived(result.exception.toString())
                    else -> DescriptionDetailsViewState.Processing
                }
            )
        }
    }
}