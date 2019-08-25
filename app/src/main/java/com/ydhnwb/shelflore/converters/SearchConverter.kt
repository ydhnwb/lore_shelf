package com.ydhnwb.shelflore.converters

import com.google.gson.annotations.SerializedName
import com.ydhnwb.shelflore.models.Volume

data class SearchConverter(
    @SerializedName("kind") var kind : String,
    @SerializedName("totalItems") var totalItems : Int,
    @SerializedName("items") var items : List<Volume>
) {
    constructor() : this("", 0, mutableListOf())
}