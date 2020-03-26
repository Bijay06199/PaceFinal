package com.example.projectsetup.ui.forgotpassword.resetsuccessful

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.example.projectsetup.BR
import com.example.projectsetup.R
import com.example.projectsetup.base.BaseActivity
import com.example.projectsetup.databinding.ActivityResetPasswordSuccessfulBinding
import com.example.projectsetup.ui.forgotpassword.resetpassword.ResetPasswordActivity
import com.example.projectsetup.ui.login.LoginActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class ResetPasswordSuccessful : BaseActivity<ActivityResetPasswordSuccessfulBinding,ResetPasswordSuccessfullModel>() {

    private val resetPasswordSuccessfullModel:ResetPasswordSuccessfullModel by viewModel()
    override fun getLayoutId(): Int =R.layout.activity_reset_password_successful
    override fun getViewModel(): ResetPasswordSuccessfullModel =resetPasswordSuccessfullModel
    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        setUpObservers()
    }

    private fun setUpObservers() {

        with(resetPasswordSuccessfullModel){
            btnNextClicked.observe(this@ResetPasswordSuccessful, Observer {
                start(this@ResetPasswordSuccessful)
            })
        }

    }

    private fun initView() {

        with(viewDataBinding){

           backbutton.setOnClickListener(View.OnClickListener {
               back(this@ResetPasswordSuccessful)
           })
        }

    }


    companion object{

        fun start(context: Context){

            val intent=Intent(context,LoginActivity::class.java)
            context.startActivity(intent)
        }

        fun back(context: Context){

            val intent=Intent(context,ResetPasswordActivity::class.java)
            context.startActivity(intent)
        }
    }
}
