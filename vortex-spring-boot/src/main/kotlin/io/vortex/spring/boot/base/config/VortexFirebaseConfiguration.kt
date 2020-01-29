package io.vortex.spring.boot.base.config

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import io.vortex.spring.boot.base.config.impl.FirebaseConfig
import io.vortex.spring.boot.base.errors.VortexFirebaseException
import io.vortex.spring.boot.base.errors.details.FirebaseErrorDetails
import io.vortex.spring.boot.base.models.VortexFirebaseDetails
import org.springframework.context.annotation.Bean
import java.io.ByteArrayInputStream

/**
 * Created By : Yazan Tarifi
 * Date : 10/27/2019
 * Time : 11:27 PM
 */

abstract class VortexFirebaseConfiguration : FirebaseConfig<VortexFirebaseDetails> {

    private val params: ArrayList<String> by lazy {
        ArrayList<String>()
    }

    init {
        validateParams(this.getFirebaseDetails())
    }

    @Throws(VortexFirebaseException::class)
    final override fun validateParams(params: VortexFirebaseDetails) {
        when {
            params.authProviderX509CertUrl.isEmpty() -> this.params.add(params.authProviderX509CertUrl)
            params.authUri.isEmpty() -> this.params.add(params.authUri)
            params.clientEmail.isEmpty() -> this.params.add(params.clientEmail)
            params.clientId.isEmpty() -> this.params.add(params.clientId)
            params.databaseLink.isEmpty() -> this.params.add(params.databaseLink)
            params.privateKey.isEmpty() -> this.params.add(params.privateKey)
            params.privateKeyId.isEmpty() -> this.params.add(params.privateKeyId)
            params.tokenUri.isEmpty() -> this.params.add(params.tokenUri)
            params.projectId.isEmpty() -> this.params.add(params.projectId)
            params.type.isEmpty() -> this.params.add(params.type)
            else -> {
                configFirebase(params)
            }
        }
        if (this.params.isNotEmpty()) {
            throw VortexFirebaseException(
                    "Vortex Firebase Configuration (Some Details Missing ...)",
                    FirebaseErrorDetails(
                            "Details Missing",
                            this.params
                    )
            )
        }
    }

    @Bean
    override fun configFirebase(params: VortexFirebaseDetails): FirebaseApp {

        val firebaseServiceAccount = "{" +
                "  \"type\": \"${params.type}\"," +
                "  \"project_id\": \"${params.projectId}\"," +
                "  \"private_key_id\": \"${params.privateKeyId}\",\n" +
                "  \"private_key\": \"${params.privateKey}\"," +
                "  \"client_email\": \"${params.clientEmail}\"," +
                "  \"client_id\": \"${params.clientId}\"," +
                "  \"auth_uri\": \"${params.authUri}\"," +
                "  \"token_uri\": \"${params.tokenUri}\"," +
                "  \"auth_provider_x509_cert_url\": \"${params.authProviderX509CertUrl}\"," +
                "  \"client_x509_cert_url\": \"${params.clientX509CertUrl}\"" +
                "}"

        val serviceAccount = ByteArrayInputStream(firebaseServiceAccount.toByteArray())

        val options = FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl(params.databaseLink)
                .build()

        return FirebaseApp.initializeApp(options)
    }

}
