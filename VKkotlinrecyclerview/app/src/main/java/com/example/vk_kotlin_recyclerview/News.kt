package com.example.vk_kotlin_recyclerview

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class News (
    var imageName: String,
    var timeName: String,
    var contentName: String,
    var image: Int,
    var contentImage: Int,
    var likeNum: Int,
    var commentNum: Int,
    var shareNum: Int,
    var viewsNum: Int,
    var liked: Int,
    var likeBtn: Int
) : Parcelable