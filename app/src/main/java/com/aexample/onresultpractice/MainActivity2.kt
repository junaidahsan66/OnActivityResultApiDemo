package com.aexample.onresultpractice

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    lateinit var next : Button
    lateinit var displayText : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        next =  findViewById(R.id.button2)
        displayText =  findViewById(R.id.editTextTextPersonName)
        next.setOnClickListener {
            val message=displayText.text.toString();
            val intent= Intent();
            intent.putExtra("MESSAGE",message);
            setResult(Activity.RESULT_OK,intent);
            finish()
        }
    }
}