package com.khadija.nyarticles.datalayer.entities

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


data class NewsResponse(

        @SerializedName("status") val status: String,
        @SerializedName("copyright") val copyright: String,
        @SerializedName("num_results") val num_results: Int,
        @SerializedName("results") val results: List<Results>
)

@Parcelize
data class Results(

        @SerializedName("uri") val uri: String = "",
        @SerializedName("url") val url: String = "",
        @SerializedName("id") val id: Long = -1,
        @SerializedName("published_date") val published_date: String = "",
        @SerializedName("byline") val byline: String = "",
        @SerializedName("type") val type: String = "",
        @SerializedName("title") val title: String = "",
        @SerializedName("abstract") val abstract: String = "",
        @SerializedName("media") val media: List<Media>? = null,

        ) : Parcelable

@Parcelize
data class Media(

        @SerializedName("type") val type: String = "",
        @SerializedName("media-metadata") val media_metadata: List<Media_metadata>? = null
) : Parcelable

@Parcelize
data class Media_metadata(

        @SerializedName("url") val url: String = "",
        @SerializedName("format") val format: String = "",
        @SerializedName("height") val height: Int = 0,
        @SerializedName("width") val width: Int = 0
) : Parcelable
