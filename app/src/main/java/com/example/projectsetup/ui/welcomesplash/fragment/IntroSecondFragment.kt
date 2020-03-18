package com.example.projectsetup.ui.welcomesplash.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.projectsetup.R
import com.example.projectsetup.databinding.FragmentIntroFirstFragmentBinding
import com.example.projectsetup.databinding.FragmentIntroSecondFragmentBinding

/**
 * A simple [Fragment] subclass.
 */
class IntroSecondFragment : Fragment() {

    private lateinit var binding: FragmentIntroSecondFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       binding=FragmentIntroSecondFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }


}
