package com.example.projectsetup.ui.welcome

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projectsetup.BR
import com.example.projectsetup.R
import com.example.projectsetup.base.BaseActivity
import com.example.projectsetup.databinding.ActivityWelcomeBinding
import com.example.projectsetup.ui.login.LoginActivity

class WelcomeActivity : BaseActivity<ActivityWelcomeBinding,WelcomeViewModel>() {

    override fun getLayoutId(): Int =R.layout.activity_welcome
    override fun getViewModel(): WelcomeViewModel = WelcomeViewModel()


    override fun getBindingVariable(): Int {

        return BR.viewModel
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_welcome)
    }


    companion object{

         fun onStart(context: Context){

             val intent=Intent(context,LoginActivity::class.java)
             context.startActivity(intent)

        }
    }
}
