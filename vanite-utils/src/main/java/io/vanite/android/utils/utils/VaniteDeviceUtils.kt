package io.vanite.android.utils.utils

import android.annotation.SuppressLint
import android.os.Build

/**
 * Created By : Yazan Tarifi
 * Date : 10/13/2019
 * Time : 1:57 AM
 */

object VaniteDeviceUtils {

    fun getDeviceModel(): String = android.os.Build.MODEL

    fun getApiVersion(): String = android.os.Build.VERSION.SDK

    fun getDeviceInfo(): String = android.os.Build.DEVICE

    fun getProduct(): String = android.os.Build.PRODUCT

    @SuppressLint("HardwareIds")
    fun getFullDeviceInformation(): String = ("VERSION.RELEASE : " + Build.VERSION.RELEASE
            + "\nVERSION.INCREMENTAL : " + Build.VERSION.INCREMENTAL
            + "\nVERSION.SDK.NUMBER : " + Build.VERSION.SDK_INT
            + "\nBOARD : " + Build.BOARD
            + "\nBOOTLOADER : " + Build.BOOTLOADER
            + "\nBRAND : " + Build.BRAND
            + "\nCPU_ABI : " + Build.CPU_ABI
            + "\nCPU_ABI2 : " + Build.CPU_ABI2
            + "\nDISPLAY : " + Build.DISPLAY
            + "\nFINGERPRINT : " + Build.FINGERPRINT
            + "\nHARDWARE : " + Build.HARDWARE
            + "\nHOST : " + Build.HOST
            + "\nID : " + Build.ID
            + "\nMANUFACTURER : " + Build.MANUFACTURER
            + "\nMODEL : " + Build.MODEL
            + "\nPRODUCT : " + Build.PRODUCT
            + "\nSERIAL : " + Build.SERIAL
            + "\nTAGS : " + Build.TAGS
            + "\nTIME : " + Build.TIME
            + "\nTYPE : " + Build.TYPE
            + "\nUNKNOWN : " + Build.UNKNOWN
            + "\nUSER : " + Build.USER)
}