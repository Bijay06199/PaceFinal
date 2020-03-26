package com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.projectsetup.BR
import com.example.projectsetup.R
import com.example.projectsetup.base.BaseActivity
import com.example.projectsetup.databinding.ActivityRegisterPropertyConditionBinding
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.viewModel.RegisterPropertyConditionViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterPropertyConditionActivity :
    BaseActivity<ActivityRegisterPropertyConditionBinding,RegisterPropertyConditionViewModel>() {

    private val registerPropertyConditionViewModel:RegisterPropertyConditionViewModel by viewModel()

    override fun getLayoutId(): Int =R.layout.activity_register_property_condition
    override fun getViewModel(): RegisterPropertyConditionViewModel =registerPropertyConditionViewModel
    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        setUpObservers()
    }

    private fun setUpObservers() {

        with(registerPropertyConditionViewModel){

            btnNextClicked.observe(this@RegisterPropertyConditionActivity, Observer {

                onStart(this@RegisterPropertyConditionActivity)
            })

            ivBackClicked.observe(this@RegisterPropertyConditionActivity, Observer {
                Companion.onBack(this@RegisterPropertyConditionActivity)
            })
        }

    }

    private fun initView() {

    }

    companion object{
        fun onStart(context: Context){
            context.startActivity(Intent(context,RegisterPropertyPhotoActivity::class.java))
        }

        fun onBack(context:Context){

            context.startActivity(Intent(context,RegisterPropertyFeatureActivity::class.java))

        }
    }
}
