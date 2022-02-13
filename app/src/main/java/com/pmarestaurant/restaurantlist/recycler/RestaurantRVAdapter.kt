package com.pmarestaurant.restaurantlist.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pmarestaurant.R
import com.pmarestaurant.model.Restaurant

class RestaurantRVAdapter(
    private val restaurants: List<Restaurant>,
    private val onItemClicked: (Int) -> Unit
): RecyclerView.Adapter<RestaurantRVViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=
        RestaurantRVViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_restaurant, parent, false)
        )

    override fun onBindViewHolder(holder: RestaurantRVViewHolder, position: Int) {
        holder.bind(restaurants[position], onItemClicked)
    }

    override fun getItemCount() = restaurants.size


}