package com.example.projectsetup.ui.navigation.fragment.account


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import com.example.projectsetup.BR

import com.example.projectsetup.R
import com.example.projectsetup.base.BaseFragment
import com.example.projectsetup.databinding.FragmentAccountBinding
import com.example.projectsetup.ui.main.MainActivity
import com.example.projectsetup.ui.navigation.fragment.account.myProfile.activity.MyProfileActivity
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.RegisterPropertyRoomActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass.
 */
class AccountFragment : BaseFragment<FragmentAccountBinding, AccountFragmentViewModel>() {

    private val accountFragmentViewModel: AccountFragmentViewModel by viewModel()
    override fun getLayoutId(): Int = R.layout.fragment_account

    override fun getViewModel(): AccountFragmentViewModel = accountFragmentViewModel

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }


    private fun setUpObservers() {
        with(accountFragmentViewModel) {

            txtRegisterProperty.observe(viewLifecycleOwner, Observer {
                startActivity(
                    Intent(
                        activity,
                        RegisterPropertyRoomActivity::class.java
                    )
                )


            })
        }
    }

    private fun initView() {


        with(viewDataBinding) {
            txtLogoutMortgage.setOnClickListener(View.OnClickListener {
                preferenceManager.setIsLoggedIn(false)
                val intent = Intent(this@AccountFragment.activity, MainActivity::class.java)
                startActivity(intent)

                this@AccountFragment.activity!!.finish()

                this@AccountFragment.activity!!.finish()


            })

            txtProfile.setOnClickListener {
                val intent=Intent(this@AccountFragment.context,
                    MyProfileActivity::class.java)
                startActivity(intent)
            }


        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        setUpObservers()
    }

    companion object{
        val TAG="Account Fragment"
        fun start(activity: FragmentActivity,containerId:Int){
            val fragment= AccountFragment()
            activity.supportFragmentManager.beginTransaction()
                .replace(containerId,fragment)
                .addToBackStack(TAG)
                .commit()
        }

    }


}
