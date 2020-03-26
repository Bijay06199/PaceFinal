package com.example.projectsetup.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.example.projectsetup.BR
import com.example.projectsetup.R
import com.example.projectsetup.base.BaseActivity
import com.example.projectsetup.databinding.ActivityMainBinding
import com.example.projectsetup.ui.login.LoginActivity
import com.example.projectsetup.ui.navigation.NavigationActivity
import com.example.projectsetup.ui.register.RegisterActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    private val mainViewModel: MainViewModel by viewModel()
    override fun getLayoutId(): Int = R.layout.activity_main

    override fun getViewModel() = mainViewModel

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        setUpObservers()

    }

    private fun setUpObservers() {
        with(mainViewModel) {
            btnLoginClicked.observe(this@MainActivity, Observer {
                startActivity(Intent(this@MainActivity, LoginActivity::class.java))
            })

            btnRegisterClicked.observe(this@MainActivity, Observer {
                startActivity(Intent(this@MainActivity, RegisterActivity::class.java))
            })

            btnSkipClicked.observe(this@MainActivity, Observer {
                startActivity(Intent(this@MainActivity, NavigationActivity::class.java))
            })

        }

    }

    private fun initView() {
        with(viewDataBinding) {

            //            txtSkip.setOnClickListener(View.OnClickListener {
//                val intent=Intent(this@MainActivity,NavigationActivity::class.java)
//                startActivity(intent)
//            })
//
//
//            btnLogin?.setOnClickListener(View.OnClickListener {
//                val intent=Intent(this@MainActivity,LoginActivity::class.java)
//                startActivity(intent)
//
//            })
//
//
//            btnRegister?.setOnClickListener(View.OnClickListener {
//
//                val intent= Intent (this@MainActivity, RegisterActivity::class.java)
//                startActivity(intent)
//
//            })

        }

    }
}
