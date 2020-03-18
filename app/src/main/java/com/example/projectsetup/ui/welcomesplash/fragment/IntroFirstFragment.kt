package com.example.projectsetup.ui.welcomesplash.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.projectsetup.databinding.FragmentIntroFirstFragmentBinding


/**
 * A simple [Fragment] subclass.
 */
class IntroFirstFragment : Fragment() {

    lateinit var binding: FragmentIntroFirstFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       binding=FragmentIntroFirstFragmentBinding.inflate(inflater,container,false)
        return binding.root




    }


}
