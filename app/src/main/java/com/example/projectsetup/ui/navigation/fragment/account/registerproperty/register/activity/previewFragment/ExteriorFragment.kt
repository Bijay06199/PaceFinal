package com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.activity.previewFragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.projectsetup.R

class ExteriorFragment : Fragment() {

    companion object {
        fun newInstance() = ExteriorFragment()
    }

    private lateinit var viewModel: ExteriorViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.exterior_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ExteriorViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
