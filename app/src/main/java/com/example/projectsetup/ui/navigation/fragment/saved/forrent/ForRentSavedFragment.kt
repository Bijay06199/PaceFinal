package com.example.projectsetup.ui.navigation.fragment.saved.forrent

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity

import com.example.projectsetup.R
import com.example.projectsetup.base.BaseFragment
import com.example.projectsetup.databinding.ForRentSavedFragmentBinding
import com.example.projectsetup.databinding.ForRentSavedFragmentBinding.inflate
import com.example.projectsetup.ui.navigation.fragment.saved.all.AllSavedFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class ForRentSavedFragment : BaseFragment<ForRentSavedFragmentBinding,ForRentSavedViewModel>() {
    private val forRentSavedViewModel:ForRentSavedViewModel by viewModel()
    override fun getLayoutId(): Int =R.layout.for_rent_saved_fragment
    override fun getViewModel(): ForRentSavedViewModel =forRentSavedViewModel

    companion object{

        val TAG= ForRentSavedFragment::class.java.simpleName
        fun start(activity: FragmentActivity, containerId:Int){
            val fragment= ForRentSavedFragment()
            activity.supportFragmentManager.beginTransaction()
                .addToBackStack(TAG)
                .replace(containerId,fragment)
                .commit()
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }



}
