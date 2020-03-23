package com.example.projectsetup.ui.navigation.fragment.account


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.example.projectsetup.R
import com.example.projectsetup.ui.main.MainActivity
import kotlinx.android.synthetic.main.fragment_account.*

/**
 * A simple [Fragment] subclass.
 */
class AccountFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view=inflater.inflate(R.layout.fragment_account, container, false)
        val txtlogoutMortgage=view.findViewById<TextView>(R.id.txtLogoutMortgage)


        txtlogoutMortgage.setOnClickListener(View.OnClickListener {

            val intent= Intent(this@AccountFragment.activity,MainActivity::class.java)
            startActivity(intent)
           this@AccountFragment.activity!!.finish()

        })
        return view


    }


}
