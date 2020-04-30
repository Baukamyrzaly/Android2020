package com.example.ktvkontakte

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ListItem(
    var groupName: String? = null,
    var publishDate: String? = null,
    var heading: String? = null,
    var likes: String? = null,
    var comments: String? = null,
    var views: String? = null,
    var imgURL: String? = null,
    var shares: String? = null
) : Parcelable