package io.vortex.spring.boot.base.config.impl

import com.google.firebase.FirebaseApp

/**
 * Created By : Yazan Tarifi
 * Date : 10/27/2019
 * Time : 11:27 PM
 */
interface FirebaseConfig<P> {

    fun validateParams(params: P)

    fun configFirebase(params: P): FirebaseApp

    fun getFirebaseDetails(): P

}
