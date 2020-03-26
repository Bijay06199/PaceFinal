package com.example.projectsetup.ui.forgotpassword.code

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.lifecycle.Observer
import com.example.projectsetup.BR
import com.example.projectsetup.R
import com.example.projectsetup.base.BaseActivity
import com.example.projectsetup.databinding.ActivityCodeBinding
import com.example.projectsetup.databinding.ActivityMainBinding
import com.example.projectsetup.ui.forgotpassword.forgotpassword.ForgotPasswordActivity
import com.example.projectsetup.ui.forgotpassword.resetpassword.ResetPasswordActivity
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class CodeActivity : BaseActivity<ActivityCodeBinding, CodeViewModel>() {

    private val codeViewModel: CodeViewModel by viewModel()

    override fun getLayoutId(): Int = R.layout.activity_code
    override fun getViewModel(): CodeViewModel = codeViewModel

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        initView()
        setUpObservers()


    }

    private fun setUpObservers() {
        with(codeViewModel) {

            btnNextClickEvent.observe(this@CodeActivity, Observer {
                start(this@CodeActivity)
            })

            ivBackClickEvent.observe(this@CodeActivity, Observer {
                onBack(this@CodeActivity)
            })
        }


    }

    private fun initView() {
        with(viewDataBinding) {

            btnCode.setOnClickListener(View.OnClickListener {
                start(this@CodeActivity)
            })
            edtCode2.setTextIsSelectable(true)
            edtCode3.setTextIsSelectable(true)
            edtCode4.setTextIsSelectable(true)



            edtCode1.addTextChangedListener(object : TextWatcher {
                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    // TODO Auto-generated method stub
                    if (edtCode1.length() === 0)
                    //size as per your requirement
                    {
                        // edtCode2.requestFocus()
                    } else {
                        edtCode2.requestFocus()
                    }

                }

                override fun beforeTextChanged(
                    s: CharSequence, start: Int,
                    count: Int, after: Int
                ) {

                }

                override fun afterTextChanged(s: Editable) {

                }
            })



            edtCode2.addTextChangedListener(object : TextWatcher {
                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    // TODO Auto-generated method stub
                    if (edtCode2.length() === 0)
                    //size as per your requirement
                    {
                        //edtCode3.requestFocus()
                    } else {
                        edtCode3.requestFocus()
                    }
                }

                override fun beforeTextChanged(
                    s: CharSequence, start: Int,
                    count: Int, after: Int
                ) {

                }

                override fun afterTextChanged(s: Editable) {

                }
            })


            edtCode3.addTextChangedListener(object : TextWatcher {
                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    // TODO Auto-generated method stub
                    if (edtCode3.length() === 0)
                    //size as per your requirement
                    {
                        //edtCode4.requestFocus()
                    } else {
                        edtCode4.requestFocus()
                    }
                }

                override fun beforeTextChanged(
                    s: CharSequence, start: Int,
                    count: Int, after: Int
                ) {
                }

                override fun afterTextChanged(s: Editable) {

                }
            })
        }

    }

    companion object {

        fun start(context: Context) {
            val intent = Intent(context, ResetPasswordActivity::class.java)
            context.startActivity(intent)

        }

        fun onBack(context: Context) {

            val intent = Intent(context, ForgotPasswordActivity::class.java)
            context.startActivity(intent)
        }

    }
}
