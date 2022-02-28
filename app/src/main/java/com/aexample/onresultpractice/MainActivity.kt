package com.aexample.onresultpractice

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    lateinit var next : Button
    lateinit var display : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        next =  findViewById(R.id.button)
        display =  findViewById(R.id.textView)


        val a = registerForActivityResult(ActivityResultContracts.StartActivityForResult())
        {
            when (it.resultCode) {
                Activity.RESULT_OK -> {
                   val data = it.data
                    data?.getStringExtra("MESSAGE").let {
                        display.text = it
                    }

                }
            }

        }

        next.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            a.launch(intent)
        }

    }
}