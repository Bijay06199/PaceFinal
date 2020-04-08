package com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.PopupWindow
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.transition.TransitionManager
import com.example.projectsetup.BR
import com.example.projectsetup.base.BaseFragment
import com.example.projectsetup.databinding.FragmentRegisterPropertyPreviewBinding
import com.example.projectsetup.ui.Adapter.ViewPagerAdapter
import com.example.projectsetup.ui.Adapter.ViewPagerListener
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.activity.previewFragment.BedRoomFragment
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.activity.previewFragment.ExteriorFragment
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.activity.previewFragment.LayoutFragment
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.viewModel.RegisterPropertyPreviewViewModel
import kotlinx.android.synthetic.main.fragment_register_property_preview.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class RegisterPropertyPreviewFragment
    : BaseFragment<FragmentRegisterPropertyPreviewBinding, RegisterPropertyPreviewViewModel>() {
    var counter: Int = 0


    private lateinit var pagerAdapterView: ViewPagerAdapter
    private val registerPropertyPreviewViewModel: RegisterPropertyPreviewViewModel by viewModel()

    override fun getLayoutId(): Int =
        com.example.projectsetup.R.layout.fragment_register_property_preview

    override fun getViewModel(): RegisterPropertyPreviewViewModel = registerPropertyPreviewViewModel
    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (savedInstanceState == null) {
            with(viewDataBinding) {
                ExteriorFragment.start(activity!!, com.example.projectsetup.R.id.saleContainer)
                imgExterior.visibility = View.VISIBLE
                imgLayout.visibility = View.INVISIBLE
                imgBedroom.visibility = View.INVISIBLE
                imgBathroom.visibility = View.INVISIBLE
                imgLivingRoom.visibility = View.INVISIBLE
                imgLivingRoom11.visibility = View.INVISIBLE

            }


        }
        pagerAdapterView = ViewPagerAdapter(fragmentManager!!)
        addPagerFragments()
        viewDataBinding.myViewPager1?.adapter = pagerAdapterView
        // myViewPager1?.setPageTransformer(true, this::zoomOutTransformation)
        viewDataBinding.myViewPager1?.addOnPageChangeListener(ViewPagerListener(this::onPageSelected))
        initView()
        setUpObservers()
        initPopUpWindow()
    }


    private fun initPopUpWindow() {

        btn_register_property.setOnClickListener(View.OnClickListener {
            val view = LayoutInflater.from(activity)
                .inflate(com.example.projectsetup.R.layout.popup_layout, null)
            overlap.setBackgroundColor(resources.getColor(com.example.projectsetup.R.color.TRANSPARENT))

            val popupWindow = PopupWindow(
                view, // Custom view to show in popup window
                LinearLayout.LayoutParams.MATCH_PARENT, // Width of popup window
                LinearLayout.LayoutParams.WRAP_CONTENT // Window height

            )

            popupWindow.height = 700
            popupWindow.elevation = 10.0F

            popupWindow.animationStyle = com.example.projectsetup.R.anim.slide_in_left

            popupWindow.isTouchable = true

            popupWindow.isOutsideTouchable = true

            val handler = Handler()
            handler.postDelayed(object : Runnable {

                public override fun run() {
                    //ToDo your function
                    //hide your popup here
                    popupWindow.dismiss()
                }
            }, 1500)

            popupWindow.setOnDismissListener(PopupWindow.OnDismissListener {


                btn_register_property.setBackgroundColor(resources.getColor(com.example.projectsetup.R.color.transparentpop))
                RegisterMyPropertyFragment.start(
                    activity!!,
                    com.example.projectsetup.R.id.container_register_property
                )


            })



            TransitionManager.beginDelayedTransition(relativelayout1)
            popupWindow.showAtLocation(
                relativelayout1, // Location to display popup window
                Gravity.CENTER, // Exact position of layout to display popup
                0, // X offset
                0 // Y offset
            )


        })

    }

    private fun setUpObservers() {

        with(registerPropertyPreviewViewModel) {
            ivBackClickedEvent.observe(viewLifecycleOwner, Observer {
                fragmentManager!!.popBackStack()
            })
        }

    }

    private fun initView() {

        with(viewDataBinding) {

            txtRoute.setOnClickListener(View.OnClickListener {

                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps")))

            })
            txtExterior.setOnClickListener(View.OnClickListener {
                ExteriorFragment.start(activity!!, com.example.projectsetup.R.id.saleContainer)
                imgExterior.visibility = View.VISIBLE
                imgLayout.visibility = View.INVISIBLE
                imgBedroom.visibility = View.INVISIBLE
                imgBathroom.visibility = View.INVISIBLE
                imgLivingRoom.visibility = View.INVISIBLE
                imgLivingRoom11.visibility = View.INVISIBLE
            })


            txtLayout.setOnClickListener(View.OnClickListener {
                LayoutFragment.start(activity!!, com.example.projectsetup.R.id.saleContainer)

                imgLayout.visibility = View.VISIBLE
                imgExterior.visibility = View.INVISIBLE
                imgBedroom.visibility = View.INVISIBLE
                imgBathroom.visibility = View.INVISIBLE
                imgLivingRoom.visibility = View.INVISIBLE
                imgLivingRoom11.visibility = View.INVISIBLE
            })


            txtBedroom.setOnClickListener(View.OnClickListener {
                BedRoomFragment.start(activity!!, com.example.projectsetup.R.id.saleContainer)
                imgBedroom.visibility = View.VISIBLE
                imgLayout.visibility = View.INVISIBLE
                imgExterior.visibility = View.INVISIBLE
                imgBathroom.visibility = View.INVISIBLE
                imgLivingRoom.visibility = View.INVISIBLE
                imgLivingRoom11.visibility = View.INVISIBLE
            })


        }

    }

    private fun onPageSelected(position: Int) {
        when (position) {
            0 -> {
                viewDataBinding.imgExterior.visibility = View.VISIBLE
                viewDataBinding.imgLayout.visibility = View.INVISIBLE
                viewDataBinding.imgBedroom.visibility = View.INVISIBLE
                viewDataBinding.imgBathroom.visibility = View.INVISIBLE
                viewDataBinding.imgLivingRoom.visibility = View.INVISIBLE
                viewDataBinding.imgLivingRoom11.visibility = View.INVISIBLE
                ExteriorFragment.start(activity!!, com.example.projectsetup.R.id.saleContainer)
            }
            1 -> {
                viewDataBinding.imgLayout.visibility = View.VISIBLE
                viewDataBinding.imgExterior.visibility = View.INVISIBLE
                viewDataBinding.imgBedroom.visibility = View.INVISIBLE
                viewDataBinding.imgBathroom.visibility = View.INVISIBLE
                viewDataBinding.imgLivingRoom.visibility = View.INVISIBLE
                viewDataBinding.imgLivingRoom11.visibility = View.INVISIBLE
                LayoutFragment.start(activity!!, com.example.projectsetup.R.id.saleContainer)
            }
            2 -> {
                viewDataBinding.imgBedroom.visibility = View.VISIBLE
                viewDataBinding.imgLayout.visibility = View.INVISIBLE
                viewDataBinding.imgExterior.visibility = View.INVISIBLE
                viewDataBinding.imgBathroom.visibility = View.INVISIBLE
                viewDataBinding.imgLivingRoom.visibility = View.INVISIBLE
                viewDataBinding.imgLivingRoom11.visibility = View.INVISIBLE
                BedRoomFragment.start(activity!!, com.example.projectsetup.R.id.saleContainer)

            }
        }
    }


    private fun addPagerFragments() {
        pagerAdapterView.addFragments(ExteriorFragment())
        pagerAdapterView.addFragments(LayoutFragment())
        pagerAdapterView.addFragments(BedRoomFragment())
    }

    companion object {
        val TAG = RegisterPropertyPreviewFragment::class.java.simpleName
        fun start(activity: FragmentActivity, containerId: Int) {
            val fragment = RegisterPropertyPreviewFragment()
            activity.supportFragmentManager.beginTransaction()
                .addToBackStack(TAG)
                .replace(containerId, fragment)
                .commit()

        }

    }

//    override fun onDestroyView() {
//        if (view != null) {
//            val parent = view!!.parent as ViewGroup
//            parent.removeAllViews()
//        }
//        super.onDestroyView()


}


