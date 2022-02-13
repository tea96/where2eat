package com.pmarestaurant.restaurantlist.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.pmarestaurant.ICoordinator
import com.pmarestaurant.R
import com.pmarestaurant.data.ApiServiceProvider
import com.pmarestaurant.data.restaurantDataSource
import com.pmarestaurant.functional.CoroutineContext
import com.pmarestaurant.functional.ViewModelFactoryUtil
import com.pmarestaurant.model.Restaurant
import com.pmarestaurant.restaurantlist.recycler.RestaurantRVAdapter
import  com.pmarestaurant.restaurantlist.viewmodel.RestaurantListViewModel
import kotlinx.android.synthetic.main.fragment_restaurant_list.*


class RestaurantListFragment: Fragment() {
    lateinit var viewModel: RestaurantListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, ViewModelFactoryUtil.viewModelFactory {
            RestaurantListViewModel(
                restaurantDataSource(ApiServiceProvider.restaurantApiService),
                CoroutineContext()
            )
        }).get(RestaurantListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_restaurant_list,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindFromViewModel()
        viewModel.getrestaurant()
    }

    private fun bindFromViewModel() {
        viewModel.state.observe(viewLifecycleOwner,
            Observer{state ->
                listProgressBar.visibility = if (state is RestaurantListViewState.Processing) View.VISIBLE else View.GONE
                when(state){
                    is RestaurantListViewState.DataReceived -> setUpRecyclerView(state.restaurants)
                    is RestaurantListViewState.ErrorReceived -> showError(state.message)
                    else -> RestaurantListViewState.Processing
                }
            })
    }

    private fun showError(message: String) {
        Toast.makeText(requireContext(),message, Toast.LENGTH_LONG).show()
    }

    private fun setUpRecyclerView(restaurants: List<Restaurant>) {
        restaurantListRV.layoutManager = LinearLayoutManager(requireContext())
        restaurantListRV.adapter = RestaurantRVAdapter(
            restaurants
        ) { id ->
            (activity as ICoordinator).showDetailsFragment(id)
        }
    }
}