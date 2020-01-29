package io.vortex.spring.boot.base.models

/**
 * Created By : Yazan Tarifi
 * Date : 10/27/2019
 * Time : 11:31 PM
 */
data class VortexFirebaseDetails(
    var type: String = "service_account",
    var projectId: String = "",
    var privateKeyId: String = "",
    var privateKey: String = "",
    var clientEmail: String = "",
    var clientId: String = "",
    var authUri: String = "",
    var tokenUri: String = "",
    var authProviderX509CertUrl: String = "",
    var clientX509CertUrl: String = "",
    var databaseLink: String = ""
)

data class PathFirebaseConfiguration(
        val databaseLink: String,
        val filePath: String
)