package com.example.projectsetup.ui.navigation.fragment.account.registerproperty.agent.fragment


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import com.example.projectsetup.BR
import com.example.projectsetup.R
import com.example.projectsetup.base.BaseFragment
import com.example.projectsetup.databinding.FragmentFindAgentAreaBinding
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.RegisterPropertyRoomActivity
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.agent.viewModel.FindAgentByAreaFragmentViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass.
 */
class FindAgentByAreaFragment : BaseFragment<FragmentFindAgentAreaBinding,FindAgentByAreaFragmentViewModel>() {
    private val findAgentByAreaFragmentViewModel: FindAgentByAreaFragmentViewModel by viewModel()
    override fun getLayoutId(): Int = R.layout.fragment_find_agent_area
    override fun getViewModel(): FindAgentByAreaFragmentViewModel = findAgentByAreaFragmentViewModel
    override fun getBindingVariable(): Int {
        return BR.viewModel
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        setUpObservers()
    }

    private fun setUpObservers() {
        with(findAgentByAreaFragmentViewModel){
            iconNextClicked.observe(viewLifecycleOwner, Observer {
                FindAgentByAddressFragment.start(activity!!,R.id.container_agent)
            })

            ivBackClicked.observe(viewLifecycleOwner, Observer {
                startActivity(Intent(this@FindAgentByAreaFragment.activity,RegisterPropertyRoomActivity::class.java))
            })

        }
    }

    private fun initView() {

    }

    companion object{
        val TAG="Account Fragment"
        fun start(activity: FragmentActivity, containerId:Int){
            val fragment= FindAgentByAreaFragment()
            activity.supportFragmentManager.beginTransaction()
                .replace(containerId,fragment)
                .addToBackStack(TAG)
                .commit()
        }

    }

}
