package com.example.projectsetup.ui.navigation.fragment.saved.forrent

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

import com.example.projectsetup.databinding.ForRentFragmentBinding
import com.example.projectsetup.databinding.ForRentFragmentBinding.inflate
import com.example.projectsetup.ui.navigation.fragment.saved.all.AllFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class ForRentFragment : BaseFragment<ForRentFragmentBinding,ForRentViewModel>() {

    private val forRentViewModel:ForRentViewModel by viewModel()
    override fun getLayoutId(): Int = R.layout.for_rent_fragment
    override fun getViewModel(): ForRentViewModel =forRentViewModel

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    companion object{

        val TAG= ForRentFragment::class.java.simpleName
        fun start(activity: FragmentActivity, containerId:Int){
            val fragment= ForRentFragment()
            activity.supportFragmentManager.beginTransaction()
                .addToBackStack(TAG)
                .replace(containerId,fragment)
                .commit()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpObservers()
    }

    private fun setUpObservers() {
        with(forRentViewModel){

            clickedEvent.observe(viewLifecycleOwner, Observer {
                ForRentSavedFragment.start(activity!!,R.id.fragment_container1)
            })
        }
    }

}


