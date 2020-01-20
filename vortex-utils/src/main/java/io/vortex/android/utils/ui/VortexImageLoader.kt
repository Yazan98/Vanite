package io.vortex.android.utils.ui

import android.net.Uri
import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.view.SimpleDraweeView
import com.facebook.imagepipeline.common.ResizeOptions
import com.facebook.imagepipeline.request.ImageRequestBuilder
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Created By : Yazan Tarifi
 * Date : 10/18/2019
 * Time : 2:43 PM
 */

object VortexImageLoader {

    suspend fun loadImageWithPicasso(url: String, image: ImageView) {
        withContext(Dispatchers.Main) {
            Picasso.get().load(url).into(image)
        }
    }

    suspend fun loadImageWithFresco(url: String, image: SimpleDraweeView) {
        withContext(Dispatchers.Main) {
            image.setImageURI(Uri.parse(url))
        }
    }

    suspend fun loadLargeImageWithFresco(
        url: String,
        image: SimpleDraweeView,
        width: Int,
        height: Int
    ) {
        withContext(Dispatchers.Main) {
            val request = ImageRequestBuilder.newBuilderWithSource(Uri.parse(url))
                .setResizeOptions(ResizeOptions(width, height))
                .build()
            image.controller = Fresco.newDraweeControllerBuilder()
                .setOldController(image.controller)
                .setImageRequest(request)
                .build()
        }
    }

    suspend fun loadImageWithFresco(@DrawableRes url: Int, image: SimpleDraweeView) {
        withContext(Dispatchers.Main) {
            image.setActualImageResource(url)
        }
    }

}