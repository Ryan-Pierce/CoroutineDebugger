package me.ryanpierce.coroutinedebugger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity(), CoroutineScope by MainScope() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val helloWorld = findViewById<TextView>(R.id.helloWorld)
        launch {
            delay(1000L)
            helloWorld.text = "test"
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        cancel()
    }
}