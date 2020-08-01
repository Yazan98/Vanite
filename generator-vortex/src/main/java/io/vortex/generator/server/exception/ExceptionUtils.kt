package io.vortex.generator.server.exception

object ExceptionUtils {

    fun throwAppTypeException() {
        throw VortexValidationException("Android Application Type not presented", VortexAppError("Add Request Param : appType", "appType Missing or Invalid Value"))
    }

    fun throwRequestBodyMissingException() {
        throw VortexValidationException("Request Body Not Presented !!", VortexAppError("Request Body Missing", "Add App Request Details in Request Body"))
    }

}