package com.example.projectsetup.ui.navigation.fragment.account.registerproperty.agent.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import com.example.projectsetup.BR

import com.example.projectsetup.R
import com.example.projectsetup.base.BaseFragment
import com.example.projectsetup.databinding.AgentProfileFragmentBinding
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.agent.adapter.ProfileAdapter
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.agent.model.ProfileListModel
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.agent.viewModel.AgentProfileViewModel
import kotlinx.android.synthetic.main.agent_profile_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class AgentProfileFragment : BaseFragment<AgentProfileFragmentBinding, AgentProfileViewModel>() {

    private val agentProfileViewModel: AgentProfileViewModel by viewModel()
    override fun getLayoutId(): Int = R.layout.agent_profile_fragment

    override fun getViewModel(): AgentProfileViewModel = agentProfileViewModel
    override fun getBindingVariable(): Int {
        return BR.viewModel
    }


    companion object {
        val TAG = "Agent Profile Fragment"
        fun start(activity: FragmentActivity, containerId: Int) {
            val fragment = AgentProfileFragment()
            activity.supportFragmentManager.beginTransaction()
                .replace(containerId, fragment)
                .addToBackStack(TAG)
                .commit()

        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
        initView()
        setUpObservers()

    }

    private fun setUpRecyclerView() {
        val profileAdapter = ProfileAdapter()
        viewDataBinding.recyclerViewAgentProfile.adapter = profileAdapter

        var profileList = ArrayList<ProfileListModel>()

        profileList.add(
            ProfileListModel(
                "https://cdn.pixabay.com/photo/2019/08/28/14/24/tokyo-4436914_960_720.jpg",
                "3 chome 20th Ave",
                "Shiho city, BC Tokyo",
                "$2010000"
            )
        )
        profileList.add(
            ProfileListModel(
                "https://cdn.pixabay.com/photo/2016/09/15/02/17/skyscrapers-1670937__340.jpg",
                "3 chome 20th Ave",
                "Shiho city, BC Tokyo",
                "$2010000"
            )
        )
        profileList.add(
            ProfileListModel(
                "https://cdn.pixabay.com/photo/2015/11/06/12/22/byodo-in-1026877__340.jpg",
                "3 chome 20th Ave",
                "Shiho city, BC Tokyo",
                "$2010000"
            )
        )
        profileList.add(
            ProfileListModel(
                "https://cdn.pixabay.com/photo/2016/09/15/02/17/skyscrapers-1670937__340.jpg",
                "3 chome 20th Ave",
                "Shiho city, BC Tokyo",
                "$2010000"
            )
        )
        profileList.add(
            ProfileListModel(
                "https://cdn.pixabay.com/photo/2019/08/28/14/24/tokyo-4436914_960_720.jpg",
                "3 chome 20th Ave",
                "Shiho city, BC Tokyo",
                "$2010000"
            )
        )
        profileList.add(
            ProfileListModel(
                "https://cdn.pixabay.com/photo/2019/08/28/14/24/tokyo-4436914_960_720.jpg",
                "3 chome 20th Ave",
                "Shiho city, BC Tokyo",
                "$2010000"
            )
        )
        profileList.add(
            ProfileListModel(
                "https://cdn.pixabay.com/photo/2016/09/15/02/17/skyscrapers-1670937__340.jpg",
                "3 chome 20th Ave",
                "Shiho city, BC Tokyo",
                "$2010000"
            )
        )
        profileList.add(
            ProfileListModel(
                "https://cdn.pixabay.com/photo/2019/08/28/14/24/tokyo-4436914_960_720.jpg",
                "3 chome 20th Ave",
                "Shiho city, BC Tokyo",
                "$2010000"
            )
        )
        profileList.add(
            ProfileListModel(
                "https://cdn.pixabay.com/photo/2019/08/28/14/24/tokyo-4436914_960_720.jpg",
                "3 chome 20th Ave",
                "Shiho city, BC Tokyo",
                "$2010000"
            )
        )
        profileList.add(
            ProfileListModel(
                "https://cdn.pixabay.com/photo/2019/08/28/14/24/tokyo-4436914_960_720.jpg",
                "3 chome 20th Ave",
                "Shiho city, BC Tokyo",
                "$2010000"
            )
        )

        profileAdapter.addAll(profileList)
    }

    private fun setUpObservers() {
        with(agentProfileViewModel) {

            ivBackClickEvent.observe(viewLifecycleOwner, Observer {
                fragmentManager!!.popBackStack()
            })
        }
    }

    private fun initView() {


    }

}
