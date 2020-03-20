package com.example.projectsetup.ui.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.View
import androidx.databinding.DataBindingUtil.setContentView
import com.example.projectsetup.R
import com.example.projectsetup.base.BaseActivity
import com.example.projectsetup.databinding.ActivityMainBinding
import com.example.projectsetup.databinding.ActivityRegisterBinding
import com.example.projectsetup.ui.login.LoginActivity
import com.example.projectsetup.ui.navigation.NavigationActivity
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity :BaseActivity<ActivityRegisterBinding,RegisterViewModel>() {
    override fun getLayoutId(): Int=R.layout.activity_register

    override fun getViewModel(): RegisterViewModel = RegisterViewModel()

var show=true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_register)
        initView()

    }

    private fun initView() {
        with(viewDataBinding){
            progressBar.visibility=View.INVISIBLE
            txtLogin.setOnClickListener(View.OnClickListener {

                val intent= Intent(this@RegisterActivity,LoginActivity::class.java)
                startActivity(intent)
            })

            btnRegister.setOnClickListener(View.OnClickListener {
                progressBar.visibility=View.VISIBLE
                val intent=Intent(this@RegisterActivity,NavigationActivity::class.java)
                startActivity(intent)
                finish()


            })



            imageeye1.setOnClickListener(View.OnClickListener {

                if(show) {
                    imgEyeoff1.setImageResource(R.drawable.eye)

                    edtConfirm11.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD or InputType.TYPE_CLASS_TEXT)
                    edtConfirm11.setSelection(edtConfirm11.text!!.length)

                    show=false
                }else{

                    imgEyeoff1.setImageResource(R.drawable.hide)

                    edtConfirm11.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD or InputType.TYPE_CLASS_TEXT)
                    edtConfirm11.setSelection(edtConfirm11.text!!.length)
                    show=true
                }

            })


            imageeye.setOnClickListener(View.OnClickListener {

                if(show) {
                    imgEyeoff.setImageResource(R.drawable.eye)

                    edtConfirm12.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD or InputType.TYPE_CLASS_TEXT)
                    edtConfirm12.setSelection(edtConfirm12.text!!.length)

                    show=false
                }else{

                    imgEyeoff.setImageResource(R.drawable.hide)

                    edtConfirm12.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD or InputType.TYPE_CLASS_TEXT)
                    edtConfirm12.setSelection(edtConfirm12.text!!.length)
                    show=true
                }

            })




            checkMale.setOnClickListener(View.OnClickListener {

                if(checkMale.isChecked){

                    checkFemale.isChecked=false
                    checkOther.isChecked=false
                }
            })








            checkFemale.setOnClickListener(View.OnClickListener {

                if(checkFemale.isChecked){

                    checkMale.isChecked=false
                    checkOther.isChecked=false
                }
            })




            checkOther.setOnClickListener(View.OnClickListener {

                if(checkOther.isChecked){

                    checkFemale.isChecked=false
                    checkMale.isChecked=false
                }
            })
        }

    }
}
