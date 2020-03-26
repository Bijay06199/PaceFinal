package com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.activity.previewFragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.projectsetup.R

class BedRoomFragment : Fragment() {

    companion object {
        fun newInstance() = BedRoomFragment()
    }

    private lateinit var viewModel: BedRoomViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bed_room_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(BedRoomViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
