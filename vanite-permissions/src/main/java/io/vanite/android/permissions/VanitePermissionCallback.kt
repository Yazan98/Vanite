package io.vanite.android.permissions

/**
 * Created By : Yazan Tarifi
 * Date : 10/18/2019
 * Time : 2:28 PM
 */

interface VanitePermissionCallback {

    suspend fun onPermissionGenerated(requestCode: Int , permissions: List<String>)

    suspend fun onPermissionDenied(requestCode: Int , permissions: List<String>)

}
