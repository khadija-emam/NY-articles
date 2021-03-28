package com.khadija.nyarticles

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.khadija.nyarticles.datalayer.entities.Media

/**
 * here we  make annoation for binding image
 */
/**
 * Uses the Glide library to load an image by URL into an [ImageView]
 */
@BindingAdapter("imageMedia")
fun bindImage(imgView: ImageView, imgList:List<Media>?) {
    if (!imgList.isNullOrEmpty()) {
        Glide.with(imgView.context)
                .load(imgList[0].media_metadata?.get(0)?.url)
                .apply(
                        RequestOptions()
                                .placeholder(R.drawable.circle_img)
                                .error(R.drawable.circle_img)
                )
                .into(imgView)
    }
}










