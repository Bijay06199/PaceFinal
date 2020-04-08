package com.example.projectsetup.ui.navigation.fragment.account.myProfile.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.projectsetup.BR
import com.example.projectsetup.R
import com.example.projectsetup.base.BaseActivity
import com.example.projectsetup.databinding.ActivityAccountVerificationBinding
import com.example.projectsetup.ui.navigation.fragment.account.myProfile.viewModel.AccountVerificationViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class AccountVerificationActivity : BaseActivity<ActivityAccountVerificationBinding,AccountVerificationViewModel>() {

    override fun getLayoutId(): Int =R.layout.activity_account_verification
    private val accountVerificationViewModel:AccountVerificationViewModel by viewModel()
    override fun getViewModel(): AccountVerificationViewModel =accountVerificationViewModel
    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_account_verification)
        initView()
        setUpObservers()
    }

    private fun initView() {

    }

    private fun setUpObservers() {
        with(accountVerificationViewModel){
            backClickedEvent.observe(this@AccountVerificationActivity, Observer {
                startActivity(Intent(this@AccountVerificationActivity,MyProfileActivity::class.java))
                finish()
            })

            idClickedEvent.observe(this@AccountVerificationActivity, Observer {
                startActivity(Intent(this@AccountVerificationActivity,IdVerificationActivity::class.java))
                finish()
            })

            mobileClickedEvent.observe(this@AccountVerificationActivity, Observer {
                startActivity(Intent(this@AccountVerificationActivity,MobileVerificationActivity::class.java))
                finish()
            })

            emailClickedEvent.observe(this@AccountVerificationActivity, Observer {
                startActivity(Intent(this@AccountVerificationActivity,EmailVerificationActivity::class.java))
                finish()
            })
        }

    }
}
