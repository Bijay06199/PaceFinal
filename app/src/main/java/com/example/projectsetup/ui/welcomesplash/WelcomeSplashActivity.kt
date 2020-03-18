package com.example.projectsetup.ui.welcomesplash

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.projectsetup.BR
import com.example.projectsetup.R
import com.example.projectsetup.base.BaseActivity
import com.example.projectsetup.databinding.ActivityWelcomeSplashBinding
import com.example.projectsetup.ui.main.MainActivity

class WelcomeSplashActivity :BaseActivity<ActivityWelcomeSplashBinding,WelcomeSplashViewModel>() {
    override fun getLayoutId(): Int =R.layout.activity_welcome_splash

    override fun getViewModel(): WelcomeSplashViewModel =WelcomeSplashViewModel()


    override fun getBindingVariable(): Int {

        return BR.viewModel
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  setContentView(R.layout.activity_welcome_splash)

        initView()





        }

    private fun initView() {
        with(viewDataBinding){

            btnSplashNext1.setOnClickListener(View.OnClickListener {

                start(this@WelcomeSplashActivity)
            })
        }
    }

    companion object {

        fun start(context: Context) {

            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)

        }

    }

    }




