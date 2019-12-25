package io.vortex.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private val repo: GithubRepo by lazy {
        GithubRepo()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        GlobalScope.launch {
            sendRequest()
        }
    }

    private suspend fun sendRequest() {
        withContext(Dispatchers.IO) {
            println("Vortex Send Request")
            repo.getService().getUserDetails("Value" , "Value").subscribe({
                println("Vortex OnSuccess")
            } , {
                println("Vortex onError")
            })
        }
    }

    data class Body(
        val test: String = ""
    )
}
