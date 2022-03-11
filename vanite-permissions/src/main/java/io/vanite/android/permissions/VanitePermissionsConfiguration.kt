package io.vanite.android.permissions

import android.app.Application
import android.content.Context

/**
 * Created By : Yazan Tarifi
 * Date : 10/13/2019
 * Time : 6:57 PM
 */

object VanitePermissionsConfiguration {

    private lateinit var vortexApplication: Application

    fun attachApplication(app: Application) {
        vortexApplication = app
    }

    fun getContext(): Context {
        return vortexApplication.applicationContext
    }

}
