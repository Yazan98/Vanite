package io.vanite.android.utils.picker

import android.content.Context
import android.provider.MediaStore
import android.provider.MediaStore.Images
import android.graphics.Bitmap
import android.net.Uri
import java.io.ByteArrayOutputStream
import android.webkit.MimeTypeMap
import android.content.ContentResolver
import java.io.File

object VaniteImageManager {

    fun getImageUri(inContext: Context, inImage: Bitmap): Uri {
        val bytes = ByteArrayOutputStream()
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes)
        val path = Images.Media.insertImage(inContext.contentResolver, inImage, "Title", null)
        return Uri.parse(path)
    }

    fun getRealPathFromURI(context: Context , uri: Uri): String {
        var path = ""
        if (context.contentResolver != null) {
            val cursor = context.contentResolver.query(uri, null, null, null, null)
            if (cursor != null) {
                cursor!!.moveToFirst()
                val idx = cursor!!.getColumnIndex(MediaStore.Images.ImageColumns.DATA)
                path = cursor!!.getString(idx)
                cursor!!.close()
            }
        }
        return path
    }

    fun getMimeType(context: Context, uri: Uri): String? {
        val extension: String?
        extension = if (uri.scheme == ContentResolver.SCHEME_CONTENT) {
            val mime = MimeTypeMap.getSingleton()
            mime.getExtensionFromMimeType(context.contentResolver.getType(uri))
        } else {
            MimeTypeMap.getFileExtensionFromUrl(Uri.fromFile(File(uri.path)).toString())

        }

        return extension
    }

}