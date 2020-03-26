package com.example.projectsetup.base


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.projectsetup.BR

import com.example.projectsetup.R
import com.example.projectsetup.data.prefs.PreferenceManager
import com.example.projectsetup.utils.extentions.setupUI
import kotlinx.android.synthetic.main.activity_navigation.*
import org.koin.android.ext.android.inject

/**
 * A simple [Fragment] subclass.
 */
abstract class BaseFragment<DATA_BINDING:ViewDataBinding,VIEW_MODEL:BaseViewModel> : Fragment() {

    lateinit var viewDataBinding:DATA_BINDING
    var baseViewModel:VIEW_MODEL?=null
     val preferenceManager: PreferenceManager by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       // val v= inflater.inflate(getLayoutId(), container, false)

        performDataBinding(layoutInflater,container)
//        initObservers()

        return viewDataBinding.root
    }

     private fun performDataBinding(layoutInflater: LayoutInflater,container: ViewGroup?){

         viewDataBinding=DataBindingUtil.inflate(layoutInflater,getLayoutId(),container,false)
         this.baseViewModel=baseViewModel?:getViewModel()
         viewDataBinding.apply {
             setVariable(getBindingVariable(),baseViewModel)
             setLifecycleOwner (viewLifecycleOwner)
             executePendingBindings()
         }
         activity?.setupUI(viewDataBinding.root)

     }
    open fun getBindingVariable(): Int = BR.viewModel
    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun getViewModel(): VIEW_MODEL

}
