package com.cesarschool.helloword
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Car (val nome:String, val modelo:String, val ano:Int):Parcelable