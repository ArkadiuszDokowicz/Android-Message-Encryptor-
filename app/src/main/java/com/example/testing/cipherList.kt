package com.example.testing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class cipherList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cipher_list)
        val button_cbc = findViewById<Button>(R.id.button2)
        val button_ofb = findViewById<Button>(R.id.button4)
        val button_ecb = findViewById<Button>(R.id.button5)

        var bundle :Bundle ?=intent.extras
        var message = bundle!!.getString("activity")

        button_cbc.setOnClickListener{
            if(message=="encrypt"){
                val intent = Intent(this, MainActivity :: class.java)
                intent.putExtra("algorithm", "cbc")
                intent.putExtra("activity", "encrypt")
                startActivity(intent)
            } else if(message=="decrypt") {
                val intent = Intent(this, MainActivity :: class.java)
                intent.putExtra("algorithm", "cbc")
                intent.putExtra("activity", "decrypt")
                startActivity(intent)
            }
        }

        button_ofb.setOnClickListener{
            if(message=="encrypt"){
                val intent = Intent(this, MainActivity :: class.java)
                intent.putExtra("algorithm", "ofb")
                intent.putExtra("activity", "encrypt")
                startActivity(intent)
            } else if(message=="decrypt") {
                val intent = Intent(this, MainActivity :: class.java)
                intent.putExtra("algorithm", "ofb")
                intent.putExtra("activity", "decrypt")
                startActivity(intent)
            }
        }

        button_ecb.setOnClickListener{
            if(message=="encrypt"){
                val intent = Intent(this, MainActivity :: class.java)
                intent.putExtra("algorithm", "ecb")
                intent.putExtra("activity", "encrypt")
                startActivity(intent)
            } else if(message=="decrypt") {
                val intent = Intent(this, MainActivity :: class.java)
                intent.putExtra("algorithm", "ecb")
                intent.putExtra("activity", "decrypt")
                startActivity(intent)
            }
        }
    }
}