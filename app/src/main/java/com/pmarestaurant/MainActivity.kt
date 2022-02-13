package com.pmarestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.SupportMapFragment
import com.pmarestaurant.descriptiondetails.view.DescriptionDetailsFragment
import com.pmarestaurant.restaurantlist.view.RestaurantListFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ICoordinator {
    lateinit var mapFragment : SupportMapFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showFragment(RestaurantListFragment(),false)
        dugme.setOnClickListener {
            val intent = Intent(this,googleMap::class.java)
            startActivity(intent)
        }

    }


    private fun showFragment(fragment: Fragment, addAsRoot: Boolean = false) {
        val transaction =  supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, fragment)
        if(!addAsRoot) transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun showDetailsFragment(id: Int) {
        showFragment(DescriptionDetailsFragment.newInstance(id-1))

    }
}