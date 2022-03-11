package io.vanite.android.firebase.listener

import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import java.lang.Exception

/**
 * Created By : Yazan Tarifi
 * Date : 10/26/2019
 * Time : 10:53 PM
 */

interface VaniteGoogleAuthLIstener {

    suspend fun onAuthSuccess(user: GoogleSignInAccount?)

    suspend fun onAuthError(exception: Exception)

}