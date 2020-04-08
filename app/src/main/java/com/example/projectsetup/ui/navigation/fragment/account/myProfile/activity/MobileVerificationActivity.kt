package com.example.projectsetup.ui.navigation.fragment.account.myProfile.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.projectsetup.BR
import com.example.projectsetup.R
import com.example.projectsetup.base.BaseActivity
import com.example.projectsetup.databinding.ActivityMobileVerificationBinding
import com.example.projectsetup.ui.navigation.fragment.account.myProfile.viewModel.MobileVerificationViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MobileVerificationActivity :BaseActivity<ActivityMobileVerificationBinding,MobileVerificationViewModel>() {
    override fun getLayoutId(): Int=R.layout.activity_mobile_verification
    private val mobileVerificationViewModel:MobileVerificationViewModel by viewModel()
    override fun getViewModel(): MobileVerificationViewModel =mobileVerificationViewModel
    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  setContentView(R.layout.activity_mobile_verification)
        setUpObservers()
    }

    private fun setUpObservers() {
        with(mobileVerificationViewModel){
            backClickedEvent.observe(this@MobileVerificationActivity, Observer {
                startActivity(Intent(this@MobileVerificationActivity,AccountVerificationActivity::class.java))
                finish()
            })
        }
    }
}
