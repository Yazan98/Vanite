package io.vanite.android.utils.picker

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.provider.OpenableColumns
import androidx.fragment.app.FragmentActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File

class VaniteFileAttachPicker {

    private var pickerState: PickMethod = PickMethod.GALLERY
    private var listener: VaniteFilePickerListener? = null

    suspend fun startImagesAttach(context: FragmentActivity?, reqCode: Int) {
        withContext(Dispatchers.Main) {
            pickerState = PickMethod.GALLERY
            context?.let {
                it.startActivityForResult(
                    Intent.createChooser(
                        getIntentByMethod(PickMethod.GALLERY),
                        "Select Picture"
                    ),
                    reqCode
                )
            }
        }
    }

    suspend fun startFilesAttach(context: FragmentActivity?, reqCode: Int) {
        withContext(Dispatchers.Main) {
            pickerState = PickMethod.DOC
            context?.let {
                it.startActivityForResult(
                    Intent.createChooser(
                        getIntentByMethod(PickMethod.DOC),
                        "Select Picture"
                    ),
                    reqCode
                )
            }
        }
    }

    suspend fun startCameraAttach(context: FragmentActivity?, reqCode: Int) {
        withContext(Dispatchers.Main) {
            context?.let {
                pickerState = PickMethod.CAMERA
                it.startActivityForResult(getIntentByMethod(PickMethod.CAMERA), reqCode)
            }
        }
    }

    private fun getIntentByMethod(method: PickMethod): Intent {
        when (method) {
            PickMethod.CAMERA -> return Intent("android.media.action.IMAGE_CAPTURE")
            PickMethod.DOC -> {
                val intent = Intent()
                intent.type = "application/pdf"
                intent.action = Intent.ACTION_GET_CONTENT
                return intent
            }

            PickMethod.GALLERY -> {
                val intent = Intent()
                intent.type = "image/*"
                intent.action = Intent.ACTION_GET_CONTENT
                return intent
            }
        }
    }

    suspend fun onFileResult(activity: FragmentActivity?, requestCode: Int, data: Intent?) {
        withContext(Dispatchers.IO) {
            when (pickerState) {
                PickMethod.CAMERA -> {
                    activity?.let { context ->
                        data?.let {
                            it.extras?.let {
                                val photo = it.get("data") as Bitmap
                                val tempUri = VaniteImageManager.getImageUri(context, photo)
                                val finalFile =
                                    File(VaniteImageManager.getRealPathFromURI(context, tempUri))
                                listener?.let {
                                    it.onFilePicked(
                                        pickerState,
                                        Uri.fromFile(finalFile),
                                        requestCode
                                    )
                                }
                            }
                        }
                    }
                }
                else -> {
                    data?.let {
                        it.data?.let {
                            listener?.onFilePicked(pickerState, it, requestCode)
                        }
                    }
                }
            }
        }
    }

    fun getFileNameByUri(activity: FragmentActivity?, uri: Uri): String {
        var result: String = ""
        if (uri.scheme.equals("content")) {
            val cursor = activity?.contentResolver?.query(uri, null, null, null, null);
            cursor.use { cursor ->
                if (cursor != null && cursor.moveToFirst()) {
                    result = cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME));
                }
            }
        }
        return result
    }


    suspend fun addFileListener(newListener: VaniteFilePickerListener) {
        withContext(Dispatchers.IO) {
            listener = newListener
        }
    }

    suspend fun destroyFileAttach() {
        withContext(Dispatchers.IO) {
            listener = null
        }
    }

}

