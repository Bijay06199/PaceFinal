package com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.activity

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.projectsetup.BR
import com.example.projectsetup.R
import com.example.projectsetup.base.BaseActivity
import com.example.projectsetup.databinding.ActivityRegisterPropertySalePriceBinding
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.viewModel.RegisterPropertySalePriceViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterPropertySalePrice
    : BaseActivity<ActivityRegisterPropertySalePriceBinding,RegisterPropertySalePriceViewModel>() {

    private val registerPropertySalePriceViewModel:RegisterPropertySalePriceViewModel by viewModel()

    override fun getLayoutId(): Int =R.layout.activity_register_property_sale_price
    override fun getViewModel(): RegisterPropertySalePriceViewModel =registerPropertySalePriceViewModel
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

        with(registerPropertySalePriceViewModel){

            btnNextClicked.observe(this@RegisterPropertySalePrice, Observer {
                startActivity(Intent(this@RegisterPropertySalePrice,RegisterPropertyPreview::class.java))
            })

            ivBackClicked.observe(this@RegisterPropertySalePrice, Observer {
                startActivity(Intent(this@RegisterPropertySalePrice,RegisterPropertyDescriptionActivity::class.java))
            })
        }

    }
}
