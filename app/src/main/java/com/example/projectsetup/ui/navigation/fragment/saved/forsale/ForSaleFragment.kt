package com.example.projectsetup.ui.navigation.fragment.saved.forsale

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

import com.example.projectsetup.databinding.ForSaleFragmentBinding
import com.example.projectsetup.databinding.ForSaleFragmentBinding.inflate
import com.example.projectsetup.ui.navigation.fragment.saved.forrent.ForRentFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class ForSaleFragment : BaseFragment<ForSaleFragmentBinding,ForSaleViewModel>(){

    private val forSaleViewModel:ForSaleViewModel by viewModel()

    override fun getLayoutId(): Int = R.layout.for_sale_fragment
    override fun getViewModel(): ForSaleViewModel = forSaleViewModel
    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    companion object{

        val TAG= ForSaleFragment::class.java.simpleName
        fun start(activity: FragmentActivity, containerId:Int){
            val fragment= ForSaleFragment()
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
        with(forSaleViewModel){
            clickedEvent.observe(viewLifecycleOwner, Observer {
                ForSaleSavedFragment.start(activity!!,R.id.fragment_container1)
            })
        }
    }

}
