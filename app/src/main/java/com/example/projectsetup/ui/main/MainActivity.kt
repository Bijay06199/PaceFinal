package com.example.projectsetup.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.projectsetup.BR
import com.example.projectsetup.R
import com.example.projectsetup.base.BaseActivity
import com.example.projectsetup.databinding.ActivityMainBinding
import com.example.projectsetup.ui.login.LoginActivity
import com.example.projectsetup.ui.register.RegisterActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {


    override fun getLayoutId(): Int = R.layout.activity_main

    override fun getViewModel() = MainViewModel()

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }


  override fun onCreate(savedInstanceState: Bundle?) {
     super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)


             viewDataBinding.btnLogin?.setOnClickListener(View.OnClickListener {
                 val intent=Intent(this@MainActivity,LoginActivity::class.java)
                 startActivity(intent)

      })


     viewDataBinding.btnRegister?.setOnClickListener(View.OnClickListener {

          val intent= Intent (this@MainActivity, RegisterActivity::class.java)
          startActivity(intent)

      })




    }
}
