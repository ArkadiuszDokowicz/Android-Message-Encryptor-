package com.example.testing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class activity_choice : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choice)

        val button_encrypt = findViewById<Button>(R.id.encrypt_button)
        val button_decrypt = findViewById<Button>(R.id.decrypt_button)

        button_encrypt.setOnClickListener{
            val intent = Intent(this, cipherList :: class.java)
            intent.putExtra("activity", "encrypt")
            startActivity(intent)
        }
        button_decrypt.setOnClickListener{
            val intent = Intent(this, cipherList :: class.java)
            intent.putExtra("activity", "decrypt")
            startActivity(intent)
        }
    }
}