package com.example.projectsetup.ui.welcomesplash.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.projectsetup.R
import com.example.projectsetup.databinding.FragmentIntroThirdFragmentBinding

/**
 * A simple [Fragment] subclass.
 */
class IntroThirdFragment : Fragment() {

    private lateinit var binding:FragmentIntroThirdFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       binding=FragmentIntroThirdFragmentBinding.inflate(inflater,container,false)
        return binding.root

    }


}
