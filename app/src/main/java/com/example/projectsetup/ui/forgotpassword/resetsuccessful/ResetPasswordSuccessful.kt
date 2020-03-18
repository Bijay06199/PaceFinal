package com.example.projectsetup.ui.forgotpassword.resetsuccessful

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.projectsetup.R
import com.example.projectsetup.base.BaseActivity
import com.example.projectsetup.databinding.ActivityResetPasswordSuccessfulBinding
import com.example.projectsetup.ui.login.LoginActivity

class ResetPasswordSuccessful : BaseActivity<ActivityResetPasswordSuccessfulBinding,ResetPasswordSuccessfullModel>() {

    override fun getLayoutId(): Int =R.layout.activity_reset_password_successful
    override fun getViewModel(): ResetPasswordSuccessfullModel =ResetPasswordSuccessfullModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_reset_password_successful)

        viewDataBinding.btnLoginSuccess.setOnClickListener(View.OnClickListener {

            val intent= Intent(this@ResetPasswordSuccessful,LoginActivity::class.java)
            startActivity(intent)
        })
    }
}
