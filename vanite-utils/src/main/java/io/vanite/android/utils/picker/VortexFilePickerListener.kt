package io.vanite.android.utils.picker

import android.net.Uri

interface VortexFilePickerListener {
    suspend fun onFilePicked(type: PickMethod, data: Uri, reqCode: Int)
}