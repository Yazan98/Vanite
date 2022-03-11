package io.vanite.android.data.fake

import android.content.res.Resources
import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.*


class VaniteResourceReader {

    private val LOGTAG = "Vanite Res Reader"

    suspend fun readJsonFromResource(resources: Resources, id: Int): String {
        return withContext(Dispatchers.IO) {
            val resourceReader: InputStream = resources.openRawResource(id)
            val writer: Writer = StringWriter()
            try {
                val reader = BufferedReader(InputStreamReader(resourceReader, "UTF-8"))
                var line: String = reader.readLine()
                while (line != null) {
                    writer.write(line)
                    line = reader.readLine()
                }
            } catch (e: Exception) {
                Log.e(LOGTAG, "Unhandled exception while using JSONResourceReader", e)
            } finally {
                try {
                    resourceReader.close()
                } catch (e: Exception) {
                    Log.e(LOGTAG, "Unhandled exception while using JSONResourceReader", e)
                }
            }
            writer.toString()
        }
    }

    fun <T> getResponseFromJson(json: String, type: Class<T>?): T {
        val gson: Gson = GsonBuilder().create()
        return gson.fromJson(json, type)
    }

}
