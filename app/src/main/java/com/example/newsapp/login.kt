package com.example.newsapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class login : AppCompatActivity() {

    private lateinit var etmailid: EditText
    private lateinit var etpassword: EditText
    private lateinit var btnsubmit: Button
    lateinit var sharedPreferences: SharedPreferences
     var EMAIL = "email"
     var PASSWORD = "password"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        sharedPreferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)

        etmailid = findViewById(R.id.etmailid)
        etpassword = findViewById(R.id.etpassword)
        btnsubmit = findViewById(R.id.btnsubmit)

        btnsubmit.setOnClickListener {
            when {
                etmailid.text.isNullOrEmpty() -> {
                    Toast.makeText(
                        this, "Please Enter a valid email",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                etpassword.text.isNullOrEmpty() -> {
                    Toast.makeText(
                        this, "Please Enter Correct Password",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                else -> {
                    val email: String = etmailid.text.toString()
                    val password: String = etpassword.text.toString()

                    val editor: SharedPreferences.Editor = sharedPreferences.edit()


                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(
                            { task ->

                                if (task.isSuccessful) {
                                    editor.putString(EMAIL, etmailid.getText().toString())
                                    editor.putString(PASSWORD, etpassword.getText().toString())
                                    editor.commit()

                                    val firebaseUser: FirebaseUser = task.result!!.user!!

                                    Toast.makeText(
                                        this, "Welcome $email", Toast.LENGTH_SHORT
                                    )
                                        .show()
                                    val intent = Intent(this, News::class.java)
                                    startActivity(intent)
                                } else {
                                    Toast.makeText(
                                        this, "Please enter valid mail id and password",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                        )
                }
            }
        }
    }
}