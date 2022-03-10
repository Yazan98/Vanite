package io.vortex.android.firebase.impl

import android.content.Context
import android.content.Intent
import io.vortex.android.firebase.listener.VortexGoogleAuthLIstener

/**
 * Created By : Yazan Tarifi
 * Date : 10/26/2019
 * Time : 10:30 PM
 */

interface FirebaseAuthImpl {

    suspend fun signInEmailAndPassword(email: String, password: String)

    suspend fun signInByGoogle(context: Context, defWebClientId: String , reqCode: Int)

    suspend fun registerWithEmailAndPassword(email: String, password: String)

    suspend fun registerGoogleSignInHandler(requestCode: Int, data: Intent?, googleListener: VortexGoogleAuthLIstener?)

    suspend fun signOut()

    suspend fun checkAccountStatus(): Boolean

    suspend fun destroyAuth()
}
