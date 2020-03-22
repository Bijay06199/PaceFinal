package com.example.projectsetup.ui.login

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
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
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>() {
    var show = true
    override fun getLayoutId(): Int = R.layout.activity_login

    private val loginViewModel: LoginViewModel by viewModel()
    override fun getViewModel() = loginViewModel

    override fun getBindingVariable(): Int {

        edtConfirm11.performClick()
        return BR.viewModel
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //  setContentView(R.layout.activity_login)
        initView()
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun initView() {
        progress_bar.visibility = View.INVISIBLE

        with(viewDataBinding) {


            btnLogin.setOnTouchListener(View.OnTouchListener { v, event ->
                when (event.action) {
                    MotionEvent.ACTION_DOWN -> {
                        val scaleDownX = ObjectAnimator.ofFloat(
                            btnLogin,
                            "scaleX", 0.8f
                        )
                        val scaleDownY = ObjectAnimator.ofFloat(
                            btnLogin,
                            "scaleY", 0.8f
                        )
                        scaleDownX.duration = 1000
                        scaleDownY.duration = 1000

                        val scaleDown = AnimatorSet()
                        scaleDown.play(scaleDownX).with(scaleDownY)

                        scaleDown.start()
                    }

                    MotionEvent.ACTION_UP -> {
                        val scaleDownX2 = ObjectAnimator.ofFloat(
                            btnLogin, "scaleX", 1f
                        )
                        val scaleDownY2 = ObjectAnimator.ofFloat(
                            btnLogin, "scaleY", 1f
                        )
                        scaleDownX2.duration = 1000
                        scaleDownY2.duration = 1000

                        val scaleDown2 = AnimatorSet()
                        scaleDown2.play(scaleDownX2).with(scaleDownY2)

                        scaleDown2.start()
                    }
                }
                false


            })



            setObservers()

            imageeye.setOnClickListener(View.OnClickListener {

                if (show) {
                    imgEyeoff.setImageResource(R.drawable.eye)

                    edtConfirm11.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD or InputType.TYPE_CLASS_TEXT)
                    edtConfirm11.setSelection(edtConfirm11.text!!.length)

                    show = false
                } else {

                    viewDataBinding.imgEyeoff.setImageResource(R.drawable.hide)

                    edtConfirm11.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD or InputType.TYPE_CLASS_TEXT)
                    edtConfirm11.setSelection(edtConfirm11.text!!.length)
                    show = true
                }

            })


            txtForgotPassword.setOnClickListener(View.OnClickListener {

                val intent = Intent(this@LoginActivity, ForgotPasswordActivity::class.java)
                startActivity(intent)
            })


            txtRegister.setOnClickListener(View.OnClickListener {

                val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
                startActivity(intent)
                this@LoginActivity.finish()
            })

            btnLogin.setOnClickListener {


                /*  val signInBody = SignInBody("test@test.com", "12345")
                  Log.i("Haha", "done")
                  PaceApi.retrofitService.signIn(signInBody).enqueue(object : Callback<UserBody> {
                      override fun onFailure(call: Call<UserBody>, t: Throwable) {
                          Log.i("Haha", t.message.toString())
                      }

                      override fun onResponse(call: Call<UserBody>, response: Response<UserBody>) {
                          Log.i("Done", response.body().toString())
                      }
                  })*/


                if (edtConfirm111.text.isNullOrEmpty() || edtConfirm11.text.isNullOrEmpty()) {
                    showToast("Email or Password Field is empty")
                } else {
                    loginViewModel.login(
                        edtConfirm111.text.toString(),
                        edtConfirm11.text.toString()
                    )
//                    showLoader()
//                    val signInBody =
//                        SignInBody(edtConfirm111.text.toString(), edtConfirm11.text.toString())
//                    Log.i("Haha", "done")
//                    PaceApi.retrofitService.signIn(signInBody).enqueue(object : Callback<UserBody> {
//                        override fun onFailure(call: Call<UserBody>, t: Throwable) {
//                            Log.i("Haha", t.message.toString())
//                            hideLoader()
//                            showToast("Failed to connect")
//                        }
//
//                        override fun onResponse(
//                            call: Call<UserBody>,
//                            response: Response<UserBody>
//                        ) {
//                            if (response.isSuccessful) {
//                                showToast("Log in successful")
//                                Log.i("Done", response.body().toString())
//                                hideLoader()
//                                start(this@LoginActivity)
//                                finish()
//                            } else {
//                                showToast("Invalid Email or Password")
//                                hideLoader()
//                            }
//                        }
//                    })
                }
            }
        }
    }

    fun showLoader() {
        progress_bar.visibility = View.VISIBLE
        tv_login.visibility = View.INVISIBLE
    }

    fun hideLoader() {
        progress_bar.visibility = View.INVISIBLE
        tv_login.visibility = View.VISIBLE
    }

    fun showToast(message: String) {
        Toast.makeText(
            applicationContext,
            message,
            Toast.LENGTH_SHORT
        ).show()
    }

    fun setObservers(){
        with(loginViewModel){
            loginSuccessEvent.observe(this@LoginActivity, Observer {
                start(this@LoginActivity)
                finish()
            })
        }
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, NavigationActivity::class.java)
            context.startActivity(intent)
        }
    }
}
