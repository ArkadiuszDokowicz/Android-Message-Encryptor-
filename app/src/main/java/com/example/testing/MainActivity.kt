package com.example.testing

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import org.bouncycastle.jce.provider.BouncyCastleProvider
import java.security.Security


class MainActivity : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        Security.addProvider(BouncyCastleProvider())



        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button3);
        val textToEncryptTextBox = findViewById<EditText>(R.id.toEncryptText);
        val encryptedTextBox = findViewById<EditText>(R.id.encrpytedText);

        button.setOnClickListener {
            val encryptedText = MyCipher.AESencrypt(textToEncryptTextBox.text.toString(), MyCipher.Mode.CBC);
            encryptedTextBox.setText(encryptedText);
        }


    }

}
