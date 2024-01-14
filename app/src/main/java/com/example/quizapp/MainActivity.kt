package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart : Button = findViewById(R.id.btn_start)
        val etName : EditText = findViewById(R.id.et_name)

         btnStart.setOnClickListener {
             if(etName.text.isEmpty()){
                 Toast.makeText(this, "Please enter your name first", Toast.LENGTH_SHORT).show()
             }
             else{
                 // create intent
                 val intent  = Intent(this,QuizQuestionsActivity :: class.java)
                 // TODO Pass the name through intent using the constant variable which we have created.
                 intent.putExtra(Constants.USER_NAME, etName.text.toString())
                 startActivity(intent)
                 finish()
             }
         }


    }
}