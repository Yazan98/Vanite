package io.vortex.android

/**
 * Created By : Yazan Tarifi
 * Date : 10/9/2019
 * Time : 10:43 PM
 */

interface VortexAction
interface VortexPacketAction<B> : VortexAction {

    fun getActionBody(): B

}
