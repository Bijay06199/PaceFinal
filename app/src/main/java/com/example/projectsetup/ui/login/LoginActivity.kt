package com.example.projectsetup.ui.login

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.View
import com.example.projectsetup.BR
import com.example.projectsetup.R
import com.example.projectsetup.base.BaseActivity
import com.example.projectsetup.databinding.ActivityLoginBinding
import com.example.projectsetup.databinding.ActivityMainBinding
import com.example.projectsetup.ui.forgotpassword.forgotpassword.ForgotPasswordActivity
import com.example.projectsetup.ui.main.MainViewModel
import com.example.projectsetup.ui.navigation.NavigationActivity
import com.example.projectsetup.ui.register.RegisterActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity :BaseActivity<ActivityLoginBinding,LoginViewModel>() {
    var show=true
    override fun getLayoutId(): Int = R.layout.activity_login

    override fun getViewModel() = LoginViewModel()

    override fun getBindingVariable(): Int {

        edtConfirm11.performClick()
        return BR.viewModel
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  setContentView(R.layout.activity_login)
        initView()
    }

    private fun initView() {
        with(viewDataBinding){

            imageeye.setOnClickListener(View.OnClickListener {

                if(show) {
                    imgEyeoff.setImageResource(R.drawable.eye)

                    edtConfirm11.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD or InputType.TYPE_CLASS_TEXT)
                    edtConfirm11.setSelection(edtConfirm11.text!!.length)

                    show=false
                }else{

                    viewDataBinding.imgEyeoff.setImageResource(R.drawable.hide)

                    edtConfirm11.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD or InputType.TYPE_CLASS_TEXT)
                    edtConfirm11.setSelection(edtConfirm11.text!!.length)
                    show=true
                }

            })


            txtForgotPassword.setOnClickListener(View.OnClickListener {

                val intent=Intent(this@LoginActivity,ForgotPasswordActivity::class.java)
                startActivity(intent)
            })


            txtRegister.setOnClickListener(View.OnClickListener {

                val intent=Intent(this@LoginActivity,RegisterActivity::class.java)
                startActivity(intent)
            })

            btnLogin.setOnClickListener(View.OnClickListener {
                start(this@LoginActivity)
            })



        }
    }

    companion object{

       fun start(context: Context){

           val intent=Intent(context,NavigationActivity::class.java)
           context.startActivity(intent)

        }
    }
}
