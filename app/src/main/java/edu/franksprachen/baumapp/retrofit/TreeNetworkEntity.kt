package edu.franksprachen.baumapp.retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class TreeNetworkEntity(
    @SerializedName("key")
    @Expose
    var key:String,

    @SerializedName("name")
    @Expose
    var name:String,

    @SerializedName("scientificName")
    @Expose
    var scientificName:String,

    @SerializedName("description")
    @Expose
    var description:String,

    @SerializedName("picture")
    @Expose
    var picture:String
)