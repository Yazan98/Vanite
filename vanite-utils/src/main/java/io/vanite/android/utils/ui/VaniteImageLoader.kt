package io.vanite.android.utils.ui

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Created By : Yazan Tarifi
 * Date : 10/18/2019
 * Time : 2:43 PM
 */

object VaniteImageLoader {

    @Deprecated("Removed From Library", ReplaceWith("Load Image With Glide"))
    suspend fun loadImageWithPicasso(url: String, image: ImageView) = Unit

    @Deprecated("Removed From Library", ReplaceWith("Load Image With Glide"))
    suspend fun loadImageWithFresco(url: String, image: View) = Unit

    @Deprecated("Removed From Library", ReplaceWith("Load Image With Glide"))
    suspend fun loadLargeImageWithFresco(
        url: String,
        image: View,
        width: Int,
        height: Int
    ) = Unit

    @Deprecated("Removed From Library", ReplaceWith("Load Image With Glide"))
    suspend fun loadImageWithFresco(@DrawableRes url: Int, image: View) = Unit

    suspend fun loadImageWithGlide(view: ImageView?, url: String) {
        withContext(Dispatchers.Main) {
            view?.let {
                Glide.with(it.context)
                    .load(url)
                    .into(it)
            }
        }
    }

    suspend fun loadImageWithGlideListener(view: ImageView?, url: String, onSuccessLoading: () -> Unit, onErrorLoading: (GlideException?) -> Unit) {
        withContext(Dispatchers.Main) {
            view?.let {
                Glide.with(it.context)
                    .load(url)
                    .listener(object: RequestListener<Drawable> {
                        override fun onLoadFailed(
                            e: GlideException?,
                            model: Any?,
                            target: Target<Drawable>?,
                            isFirstResource: Boolean
                        ): Boolean {
                            onErrorLoading(e)
                            return false
                        }

                        override fun onResourceReady(
                            resource: Drawable?,
                            model: Any?,
                            target: Target<Drawable>?,
                            dataSource: DataSource?,
                            isFirstResource: Boolean
                        ): Boolean {
                            onSuccessLoading()
                            return false
                        }
                    })
                    .into(it)
            }
        }
    }

}
