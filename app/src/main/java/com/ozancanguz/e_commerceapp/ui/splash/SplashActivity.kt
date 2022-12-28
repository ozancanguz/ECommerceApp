package com.ozancanguz.e_commerceapp.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ozancanguz.e_commerceapp.R
import com.ozancanguz.e_commerceapp.ui.MainActivity
import com.ozancanguz.e_commerceapp.ui.login.LoginActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        supportActionBar?.hide()
//splash ekran için bir Thread oluşturuyoruz
        val background = object : Thread() {
            override fun run() {
                try {
                    Thread.sleep(5000)
                    val intent = Intent(baseContext, LoginActivity::class.java)
                    startActivity(intent)
                }catch (e : Exception){
                    e.printStackTrace()
                }
            }
        }
        background.start()
    }
}