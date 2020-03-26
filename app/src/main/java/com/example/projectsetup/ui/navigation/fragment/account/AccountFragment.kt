package com.example.projectsetup.ui.navigation.fragment.account


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import com.example.projectsetup.BR

import com.example.projectsetup.R
import com.example.projectsetup.base.BaseFragment
import com.example.projectsetup.data.prefs.PreferenceManager
import com.example.projectsetup.databinding.FragmentAccountBinding
import com.example.projectsetup.databinding.FragmentAccountBinding.inflate
import com.example.projectsetup.ui.main.MainActivity
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.RegisterPropertyRoomActivity
import kotlinx.android.synthetic.main.fragment_account.*
import org.koin.android.ext.android.inject
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


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        viewDataBinding = inflate(inflater, container, false)

        initView()
      // setUpObservers()
        return viewDataBinding.root


    }

    private fun setUpObservers() {
        with(accountFragmentViewModel) {

            txtRegisterProperty.observe(viewLifecycleOwner, Observer {
                startActivity(
                    Intent(
                        this@AccountFragment.activity,
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

            tvRegisterProperty.setOnClickListener(View.OnClickListener {
                startActivity(Intent(this@AccountFragment.activity,RegisterPropertyRoomActivity::class.java))
            })


        }

    }


}
