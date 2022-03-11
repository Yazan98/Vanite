package io.vanite.android.utils.picker

import android.net.Uri

interface VaniteFilePickerListener {
    suspend fun onFilePicked(type: PickMethod, data: Uri, reqCode: Int)
}