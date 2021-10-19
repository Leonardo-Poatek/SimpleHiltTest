package com.poatek.hilttestapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.poatek.hilttestapplication.models.MyComplexClass
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var injectedClass: MyComplexClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val label = findViewById<TextView>(R.id.text)
        val button = findViewById<Button>(R.id.button)

        if(this::injectedClass.isInitialized) {
            label.text = injectedClass.toString()
        }

        button.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

}