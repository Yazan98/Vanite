package io.vanite.android.utils

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.telephony.SmsMessage

/**
 * Created By : Yazan Tarifi
 * Date : 12/24/2019
 * Time : 11:49 PM
 */

class VaniteMessagesListener : BroadcastReceiver() {

    private val action: String = "android.provider.Telephony.SMS_RECEIVED"

    override fun onReceive(context: Context?, intent: Intent?) {
        intent?.let { target ->
            if (target.action.equals(action)) {
                val extras = target.extras
                extras?.let { data ->
                    val myPuds = data.get("pdus") as Array<*>
                    val messages = arrayOfNulls<SmsMessage>(myPuds.size)
                    for ((index, value) in messages.withIndex()) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            val format = data.getString("format");
                            messages[index] =
                                SmsMessage.createFromPdu(myPuds[index] as ByteArray, format)
                        } else {
                            messages[index] = SmsMessage.createFromPdu(myPuds[index] as ByteArray)
                        }
                        val currentMessage = messages[index]?.messageBody;
                        val phoneNumber = messages[index]?.originatingAddress;
                        val result: Intent = Intent()
                            .putExtra("Message", currentMessage)
                            .putExtra("PhoneNumber", phoneNumber)
                        result.action = "MESSAGE_ACTION"
                        context?.sendBroadcast(result)
                    }
                }
            }
        }
    }
}