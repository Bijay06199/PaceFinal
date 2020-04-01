package com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.graphics.createBitmap
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import com.example.projectsetup.BR
import com.example.projectsetup.R
import com.example.projectsetup.base.BaseFragment
import com.example.projectsetup.databinding.FragmentRegisterMyPropertyBinding
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.activity.RegisterPropertyActivity
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.adapter.MyPropertyAdapter
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.models.PropertyItemsModel
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.viewModel.RegisterMyPropertyViewModel
import kotlinx.android.synthetic.main.fragment_register_my_property.*
import kotlinx.android.synthetic.main.my_property_recyclerview.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterMyPropertyFragment :
    BaseFragment<FragmentRegisterMyPropertyBinding, RegisterMyPropertyViewModel>(),
    MyPropertyAdapter.OnItemClickListener {

    lateinit var propertyAdapter: MyPropertyAdapter

    override fun onItemClicked(position: Int, property: PropertyItemsModel) {

        Toast.makeText(context, "kmkmompo,", Toast.LENGTH_SHORT).show()

    }

    private val registerMyPropertyViewModel: RegisterMyPropertyViewModel by viewModel()

    override fun getLayoutId(): Int = R.layout.fragment_register_my_property
    override fun getViewModel(): RegisterMyPropertyViewModel = registerMyPropertyViewModel

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        setUpObservers()
        setRecyclerView()

    }

    private fun setRecyclerView() {

        propertyAdapter = MyPropertyAdapter(this)
        viewDataBinding.recyclerViewMyProperty.adapter = propertyAdapter

        var propertyList = ArrayList<PropertyItemsModel>()

        propertyList.add(
            PropertyItemsModel(
                "https://cdn.pixabay.com/photo/2016/11/18/14/50/boat-1835081_960_720.jpg",
                "450 W 20th Ave",
                "Shiho city BC",
                "$23,0000"
            )
        )
        propertyList.add(
            PropertyItemsModel(
                "https://cdn.pixabay.com/photo/2013/11/25/09/47/japan-217878_960_720.jpg",
                "450 W 20th Ave",
                "Shiho city BC",
                "$23,0000"
            )
        )
        propertyList.add(
            PropertyItemsModel(
                "https://cdn.pixabay.com/photo/2016/11/18/14/50/boat-1835081_960_720.jpg",
                "450 W 20th Ave",
                "Shiho city BC",
                "$23,0000"
            )
        )
        propertyList.add(
            PropertyItemsModel(
                "https://cdn.pixabay.com/photo/2016/11/18/14/50/boat-1835081_960_720.jpg",
                "450 W 20th Ave",
                "Shiho city BC",
                "$23,0000"
            )
        )
        propertyList.add(
            PropertyItemsModel(
                "https://cdn.pixabay.com/photo/2015/02/15/03/03/yamaga-city-636865__340.jpg",
                "450 W 20th Ave",
                "Shiho city BC",
                "$23,0000"
            )
        )
        propertyList.add(
            PropertyItemsModel(
                "https://cdn.pixabay.com/photo/2016/11/18/14/50/boat-1835081_960_720.jpg",
                "450 W 20th Ave",
                "Shiho city BC",
                "$23,0000"
            )
        )
        propertyList.add(
            PropertyItemsModel(
                "https://cdn.pixabay.com/photo/2016/11/18/14/50/boat-1835081_960_720.jpg",
                "450 W 20th Ave",
                "Shiho city BC",
                "$23,0000"
            )
        )

        propertyAdapter.addAll(propertyList)


    }


    private fun initView() {


    }

    private fun setUpObservers() {


        with(registerMyPropertyViewModel) {

            ivBackClickedEvent.observe(viewLifecycleOwner, Observer {
                activity?.finish()
            })
        }
    }

    companion object {
        val TAG = RegisterMyPropertyFragment::class.java.simpleName
        fun start(activity: FragmentActivity, containerId: Int) {
            val fragment = RegisterMyPropertyFragment()
            activity.supportFragmentManager.beginTransaction()
                .replace(containerId, fragment)
                .addToBackStack(TAG)
                .commit()

        }

    }
}