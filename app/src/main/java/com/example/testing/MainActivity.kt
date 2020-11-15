package com.example.testing

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.InterstitialAd
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_main.*
import org.bouncycastle.jce.provider.BouncyCastleProvider
import java.security.Security


class MainActivity : AppCompatActivity()  {

    fun fillWithBytes(key : String): String {
        var klucz = key
        while(klucz.length <16){
            klucz = klucz + "0"
            println(klucz)
        }
        return klucz
    }

    lateinit var mAdView : AdView
    private lateinit var mInterstitialAd: InterstitialAd

    override fun onCreate(savedInstanceState: Bundle?) {

        Security.addProvider(BouncyCastleProvider())
        var bundle :Bundle ?=intent.extras
        var bundle_activity :Bundle ?=intent.extras
        var message = bundle!!.getString("algorithm")
        var activity = bundle_activity!!.getString("activity")
        println(message)
        println(activity)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MobileAds.initialize(this) {}
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        mInterstitialAd = InterstitialAd(this)
        mInterstitialAd.adUnitId = "ca-app-pub-3940256099942544/1033173712"
        mInterstitialAd.loadAd(AdRequest.Builder().build())

        val button = findViewById<Button>(R.id.button3)
        val textToEncryptTextBox = findViewById<EditText>(R.id.toEncryptText)
        val encryptedTextBox = findViewById<EditText>(R.id.encrpytedText)
        val key = findViewById<EditText>(R.id.key)
        val vec = findViewById<EditText>(R.id.init_vec)
        button.setOnClickListener {
            if (mInterstitialAd.isLoaded) {
                mInterstitialAd.show()
            } else {
                Log.d("TAG", "The interstitial wasn't loaded yet.")
            }

            var klucz = key.text.toString()
            klucz = fillWithBytes(klucz)
            var wektor = vec.text.toString()
            wektor = fillWithBytes(wektor)
            if(message == "cbc" && activity == "encrypt"){
                val encryptedText = MyCipher.AESencrypt(textToEncryptTextBox.text.toString(), MyCipher.Mode.CBC, klucz, wektor)
                encryptedTextBox.setText(encryptedText)
            } else if(message == "cbc" && activity == "decrypt"){
                val encryptedText = MyCipher.AESdecrypt(textToEncryptTextBox.text.toString(), MyCipher.Mode.CBC, klucz, wektor)
                encryptedTextBox.setText(encryptedText)

        }/*
            else if(message == "ofb"){
                val encryptedText = MyCipher.AESencrypt(textToEncryptTextBox.text.toString(), MyCipher.Mode.OFB)
                encryptedTextBox.setText(encryptedText)
                println("you picked ofb")
            }
            else if(message == "cfb"){
                val encryptedText = MyCipher.AESencrypt(textToEncryptTextBox.text.toString(), MyCipher.Mode.CFB)
                encryptedTextBox.setText(encryptedText)
                println("you picked cfb")
            }
            else if (message == "ctr"){
                val encryptedText = MyCipher.AESencrypt(textToEncryptTextBox.text.toString(), MyCipher.Mode.CTR)
                encryptedTextBox.setText(encryptedText)
                println("you picked CTR")
            }*/
        }
    }
}