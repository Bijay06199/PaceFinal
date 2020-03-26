package com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.projectsetup.BR
import com.example.projectsetup.R
import com.example.projectsetup.base.BaseActivity
import com.example.projectsetup.databinding.ActivityRegisterPropertyDescriptionBinding
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.viewModel.RegisterPropertyDescriptionViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterPropertyDescriptionActivity
    : BaseActivity<ActivityRegisterPropertyDescriptionBinding,RegisterPropertyDescriptionViewModel>() {
    private val registerPropertyDescriptionViewModel:RegisterPropertyDescriptionViewModel by viewModel()
    override fun getLayoutId(): Int=R.layout.activity_register_property_description
    override fun getViewModel(): RegisterPropertyDescriptionViewModel =registerPropertyDescriptionViewModel
    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initView()
        setUpObservers()
    }

    private fun initView() {

    }

    private fun setUpObservers() {

        with(registerPropertyDescriptionViewModel){

            btnNextClicked.observe(this@RegisterPropertyDescriptionActivity, Observer {
                startActivity(Intent(this@RegisterPropertyDescriptionActivity,RegisterPropertyRentPrice::class.java))
            })

            ivBackClicked.observe(this@RegisterPropertyDescriptionActivity, Observer {
                startActivity(Intent(this@RegisterPropertyDescriptionActivity,RegisterPropertyPhotoActivity::class.java))
            })


        }

    }
}
