package com.example.projectsetup.ui.navigation.fragment.saved.forsale

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import com.example.projectsetup.BR

import com.example.projectsetup.R
import com.example.projectsetup.base.BaseFragment
import com.example.projectsetup.databinding.ForSaleSavedFragmentBinding
import com.example.projectsetup.databinding.ForSaleSavedFragmentBinding.inflate
import com.example.projectsetup.ui.navigation.fragment.saved.forrent.ForRentFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class ForSaleSavedFragment : BaseFragment<ForSaleSavedFragmentBinding,ForSaleSavedViewModel>() {

    private val forSaleSavedViewModel:ForSaleSavedViewModel by viewModel()
    override fun getLayoutId(): Int =R.layout.for_sale_saved_fragment
    override fun getViewModel(): ForSaleSavedViewModel = forSaleSavedViewModel
    override fun getBindingVariable(): Int {
       return BR.viewModel
    }

    companion object{

        val TAG= ForSaleSavedFragment::class.java.simpleName
        fun start(activity: FragmentActivity, containerId:Int){
            val fragment= ForSaleSavedFragment()
            activity.supportFragmentManager.beginTransaction()
                .addToBackStack(TAG)
                .replace(containerId,fragment)
                .commit()
        }
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       viewDataBinding=inflate(inflater,container,false)
        return viewDataBinding.root
    }



}
