package com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.projectsetup.BR
import com.example.projectsetup.R
import com.example.projectsetup.base.BaseActivity
import com.example.projectsetup.databinding.ActivityRegisterPropertyPhotoBinding
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.viewModel.RegisterPropertyPhotoViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterPropertyPhotoActivity
    : BaseActivity<ActivityRegisterPropertyPhotoBinding, RegisterPropertyPhotoViewModel>() {

    private val registerPropertyPhotoViewModel: RegisterPropertyPhotoViewModel by viewModel()

    override fun getLayoutId(): Int = R.layout.activity_register_property_photo
    override fun getViewModel(): RegisterPropertyPhotoViewModel = registerPropertyPhotoViewModel
    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initView()
        setUpObservers()

    }

    private fun setUpObservers() {

        with(registerPropertyPhotoViewModel) {

            btnNextClicked.observe(this@RegisterPropertyPhotoActivity, Observer {
                startActivity(
                    Intent(
                        this@RegisterPropertyPhotoActivity,
                        RegisterPropertyDescriptionActivity::class.java
                    )
                )
            })

            ivBackClicked.observe(this@RegisterPropertyPhotoActivity, Observer {
                startActivity(
                    Intent(
                        this@RegisterPropertyPhotoActivity,
                        RegisterPropertyConditionActivity::class.java
                    )
                )
            })

        }

    }

    private fun initView() {

    }
}
