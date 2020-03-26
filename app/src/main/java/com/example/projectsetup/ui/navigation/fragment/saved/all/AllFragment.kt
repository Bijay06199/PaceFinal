package com.example.projectsetup.ui.navigation.fragment.saved.all

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

    companion object {
        fun newInstance() = AllFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewDataBinding=inflate(inflater,container,false)

        return viewDataBinding.root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
       // viewModel = ViewModelProviders.of(this).get(AllViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
