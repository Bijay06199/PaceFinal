package com.example.projectsetup.ui.navigation.fragment.account.myProfile.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.projectsetup.R
import com.example.projectsetup.base.BaseActivity
import com.example.projectsetup.databinding.ActivityEmailVerificationBinding
import com.example.projectsetup.ui.navigation.fragment.account.myProfile.viewModel.EmailVerificationViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class EmailVerificationActivity : BaseActivity<ActivityEmailVerificationBinding,EmailVerificationViewModel>() {
    override fun getLayoutId(): Int =R.layout.activity_email_verification
    private val emailVerificationViewModel:EmailVerificationViewModel by viewModel()
    override fun getViewModel(): EmailVerificationViewModel =emailVerificationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_email_verification)
        setUpObservers()
    }

    private fun setUpObservers() {
        with(emailVerificationViewModel){
            backClickedEvent.observe(this@EmailVerificationActivity, Observer {
                startActivity(Intent(this@EmailVerificationActivity,AccountVerificationActivity::class.java))
                finish()
            })
        }
    }
}
