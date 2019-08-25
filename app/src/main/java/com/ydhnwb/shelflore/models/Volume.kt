package com.ydhnwb.shelflore.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Volume(
    @SerializedName("id") var id : String,
    @SerializedName("pageCount") var pageCount : Int,
    @SerializedName("volumeInfo") var volumeInfo : VolumeInfo

) : Parcelable


@Parcelize
data class VolumeInfo(
    @SerializedName("title") var title : String,
    @SerializedName("subtitle") var subtitle : String,
    @SerializedName("authors") var authors : List<String>,
    @SerializedName("imageLinks") var imageLink: ImageLink,
    @SerializedName("language") var language : String,
    @SerializedName("publishedDate") var publishedDate : String,
    @SerializedName("industryIdentifiers") var industryIdentifiers: List<IndustryIdentifiers>,
    @SerializedName("categories") var mainCategory : List<String>,
    @SerializedName("averageRating") var averageRating : Float,
    @SerializedName("ratingsCount") var ratingsCount : Int,
    @SerializedName("description") var description : String

    ) : Parcelable{
    constructor() : this("Title not available", "Sub-title not available",
        mutableListOf(), ImageLink(), "?", "?", mutableListOf(),
        mutableListOf(), 0.0F, 0, "No description available")
}

@Parcelize
data class IndustryIdentifiers(@SerializedName("type") var type : String, @SerializedName("identifier") var identifier : String) : Parcelable {
    constructor() : this("?", "?")
}

@Parcelize
data class ImageLink (@SerializedName("smallThumbnail") var smallThumbnail : String, @SerializedName("thumbnail") var thumbnail : String) :Parcelable {
    constructor() : this("https://genderstudies.indiana.edu/images/publications/book-cover-placeholder.jpg", "https://genderstudies.indiana.edu/images/publications/book-cover-placeholder.jpg")
}