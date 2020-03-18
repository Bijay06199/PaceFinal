package com.example.projectsetup.ui.forgotpassword.resetpassword

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.projectsetup.R
import com.example.projectsetup.base.BaseActivity
import com.example.projectsetup.databinding.ActivityResetPasswordBinding
import com.example.projectsetup.ui.forgotpassword.resetsuccessful.ResetPasswordSuccessful

class ResetPasswordActivity : BaseActivity<ActivityResetPasswordBinding,ResetPasswordViewModel>() {

    override fun getLayoutId(): Int =R.layout.activity_reset_password
    override fun getViewModel(): ResetPasswordViewModel =ResetPasswordViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_reset_password)


        viewDataBinding.btnReset.setOnClickListener(View.OnClickListener {

            val intent=Intent(this@ResetPasswordActivity,ResetPasswordSuccessful::class.java)
            startActivity(intent)
        })
    }
}
