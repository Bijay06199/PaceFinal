package com.example.projectsetup.ui.navigation.fragment.account.registerproperty.agent.fragment

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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

    var page = 1
     var isLoading = false
    val limit = 10
     lateinit var profileAdapter : ProfileAdapter
    lateinit var layoutManager:LinearLayoutManager

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
        layoutManager= LinearLayoutManager(context)
        profileAdapter=ProfileAdapter()
        viewDataBinding.recyclerViewAgentProfile.adapter = profileAdapter
         viewDataBinding.recyclerViewAgentProfile.addOnScrollListener(object :RecyclerView.OnScrollListener(){

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val visibleItemCount=layoutManager.childCount
                val pastVisibleItem=layoutManager.findFirstCompletelyVisibleItemPosition()
                val total=profileAdapter.itemCount

                if(!isLoading){
                    if((visibleItemCount+pastVisibleItem)>=total){
                        page++
                        getItems()
                    }
                }
                super.onScrolled(recyclerView, dx, dy)
            }
        })
    }

    fun getItems() {
        isLoading=true
        viewDataBinding.progressBar.visibility=View.VISIBLE
        var profileList=ArrayList<ProfileListModel>()


        val start = (page - 1) * limit
        val end = (page) * limit

        for (i in start..end) {
            profileList.add(
                ProfileListModel(
                    "https://cdn.pixabay.com/photo/2020/03/18/06/06/street-4942809__340.jpg",
                    "3 chome 20th Ave",
                    "Shiho city",
                    "Tokyo"
                )
            )
            profileAdapter.notifyItemInserted(profileList.size)
        }

        Handler().postDelayed({
            if(::profileAdapter.isInitialized){
                profileAdapter.notifyDataSetChanged()
            }else{
                profileAdapter=ProfileAdapter()
                viewDataBinding.recyclerViewAgentProfile.adapter=profileAdapter
            }
            profileAdapter.addAll(profileList)
            isLoading=false
            viewDataBinding.progressBar.visibility=View.GONE
        },3000)



    }

    private fun setUpObservers() {
        with(agentProfileViewModel) {

            ivBackClickEvent.observe(viewLifecycleOwner, Observer {
                fragmentManager!!.popBackStack()
            })
        }
    }

    private fun initView() {

        getItems()

    }

}
