package io.vanite.android.utils.utils

import android.util.Base64
import android.util.Base64.URL_SAFE
import android.util.Log
import com.google.gson.Gson
import java.io.UnsupportedEncodingException
import java.nio.charset.Charset

/**
 * Created By : Yazan Tarifi
 * Date : 10/13/2019
 * Time : 1:56 AM
 */

object VaniteGsonUtils {

    fun convertToGson(data: Any): String {
        return Gson().toJson(data)
    }

    fun convertArrayToGson(data: Array<*>): String {
        return Gson().toJson(data)
    }

    fun convertArrayListToGson(data: ArrayList<*>): String {
        return Gson().toJson(data)
    }

    fun convertFromJsonToObject(jsonFile: String, targetClass: Class<*>): Any? {
        return Gson().fromJson(jsonFile, targetClass)
    }

    @Throws(Exception::class)
    fun decoded(JWTEncoded: String) {
        try {
            val split = JWTEncoded.split("\\.".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            Log.d("JWT_DECODED Header: " , getJson(split[0]))
            Log.d("JWT_DECODED Body: " , getJson(split[1]))
        } catch (e: UnsupportedEncodingException) {
            Log.e("AttoImageLoaders Decode Token Error" , e.toString())
        }

    }

    @Throws(UnsupportedEncodingException::class)
    private fun getJson(strEncoded: String): String {
        val decodedBytes = Base64.decode(strEncoded, URL_SAFE)
        return String(decodedBytes, Charset.defaultCharset())
    }

    fun getTokenDetailsFromJson(token: String, targetClass: Class<*>): Any? {
        val split = token.split("\\.".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        val jsonToken = getJson(split[1])
        return convertFromJsonToObject(jsonToken, targetClass)
    }


}