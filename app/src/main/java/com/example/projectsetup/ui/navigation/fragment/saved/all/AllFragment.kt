package com.example.projectsetup.ui.navigation.fragment.saved.all

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import com.example.projectsetup.BR
import com.example.projectsetup.R
import com.example.projectsetup.base.BaseFragment

import com.example.projectsetup.databinding.AllFragmentBinding
import com.example.projectsetup.databinding.AllFragmentBinding.inflate
import org.koin.androidx.viewmodel.ext.android.viewModel

class AllFragment : BaseFragment<AllFragmentBinding,AllViewModel>(){

    private val allViewModel:AllViewModel by viewModel()
    override fun getLayoutId(): Int = R.layout.all_fragment
    override fun getViewModel(): AllViewModel =allViewModel
    override fun getBindingVariable(): Int {
        return BR.viewModel
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        setUpObservers()
    }

    private fun setUpObservers() {
        with(allViewModel){
            clickedEvent.observe(viewLifecycleOwner, Observer {
                AllSavedFragment.start(activity!!,R.id.fragment_container1)
            })
        }
    }

    private fun initView() {
        with(viewDataBinding){

        }
    }
    companion object{

        val TAG=AllFragment::class.java.simpleName
        fun start(activity:FragmentActivity,containerId:Int){
            val fragment=AllFragment()
            activity.supportFragmentManager.beginTransaction()
                .addToBackStack(TAG)
                .replace(containerId,fragment)
                .commit()
        }
    }

}