package com.pmarestaurant.restaurantlist.recycler

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pmarestaurant.model.Restaurant
import kotlinx.android.synthetic.main.item_restaurant.view.*

class RestaurantRVViewHolder(view: View): RecyclerView.ViewHolder(view) {
    fun bind(
        restaurant: Restaurant,
        onItemClicked: (Int) -> Unit
    ){
        Glide.with(itemView).load(restaurant.img1).into(itemView.groupImg)
        itemView.name.text = restaurant.name
        itemView.setOnClickListener{onItemClicked.invoke(restaurant.id)}
    }
}