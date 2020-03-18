package com.example.projectsetup.ui.forgotpassword.resetpassword

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.View
import com.example.projectsetup.R
import com.example.projectsetup.base.BaseActivity
import com.example.projectsetup.databinding.ActivityResetPasswordBinding
import com.example.projectsetup.ui.forgotpassword.code.CodeActivity
import com.example.projectsetup.ui.forgotpassword.resetsuccessful.ResetPasswordSuccessful
import kotlinx.android.synthetic.main.activity_forgot_password.*
import kotlinx.android.synthetic.main.activity_reset_password.*

class ResetPasswordActivity : BaseActivity<ActivityResetPasswordBinding, ResetPasswordViewModel>() {

    var show = true

    override fun getLayoutId(): Int = R.layout.activity_reset_password
    override fun getViewModel(): ResetPasswordViewModel = ResetPasswordViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_reset_password)

        initView()
    }


    private fun initView() {
        with(viewDataBinding) {


            imageeyee.setOnClickListener(View.OnClickListener {

                if (show) {
                    imgEyeoff.setImageResource(R.drawable.eye_on)

                    edtNewPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD or InputType.TYPE_CLASS_TEXT)
                    edtNewPassword.setSelection(edtNewPassword.text.length)

                    show = false
                } else {

                    imgEyeoff.setImageResource(R.drawable.eye_off)

                    edtNewPassword.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD or InputType.TYPE_CLASS_TEXT)
                    edtNewPassword.setSelection(edtNewPassword.text.length)
                    show = true
                }

            })




            imageeyee1.setOnClickListener(View.OnClickListener {

                if (show) {
                    imgEyeoff1.setImageResource(R.drawable.eye_on)

                    edtConfirmPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD or InputType.TYPE_CLASS_TEXT)
                    edtConfirmPassword.setSelection(edtConfirmPassword.text.length)

                    show = false
                } else {

                    imgEyeoff1.setImageResource(R.drawable.eye_off)

                    edtConfirmPassword.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD or InputType.TYPE_CLASS_TEXT)
                    edtConfirmPassword.setSelection(edtConfirmPassword.text.length)
                    show = true
                }
            })

            btnReset.setOnClickListener(View.OnClickListener {

                start(this@ResetPasswordActivity)
            })

            backbutton.setOnClickListener { View.OnClickListener {

                    onBack(this@ResetPasswordActivity)
                }
            }


        }

    }

    companion object {

        fun start(context: Context) {
            val intent = Intent(context, ResetPasswordSuccessful::class.java)
            context.startActivity(intent)
        }


    }

    fun onBack(context: Context) {
        val intent = Intent(context, CodeActivity::class.java)
        context.startActivity(intent)

    }

}
