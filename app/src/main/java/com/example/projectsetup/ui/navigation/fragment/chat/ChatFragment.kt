package com.example.projectsetup.ui.navigation.fragment.chat


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity

import com.example.projectsetup.R
import com.example.projectsetup.base.BaseFragment
import com.example.projectsetup.databinding.FragmentChatBinding
import com.example.projectsetup.databinding.FragmentChatBinding.inflate
import com.example.projectsetup.ui.navigation.fragment.account.AccountFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass.
 */
class ChatFragment : BaseFragment<FragmentChatBinding,ChatFragmentViewModel>() {
    private val chatFragmentViewModel:ChatFragmentViewModel by viewModel()
    override fun getLayoutId(): Int =R.layout.fragment_chat
    override fun getViewModel(): ChatFragmentViewModel =chatFragmentViewModel

//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        viewDataBinding=inflate(inflater,container,false)
//        return viewDataBinding.root
//
//    }

    private fun initView() {

    }

    private fun setUpObservers() {

    }
    companion object{
        val TAG="Account Fragment"
        fun start(activity: FragmentActivity, containerId:Int){
            val fragment= ChatFragment()
            activity.supportFragmentManager.beginTransaction()
                .replace(containerId,fragment)
                .addToBackStack(TAG)
                .commit()
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        setUpObservers()
    }

}
