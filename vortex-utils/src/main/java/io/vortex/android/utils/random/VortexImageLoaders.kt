package io.vortex.android.utils.random

import android.net.Uri
import android.widget.ImageView
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.view.SimpleDraweeView
import com.facebook.imagepipeline.common.ResizeOptions
import com.facebook.imagepipeline.request.ImageRequestBuilder
import com.squareup.picasso.Picasso

/**
 * Created By : Yazan Tarifi
 * Date : 10/13/2019
 * Time : 1:51 AM
 */

object VortexImageLoaders {

    fun loadImageWithPicasso(url: String, image: ImageView) {
        Picasso.get()
            .load(url)
            .into(image)
    }

    fun loadImageWithFresco(url: String, image: SimpleDraweeView) {
        image.setImageURI(Uri.parse(url))
    }

    fun loadLargeImageWithFresco(url: String, image: SimpleDraweeView, width: Int, height: Int) {
        val request = ImageRequestBuilder.newBuilderWithSource(Uri.parse(url))
            .setResizeOptions(ResizeOptions(width, height))
            .build()
        image.controller = Fresco.newDraweeControllerBuilder()
            .setOldController(image.controller)
            .setImageRequest(request)
            .build()
    }

}