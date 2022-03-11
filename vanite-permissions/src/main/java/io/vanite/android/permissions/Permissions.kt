package io.vanite.android.permissions

import androidx.fragment.app.FragmentActivity

/**
 * Created By : Yazan Tarifi
 * Date : 10/13/2019
 * Time : 6:50 PM
 */

interface Permissions {

    suspend fun isPermissionGenerated(permission: String): Boolean

    suspend fun isPermissionsGenerated(permissions: Array<String>): Boolean

    suspend fun requestPermission(permission: String , requestCode: Int)

    suspend fun requestPermissions(permissions: Array<String> , requestCode: Int)

    suspend fun requestContextPermission(context: FragmentActivity, permission: String, reqCode: Int)

    suspend fun requestContextMultiPermissions(context: FragmentActivity, vararg permissions: String, reqCode: Int)

}