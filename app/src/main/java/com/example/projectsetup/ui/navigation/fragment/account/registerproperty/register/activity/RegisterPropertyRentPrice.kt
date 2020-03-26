package com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.projectsetup.BR
import com.example.projectsetup.R
import com.example.projectsetup.base.BaseActivity
import com.example.projectsetup.databinding.ActivityRegisterPropertyRentPriceBinding
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.viewModel.RegisterPropertyRentPriceViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterPropertyRentPrice : BaseActivity<ActivityRegisterPropertyRentPriceBinding,RegisterPropertyRentPriceViewModel>() {

    private val registerPropertyRentPriceViewModel:RegisterPropertyRentPriceViewModel by viewModel()

    override fun getLayoutId(): Int =R.layout.activity_register_property_rent_price
    override fun getViewModel(): RegisterPropertyRentPriceViewModel =registerPropertyRentPriceViewModel
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

        with(registerPropertyRentPriceViewModel){
            btnNextClicked.observe(this@RegisterPropertyRentPrice, Observer {
                startActivity(Intent(this@RegisterPropertyRentPrice,RegisterPropertySalePrice::class.java))
            })

            ivBackClicked.observe(this@RegisterPropertyRentPrice, Observer {

                startActivity(Intent(this@RegisterPropertyRentPrice,RegisterPropertyDescriptionActivity::class.java))
            })
        }

    }
}
