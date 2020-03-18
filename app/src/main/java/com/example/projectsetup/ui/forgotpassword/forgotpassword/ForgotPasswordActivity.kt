package com.example.projectsetup.ui.forgotpassword.forgotpassword

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.example.projectsetup.BR
import com.example.projectsetup.R
import com.example.projectsetup.base.BaseActivity
import com.example.projectsetup.base.BaseViewModel
import com.example.projectsetup.databinding.ActivityForgotPasswordBinding
import com.example.projectsetup.databinding.ActivityMainBinding
import com.example.projectsetup.ui.forgotpassword.code.CodeActivity
import com.example.projectsetup.ui.forgotpassword.resetpassword.ResetPasswordActivity
import com.example.projectsetup.ui.register.RegisterViewModel
import kotlinx.android.synthetic.main.activity_forgot_password.*
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ForgotPasswordActivity :
    BaseActivity<ActivityForgotPasswordBinding, ForgotPasswordViewModel>() {

    private val forgotPasswordViewModel: ForgotPasswordViewModel by viewModel()


    override fun getLayoutId(): Int = R.layout.activity_forgot_password

    override fun getViewModel(): ForgotPasswordViewModel = forgotPasswordViewModel

    override fun getBindingVariable(): Int {

        return BR.viewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()

        setUpObservers()
        //setContentView(R.layout.activity_forgot_password)


    }

    fun initView() {
        with(viewDataBinding) {
            btnNextForgot.setOnClickListener(View.OnClickListener {

               start(this@ForgotPasswordActivity)
            })
        }


    }

    /** setUpObservers it observes the event**/

    fun setUpObservers() {

        with(forgotPasswordViewModel) {

            nextClickEvent.observe(this@ForgotPasswordActivity, Observer {

                var txtEmail: String = txtYour.text.toString()

                if (!txtEmail.isEmpty())

                    forgotPassword(txtEmail)

            })
        }


    }

    companion object {

        fun start(context: Context) {
            val intent = Intent(context, CodeActivity::class.java)
            context.startActivity(intent)

        }
    }
}
