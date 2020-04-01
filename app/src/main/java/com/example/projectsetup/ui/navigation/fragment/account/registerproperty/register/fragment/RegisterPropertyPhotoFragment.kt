package com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import com.example.projectsetup.BR
import com.example.projectsetup.R
import com.example.projectsetup.base.BaseFragment
import com.example.projectsetup.databinding.FragmentRegisterPropertyPhotoBinding
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.viewModel.RegisterPropertyPhotoViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterPropertyPhotoFragment
    : BaseFragment<FragmentRegisterPropertyPhotoBinding, RegisterPropertyPhotoViewModel>() {

    private val registerPropertyPhotoViewModel: RegisterPropertyPhotoViewModel by viewModel()

    override fun getLayoutId(): Int = R.layout.fragment_register_property_photo
    override fun getViewModel(): RegisterPropertyPhotoViewModel = registerPropertyPhotoViewModel
    override fun getBindingVariable(): Int {
        return BR.viewModel
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        setUpObservers()
    }

    private fun setUpObservers() {

        with(registerPropertyPhotoViewModel) {

            btnNextClicked.observe(viewLifecycleOwner, Observer {

                RegisterPropertyDescriptionFragment.start(activity!!,R.id.container_register_property)

            })

            ivBackClicked.observe(viewLifecycleOwner, Observer {
                fragmentManager!!.popBackStack()

            })

        }

    }

    private fun initView() {

    }

    companion object {
        val TAG = "RegisterPropertyRelationship Fragment"
        fun start(activity: FragmentActivity, containerId: Int) {
            val fragment = RegisterPropertyPhotoFragment()
            activity.supportFragmentManager.beginTransaction()
                .replace(containerId,fragment)
                .addToBackStack(TAG)
                .commit()

        }

    }
}