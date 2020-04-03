package com.example.projectsetup.ui.navigation.fragment.saved.savedsearch

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

import com.example.projectsetup.databinding.SavedSearchFragmentBinding
import com.example.projectsetup.databinding.SavedSearchFragmentBinding.inflate
import com.example.projectsetup.ui.navigation.fragment.saved.forrent.ForRentFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class SavedSearchFragment : BaseFragment<SavedSearchFragmentBinding,SavedSearchViewModel>() {

    private val savedSearchViewModel:SavedSearchViewModel by viewModel()
    override fun getLayoutId(): Int = R.layout.saved_search_fragment
    override fun getViewModel(): SavedSearchViewModel =savedSearchViewModel
    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    companion object {

        val TAG = SavedSearchFragment::class.java.simpleName
        fun start(activity: FragmentActivity, containerId: Int) {
            val fragment = SavedSearchFragment()
            activity.supportFragmentManager.beginTransaction()
                .addToBackStack(TAG)
                .replace(containerId, fragment)
                .commit()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpObservers()
    }

    private fun setUpObservers() {
        with(savedSearchViewModel){
            clickedEvent.observe(viewLifecycleOwner, Observer {
                SavedSearchSavedFragment.start(activity!!,R.id.fragment_container1)
            })
        }
    }

}
