package com.example.projectsetup.ui.navigation.fragment.saved


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import com.example.projectsetup.BR

import com.example.projectsetup.R
import com.example.projectsetup.base.BaseFragment
import com.example.projectsetup.databinding.FragmentSavedBinding
import com.example.projectsetup.databinding.FragmentSavedBinding.inflate
import com.example.projectsetup.ui.navigation.fragment.account.AccountFragment
import com.example.projectsetup.ui.navigation.fragment.saved.all.AllFragment
import com.example.projectsetup.ui.navigation.fragment.saved.forrent.ForRentFragment
import com.example.projectsetup.ui.navigation.fragment.saved.forsale.ForSaleFragment
import com.example.projectsetup.ui.navigation.fragment.saved.savedsearch.SavedSearchFragment
import kotlinx.android.synthetic.*
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass.
 */
class SavedFragment : BaseFragment<FragmentSavedBinding, SavedFragmentViewModel>() {

    private val savedFragmentViewModel: SavedFragmentViewModel by viewModel()
    override fun getLayoutId(): Int = R.layout.fragment_saved
    override fun getViewModel(): SavedFragmentViewModel = savedFragmentViewModel
    override fun getBindingVariable(): Int {
        return BR.viewModel
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewDataBinding = inflate(inflater, container, false)

        with(viewDataBinding) {
            if (savedInstanceState == null) {
                val fragment = AllFragment()
                val fragmentManager = activity!!.supportFragmentManager
                val fragmentTransaction = fragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.fragment_container1, fragment)
                fragmentTransaction.commit()


                all.setTextColor(resources.getColor(R.color.colorAccent))
                forRent.setTextColor(resources.getColor(R.color.saved))
                forSale.setTextColor(resources.getColor(R.color.saved))
                savedSearches.setTextColor(resources.getColor(R.color.saved))

                allLayoutUnderline.setBackgroundColor((resources.getColor(R.color.colorAccent)))
                forSaleLayoutUnderline.setBackgroundColor((resources.getColor(R.color.underline)))
                forRentLayoutUnderline.setBackgroundColor((resources.getColor(R.color.underline)))
                forSavedSearchLayoutUnderline.setBackgroundColor((resources.getColor(R.color.underline)))
            }
        }


        initView()

        return viewDataBinding.root
    }

    private fun initView() {

        with(viewDataBinding) {

            all.setOnClickListener {
                val fragment = AllFragment()
                val fragmentManager = activity!!.supportFragmentManager
                val fragmentTransaction = fragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.fragment_container1, fragment)
                fragmentTransaction.commit()
                clearFindViewByIdCache()

                all.setTextColor(resources.getColor(R.color.colorAccent))
                forRent.setTextColor(resources.getColor(R.color.saved))
                forSale.setTextColor(resources.getColor(R.color.saved))
                savedSearches.setTextColor(resources.getColor(R.color.saved))

                allLayoutUnderline.setBackgroundColor((resources.getColor(R.color.colorAccent)))
                forSaleLayoutUnderline.setBackgroundColor((resources.getColor(R.color.underline)))
                forRentLayoutUnderline.setBackgroundColor((resources.getColor(R.color.underline)))
                forSavedSearchLayoutUnderline.setBackgroundColor((resources.getColor(R.color.underline)))
            }

            forRent.setOnClickListener {
                val fragment =
                    ForRentFragment()
                val fragmentManager = activity!!.supportFragmentManager
                val fragmentTransaction = fragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.fragment_container1, fragment)
                fragmentTransaction.commit()
                clearFindViewByIdCache()

                all.setTextColor(resources.getColor(R.color.saved))
                forRent.setTextColor(resources.getColor(R.color.colorAccent))
                forSale.setTextColor(resources.getColor(R.color.saved))
                savedSearches.setTextColor(resources.getColor(R.color.saved))

                allLayoutUnderline.setBackgroundColor((resources.getColor(R.color.underline)))
                forSaleLayoutUnderline.setBackgroundColor((resources.getColor(R.color.underline)))
                forRentLayoutUnderline.setBackgroundColor((resources.getColor(R.color.colorAccent)))
                forSavedSearchLayoutUnderline.setBackgroundColor((resources.getColor(R.color.underline)))


            }


            forSale.setOnClickListener {
                val fragment =
                    ForSaleFragment()
                val fragmentManager = activity!!.supportFragmentManager
                val fragmentTransaction = fragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.fragment_container1, fragment)
                fragmentTransaction.commit()
                clearFindViewByIdCache()

                all.setTextColor(resources.getColor(R.color.saved))
                forRent.setTextColor(resources.getColor(R.color.saved))
                forSale.setTextColor(resources.getColor(R.color.colorAccent))
                savedSearches.setTextColor(resources.getColor(R.color.saved))

                allLayoutUnderline.setBackgroundColor((resources.getColor(R.color.underline)))
                forSaleLayoutUnderline.setBackgroundColor((resources.getColor(R.color.colorAccent)))
                forRentLayoutUnderline.setBackgroundColor((resources.getColor(R.color.underline)))
                forSavedSearchLayoutUnderline.setBackgroundColor((resources.getColor(R.color.underline)))


            }

            savedSearches.setOnClickListener {
                val fragment =
                    SavedSearchFragment()
                val fragmentManager = activity!!.supportFragmentManager
                val fragmentTransaction = fragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.fragment_container1, fragment)
                fragmentTransaction.commit()
                clearFindViewByIdCache()

                all.setTextColor(resources.getColor(R.color.saved))
                forRent.setTextColor(resources.getColor(R.color.saved))
                forSale.setTextColor(resources.getColor(R.color.saved))
                savedSearches.setTextColor(resources.getColor(R.color.colorAccent))

                allLayoutUnderline.setBackgroundColor((resources.getColor(R.color.underline)))
                forSaleLayoutUnderline.setBackgroundColor((resources.getColor(R.color.underline)))
                forRentLayoutUnderline.setBackgroundColor((resources.getColor(R.color.underline)))
                forSavedSearchLayoutUnderline.setBackgroundColor((resources.getColor(R.color.colorAccent)))


            }


        }


    }
    companion object{
        val TAG="Account Fragment"
        fun start(activity: FragmentActivity, containerId:Int){
            val fragment= SavedFragment()
            activity.supportFragmentManager.beginTransaction()
                .replace(containerId,fragment)
                .addToBackStack(TAG)
                .commit()
        }

    }

}
