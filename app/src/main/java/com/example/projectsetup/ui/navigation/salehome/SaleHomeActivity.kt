package com.example.projectsetup.ui.navigation.salehome

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projectsetup.BR
import com.example.projectsetup.R
import com.example.projectsetup.base.BaseActivity
import com.example.projectsetup.databinding.ActivitySaleHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SaleHomeActivity : BaseActivity<ActivitySaleHomeBinding,SaleHomeActivityViewModel>() {
    override fun getLayoutId(): Int =R.layout.activity_sale_home
    private val saleHomeActivityViewModel:SaleHomeActivityViewModel by viewModel()
    override fun getViewModel(): SaleHomeActivityViewModel =saleHomeActivityViewModel
    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      ///  setContentView(R.layout.activity_sale_home)
        initView()
    }

    private fun initView() {

    }

}
