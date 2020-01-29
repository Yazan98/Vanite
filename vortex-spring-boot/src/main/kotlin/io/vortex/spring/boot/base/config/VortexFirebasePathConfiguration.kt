package io.vortex.spring.boot.base.config

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import io.vortex.spring.boot.base.config.impl.FirebaseConfig
import io.vortex.spring.boot.base.errors.VortexFirebaseException
import io.vortex.spring.boot.base.errors.details.FirebaseErrorDetails
import io.vortex.spring.boot.base.models.PathFirebaseConfiguration
import org.springframework.context.annotation.Bean
import java.io.File
import java.io.FileInputStream


/**
 * Created By : Yazan Tarifi
 * Date : 10/27/2019
 * Time : 11:27 PM
 */

abstract class VortexFirebasePathConfiguration : FirebaseConfig<PathFirebaseConfiguration> {

    override fun validateParams(params: PathFirebaseConfiguration) {
        if (params.filePath.isEmpty()) {
            throw VortexFirebaseException(
                    "Firebase : The File Path Missing ... Empty Path",
                    FirebaseErrorDetails(
                            "The File Path Missing ... Empty Path",
                            arrayListOf("Path")
                    )
            )
        } else {
            val file = File(params.filePath)
            if (!file.exists()) {
                throw VortexFirebaseException(
                        "Firebase Configuration : File Not Exist At Path : ${params}",
                        FirebaseErrorDetails(
                                "Firebase Configuration : File Not Exist At Path : ${params}",
                                arrayListOf("Path")
                        )
                )
            }
        }
    }

    @Bean
    override fun configFirebase(params: PathFirebaseConfiguration): FirebaseApp {
        val serviceAccount = FileInputStream(params.filePath)

        val options = FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl(params.databaseLink)
                .build()

        return FirebaseApp.initializeApp(options)
    }

}
