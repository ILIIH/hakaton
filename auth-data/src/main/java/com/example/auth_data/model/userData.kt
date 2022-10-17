package com.example.auth_data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class userData(val username: String, val email: String, val passwors: String) : Parcelable