package com.example.projectsetup.ui.navigation.fragment.account.myProfile.activity

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.projectsetup.BR
import com.example.projectsetup.R
import com.example.projectsetup.base.BaseActivity
import com.example.projectsetup.databinding.ActivityMyProfileBinding
import com.example.projectsetup.ui.navigation.fragment.account.myProfile.activity.agent.AgentMyProfileActivity
import com.example.projectsetup.ui.navigation.fragment.account.myProfile.viewModel.MyProfileViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MyProfileActivity : BaseActivity<ActivityMyProfileBinding,MyProfileViewModel>() {

    override fun getLayoutId(): Int =R.layout.activity_my_profile
    private val myProfileViewModel:MyProfileViewModel by viewModel()
    override fun getViewModel(): MyProfileViewModel =myProfileViewModel
    override fun getBindingVariable(): Int {
        return BR.viewModel
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_my_profile)

        initView()
    }

    private fun initView() {
        with(myProfileViewModel){

            verifyClickedEvent.observe(this@MyProfileActivity, Observer {
                startActivity(Intent(this@MyProfileActivity,AccountVerificationActivity::class.java))
                finish()

            })

            backClickedEvent.observe(this@MyProfileActivity, Observer {
                finish()

            })

            btnAgentClicked.observe(this@MyProfileActivity, Observer {
                startActivity(Intent(this@MyProfileActivity,AgentMyProfileActivity::class.java))

            })

            btnAmbassadorClicked.observe(this@MyProfileActivity, Observer {

            })

            editClicked.observe(this@MyProfileActivity, Observer {
                startActivity(Intent(this@MyProfileActivity,EditProfileActivity::class.java))
                finish()

            })
        }
    }
}
