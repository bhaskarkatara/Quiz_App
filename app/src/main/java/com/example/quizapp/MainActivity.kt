package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class MainActivity : AppCompatActivity() {

    private lateinit var database : FirebaseDatabase
    private lateinit var  userRef : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart : Button = findViewById(R.id.btn_start)
        val etName : EditText = findViewById(R.id.et_name)
        val etId : EditText = findViewById(R.id.et_id)

        userRef = FirebaseDatabase.getInstance().reference.child("User")

         btnStart.setOnClickListener {
             if(etName.text.isEmpty()){
                 Toast.makeText(this, "Please enter your name first", Toast.LENGTH_SHORT).show()
             }
             else if(etId.text.isEmpty()){
                 Toast.makeText(this, "Please enter your ID ", Toast.LENGTH_SHORT).show()
             }
             else{

                 val userName = etName.text.toString()
                 val userId = etId.text.toString()

                 // Create a User object or a Map to store both name and ID
                 val userMap = HashMap<String, Any>()
                 userMap["name"] = userName
                 userMap["id"] = userId

                 // Save user data to Firebase
//                 userRef.push().setValue(userMap)
                 userRef.push().setValue(userMap)
//                     .addOnSuccessListener {
//                         // Data successfully written
//                         Toast.makeText(this, "Data Inserted", Toast.LENGTH_SHORT).show()
//                     }
//                     .addOnFailureListener { e ->
//                         // Handle failure
//                         Toast.makeText(this, "Failed to insert data: $e", Toast.LENGTH_LONG).show()
//                     }
                 Toast.makeText(this, "Data Inserted", Toast.LENGTH_SHORT).show()
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