package com.pmarestaurant.descriptiondetails.view

import android.content.Context
import android.widget.LinearLayout
import com.pmarestaurant.R
import kotlinx.android.synthetic.main.item_description.view.*

class DescriptionView (context: Context): LinearLayout(context) {

    private val view = inflate(context, R.layout.item_description,this)

    fun bind(restaurants: String){
        view.restaurantLine.text = restaurants
    }
}