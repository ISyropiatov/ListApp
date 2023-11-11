package com.applicat.listapp

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ModelOfFilm(
    val image:String,val name:String,val genre:String,val details:String
): Parcelable {

}
