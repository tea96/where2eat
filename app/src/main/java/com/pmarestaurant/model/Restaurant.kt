package com.pmarestaurant.model

import com.google.gson.annotations.SerializedName

data class Restaurant(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("opis") val opis: List<String>,
    @SerializedName("img1") val img1: String,
    @SerializedName("img2") val img2: String,
    @SerializedName("img3") val img3: String,
    @SerializedName("img4") val img4: String,
    @SerializedName("img5") val img5: String,
    @SerializedName("img6") val img6: String,
    @SerializedName("img7") val img7: String,
    @SerializedName("img8") val img8: String,
    @SerializedName("img9") val img9: String,
    @SerializedName("img10") val img10: String,
    @SerializedName("predjelo") val description: List<String>,
    @SerializedName("glavnoJelo") val description1: List<String>,
    @SerializedName("dezert") val description2: List<String>
)
