package com.example.projectsetup.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import com.example.projectsetup.R
import com.example.projectsetup.data.prefs.PreferenceManager
import com.example.projectsetup.ui.login.LoginActivity
import com.example.projectsetup.ui.main.MainActivity
import com.example.projectsetup.ui.navigation.NavigationActivity
import com.example.projectsetup.ui.welcome.WelcomeActivity
import org.koin.android.ext.android.inject

class SplashScreenActivity : AppCompatActivity() {

    private val preferenceManager: PreferenceManager by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        window.requestFeature(Window.FEATURE_NO_TITLE)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)


        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_splash_screen)

        //4second splash time
        Handler().postDelayed({
            //start main activity
            if(preferenceManager.getIsLoggedIn()){
                startActivity(Intent(this@SplashScreenActivity, NavigationActivity::class.java))
            }
            else{
                startActivity(Intent(this@SplashScreenActivity, WelcomeActivity::class.java))
            }
            //finish this activity
            finish()
        },1000)

    }
    }

