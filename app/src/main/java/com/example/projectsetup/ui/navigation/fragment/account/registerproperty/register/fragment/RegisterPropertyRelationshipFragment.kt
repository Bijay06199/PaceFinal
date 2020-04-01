package com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import com.example.projectsetup.R
import com.example.projectsetup.base.BaseFragment
import com.example.projectsetup.databinding.FragmentRegisterPropertyRelationshipBinding
import com.example.projectsetup.databinding.FragmentRegisterPropertyWantBinding
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.RegisterPropertyRoomActivity
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.agent.fragment.AgentProfileFragment
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.viewModel.RegisterPropertyRelationshipViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass.
 */
class RegisterPropertyRelationshipFragment : BaseFragment<FragmentRegisterPropertyRelationshipBinding,RegisterPropertyRelationshipViewModel>() {
    override fun getLayoutId(): Int = R.layout.fragment_register_property_relationship
    private val registerPropertyRelationShipViewModel: RegisterPropertyRelationshipViewModel by viewModel()
    override fun getViewModel(): RegisterPropertyRelationshipViewModel =
        registerPropertyRelationShipViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        setUpObservers()

    }

    private fun initView() {

    }

    private fun setUpObservers() {
        with(registerPropertyRelationShipViewModel){
            btnNextClickedEvent.observe(viewLifecycleOwner, Observer {
                RegisterPropertyChooseFragment.start(activity!!,R.id.container_register_property)
            })

            ivBackEvent.observe(viewLifecycleOwner, Observer {
              RegisterPropertyRoomActivity.getInstance(context!!)
            })
        }


    }

    companion object {
        val TAG = "RegisterPropertyRelationship Fragment"
        fun start(activity: FragmentActivity, containerId: Int) {
            val fragment = RegisterPropertyRelationshipFragment()
            activity.supportFragmentManager.beginTransaction()
                .replace(containerId, fragment)
                .addToBackStack(TAG)
                .commit()

        }

    }
}

