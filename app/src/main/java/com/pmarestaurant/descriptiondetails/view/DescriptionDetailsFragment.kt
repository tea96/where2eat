package com.pmarestaurant.descriptiondetails.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.pmarestaurant.R
import com.pmarestaurant.data.ApiServiceProvider
import com.pmarestaurant.data.restaurantDataSource
import com.pmarestaurant.functional.ViewModelFactoryUtil
import com.pmarestaurant.model.Restaurant
import com.pmarestaurant.descriptiondetails.viewmodel.DescriptionDetailsViewModel
import kotlinx.android.synthetic.main.fragment_description_details.*

class DescriptionDetailsFragment : Fragment() {
    private var restaurantId: Int = -1
    private lateinit var viewModel: DescriptionDetailsViewModel

    companion object{
        const val ID_KEY = "restaurant_ID"
        fun newInstance(id: Int): DescriptionDetailsFragment {
            return DescriptionDetailsFragment().apply {
                arguments = Bundle().apply { putInt(ID_KEY, id) }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        restaurantId = arguments?.getInt(ID_KEY) ?: -1
        viewModel = ViewModelProvider(this, ViewModelFactoryUtil.viewModelFactory {
            DescriptionDetailsViewModel(
                restaurantDataSource(ApiServiceProvider.restaurantApiService)
            )
        }).get(DescriptionDetailsViewModel::class.java)


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_description_details, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.state.observe(viewLifecycleOwner,
            Observer{state ->
                detailsProgressBar.visibility = if(state is DescriptionDetailsViewState.Processing) View.VISIBLE else View.GONE

                when(state){
                    is DescriptionDetailsViewState.DataReceived -> setUpView(state.restaurant)
                    is DescriptionDetailsViewState.ErrorReceived -> showError(state.message)
                }
            })

        viewModel.state.observe(viewLifecycleOwner,
            Observer{state ->
                detailsProgressBar.visibility = if(state is DescriptionDetailsViewState.Processing) View.VISIBLE else View.GONE

                when(state){
                    is DescriptionDetailsViewState.DataReceived -> setUpView2(state.restaurant)
                    is DescriptionDetailsViewState.ErrorReceived -> showError(state.message)
                }
            })


        viewModel.state.observe(viewLifecycleOwner,
            Observer{state ->
                detailsProgressBar.visibility = if(state is DescriptionDetailsViewState.Processing) View.VISIBLE else View.GONE

                when(state){
                    is DescriptionDetailsViewState.DataReceived -> setUpView3(state.restaurant)
                    is DescriptionDetailsViewState.ErrorReceived -> showError(state.message)
                }
            })
        viewModel.state.observe(viewLifecycleOwner,
            Observer{state ->
                detailsProgressBar.visibility = if(state is DescriptionDetailsViewState.Processing) View.VISIBLE else View.GONE

                when(state){
                    is DescriptionDetailsViewState.DataReceived -> setUpView4(state.restaurant)
                    is DescriptionDetailsViewState.ErrorReceived -> showError(state.message)
                }
            })
        viewModel.getrestaurant(restaurantId)
    }

    private fun showError(message: String) {
        Toast.makeText(requireContext(),message, Toast.LENGTH_LONG).show()
    }

    private fun setUpView(restaurant: Restaurant) {
        Glide.with(this).load(restaurant.img2).into(this.foodDetailsImg1)
        Glide.with(this).load(restaurant.img3).into(this.foodDetailsImg2)
        Glide.with(this).load(restaurant.img4).into(this.foodDetailsImg3)
        Glide.with(this).load(restaurant.img5).into(this.foodDetailsImg4)
        Glide.with(this).load(restaurant.img6).into(this.foodDetailsImg5)
        Glide.with(this).load(restaurant.img7).into(this.foodDetailsImg6)
        Glide.with(this).load(restaurant.img8).into(this.foodDetailsImg7)
        Glide.with(this).load(restaurant.img9).into(this.foodDetailsImg8)
        Glide.with(this).load(restaurant.img10).into(this.foodDetailsImg9)

        restaurantDetailsName3.text = restaurant.name



        restaurant.description?.forEach { flavor ->
            val view =
                DescriptionView(requireContext())
            view.bind(flavor)
            restaurantLayout.addView(view)
        }
    }

    private fun setUpView2(food: Restaurant) {
        food.description1?.forEach { flavor ->
            val view =
                DescriptionView(requireContext())
            view.bind(flavor)
            restaurantLayout3.addView(view)
        }
    }

    private fun setUpView3(food: Restaurant) {
        food.description2?.forEach { flavor ->
            val view =
                DescriptionView(requireContext())
            view.bind(flavor)
            restaurantLayout4.addView(view)
        }
    }

    private fun setUpView4(food: Restaurant) {
        food.opis?.forEach { flavor ->
            val view =
                DescriptionView(requireContext())
            view.bind(flavor)
            restaurantLayout5.addView(view)
        }
    }


}