package com.example.projectsetup.ui.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil.setContentView
import com.example.projectsetup.R
import com.example.projectsetup.base.BaseActivity
import com.example.projectsetup.databinding.ActivityMainBinding
import com.example.projectsetup.databinding.ActivityRegisterBinding
import com.example.projectsetup.ui.login.LoginActivity
import com.example.projectsetup.ui.login.PaceApi
import kotlinx.android.synthetic.main.activity_register.*
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : BaseActivity<ActivityRegisterBinding, RegisterViewModel>() {
    override fun getLayoutId(): Int = R.layout.activity_register

    override fun getViewModel(): RegisterViewModel = RegisterViewModel()

    var show = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_register)

        imageeye1.setOnClickListener(View.OnClickListener {

            if (show) {
                imgEyeoff1.setImageResource(R.drawable.eye)

                edtConfirm11.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD or InputType.TYPE_CLASS_TEXT)
                edtConfirm11.setSelection(edtConfirm11.text!!.length)

                show = false
            } else {

                imgEyeoff1.setImageResource(R.drawable.hide)

                edtConfirm11.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD or InputType.TYPE_CLASS_TEXT)
                edtConfirm11.setSelection(edtConfirm11.text!!.length)
                show = true
            }

        })

        imageeye.setOnClickListener(View.OnClickListener {

            if (show) {
                imgEyeoff.setImageResource(R.drawable.eye)

                edtConfirm12.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD or InputType.TYPE_CLASS_TEXT)
                edtConfirm12.setSelection(edtConfirm12.text!!.length)

                show = false
            } else {

                imgEyeoff.setImageResource(R.drawable.hide)

                edtConfirm12.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD or InputType.TYPE_CLASS_TEXT)
                edtConfirm12.setSelection(edtConfirm12.text!!.length)
                show = true
            }

        })

        checkMale.setOnClickListener(View.OnClickListener {
            if (checkMale.isChecked) {

                checkFemale.isChecked = false
                checkOther.isChecked = false
            }
        })

        checkFemale.setOnClickListener(View.OnClickListener {

            if (checkFemale.isChecked) {

                checkMale.isChecked = false
                checkOther.isChecked = false
            }
        })

        checkOther.setOnClickListener(View.OnClickListener {

            if (checkOther.isChecked) {

                checkFemale.isChecked = false
                checkMale.isChecked = false
            }
        })

        viewDataBinding.txtLogin.setOnClickListener(View.OnClickListener {

            val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
            startActivity(intent)
            this@RegisterActivity.finish()
        })

        viewDataBinding.btnRegister.setOnClickListener {
            var g = "male"
            if (checkFemale.isChecked) {
                g = "female"
            }
            if (checkOther.isChecked) {
                g = "other"
            }
            println(edtFull1.text.toString())
            println(edtEmail1.text.toString())
            println(g)
            println(edtConfirm12.text.toString())
            println(edtConfirm11.text.toString())
            println(cb_terms.isChecked)
            if (cb_terms.isChecked) {
                if (edtFull1.text.isNullOrEmpty()) {
                    makeToast("Full name is not provided")
                } else if (edtEmail1.text.isNullOrEmpty()) {
                    makeToast("Email is not provided")
                } else if (!Patterns.EMAIL_ADDRESS.matcher(edtEmail1.text.toString()).matches()) {
                    makeToast("Invalid email is provided")
                } else if (!checkFemale.isChecked && !checkMale.isChecked && !checkOther.isChecked) {
                    makeToast("Gender is not selected")
                } else if (edtConfirm12.text.isNullOrEmpty()) {
                    makeToast("Password is not provided")
                } else if (edtConfirm12.length() < 8) {
                    makeToast("Password is too short")
                } else if (edtConfirm12.length() > 30) {
                    makeToast("Password is too long")
                } else if (edtConfirm11.text.isNullOrEmpty()) {
                    makeToast("Confirm Password is not provided")
                } else if (edtConfirm11.text.toString() != edtConfirm12.text.toString()) {
                    makeToast("Passwords do not match")
                } else {

                    val signUpBody =
                        SignUpBody(
                            edtEmail1.text.toString(),
                            edtConfirm11.text.toString(),
                            edtFull1.text.toString(),
                            true,
                            g
                        )
                    Log.i("Haha", "done" + signUpBody.toString())
                    PaceApi.retrofitService.signUp(signUpBody)
                        .enqueue(object : Callback<RegisterBody> {
                            override fun onFailure(call: Call<RegisterBody>, t: Throwable) {
                                Log.i("Haha", t.message.toString())
                            }

                            override fun onResponse(
                                call: Call<RegisterBody>,
                                response: Response<RegisterBody>
                            ) {
                                if (response.isSuccessful) {
                                    makeToast("Signup Successful")
                                    val intent =
                                        Intent(this@RegisterActivity, LoginActivity::class.java)
                                    startActivity(intent)
                                    this@RegisterActivity.finish()
                                } else {
                                    makeToast("Signup Failed" + response.errorBody().toString())
                                }
                            }
                        })
                }
            } else {
                makeToast("Terms and services is not agreed")
            }
        }


    }

    fun makeToast(message: String = "Test") {

        Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
    }
}
