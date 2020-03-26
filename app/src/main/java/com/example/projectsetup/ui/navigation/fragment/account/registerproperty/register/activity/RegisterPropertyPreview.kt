package com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.activity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.projectsetup.BR
import com.example.projectsetup.R
import com.example.projectsetup.base.BaseActivity
import com.example.projectsetup.databinding.ActivityRegisterPropertyPreviewBinding
import com.example.projectsetup.ui.Adapter.ViewPagerAdapter
import com.example.projectsetup.ui.Adapter.ViewPagerListener
import com.example.projectsetup.ui.navigation.NavigationActivity
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.activity.previewFragment.BedRoomFragment
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.activity.previewFragment.ExteriorFragment
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.activity.previewFragment.LayoutFragment
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.viewModel.RegisterPropertyPreviewViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterPropertyPreview
    : BaseActivity<ActivityRegisterPropertyPreviewBinding,RegisterPropertyPreviewViewModel>() {
    var counter: Int = 0


    private lateinit var pagerAdapterView: ViewPagerAdapter
    private val registerPropertyPreviewViewModel: RegisterPropertyPreviewViewModel by viewModel()

    override fun getLayoutId(): Int = R.layout.activity_register_property_preview
    override fun getViewModel(): RegisterPropertyPreviewViewModel = registerPropertyPreviewViewModel
    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            with(viewDataBinding) {
                val fragment = ExteriorFragment()
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.saleContainer, fragment)
                transaction.commit()
                imgExterior.visibility = View.VISIBLE
                imgLayout.visibility = View.INVISIBLE
                imgBedroom.visibility = View.INVISIBLE
                imgBathroom.visibility = View.INVISIBLE
                imgLivingRoom.visibility = View.INVISIBLE
                imgLivingRoom11.visibility = View.INVISIBLE

            }


        }
        pagerAdapterView = ViewPagerAdapter(supportFragmentManager)
        addPagerFragments()
        viewDataBinding.myViewPager1?.adapter = pagerAdapterView
        // myViewPager1?.setPageTransformer(true, this::zoomOutTransformation)
        viewDataBinding.myViewPager1?.addOnPageChangeListener(ViewPagerListener(this::onPageSelected))
        initView()
        setUpObservers()

    }

    private fun setUpObservers() {

    }

    private fun initView() {

        with(viewDataBinding) {

            txtRoute.setOnClickListener(View.OnClickListener {

                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps")))

            })

            imgheart.setOnClickListener(View.OnClickListener {

                imgheart.visibility = View.INVISIBLE
                imgsavedheart.visibility = View.VISIBLE
            })

            imgsavedheart.setOnClickListener(View.OnClickListener {

                imgsavedheart.visibility = View.INVISIBLE
                imgheart.visibility = View.VISIBLE
            })





            txtExterior.setOnClickListener(View.OnClickListener {
                val fragment = ExteriorFragment()
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.saleContainer, fragment)
                transaction.commit()

                imgExterior.visibility = View.VISIBLE
                imgLayout.visibility = View.INVISIBLE
                imgBedroom.visibility = View.INVISIBLE
                imgBathroom.visibility = View.INVISIBLE
                imgLivingRoom.visibility = View.INVISIBLE
                imgLivingRoom11.visibility = View.INVISIBLE
            })


            txtLayout.setOnClickListener(View.OnClickListener {
                val fragment = LayoutFragment()
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.saleContainer, fragment)
                transaction.commit()

                imgLayout.visibility = View.VISIBLE
                imgExterior.visibility = View.INVISIBLE
                imgBedroom.visibility = View.INVISIBLE
                imgBathroom.visibility = View.INVISIBLE
                imgLivingRoom.visibility = View.INVISIBLE
                imgLivingRoom11.visibility = View.INVISIBLE
            })


            txtBedroom.setOnClickListener(View.OnClickListener {
                val fragment = BedRoomFragment()
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.saleContainer, fragment)
                transaction.commit()
                imgBedroom.visibility = View.VISIBLE
                imgLayout.visibility = View.INVISIBLE
                imgExterior.visibility = View.INVISIBLE
                imgBathroom.visibility = View.INVISIBLE
                imgLivingRoom.visibility = View.INVISIBLE
                imgLivingRoom11.visibility = View.INVISIBLE
            })


            imgBack.setOnClickListener(View.OnClickListener {

                val intent = Intent(
                    this@RegisterPropertyPreview,
                    RegisterPropertyDescriptionActivity::class.java
                )
                startActivity(intent)
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
                val fragment = ExteriorFragment()
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.saleContainer, fragment)
                transaction.commit()
            }
            1 -> {
                viewDataBinding.imgLayout.visibility = View.VISIBLE
                viewDataBinding.imgExterior.visibility = View.INVISIBLE
                viewDataBinding.imgBedroom.visibility = View.INVISIBLE
                viewDataBinding.imgBathroom.visibility = View.INVISIBLE
                viewDataBinding.imgLivingRoom.visibility = View.INVISIBLE
                viewDataBinding.imgLivingRoom11.visibility = View.INVISIBLE
               val fragment = LayoutFragment()
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.saleContainer, fragment)
                transaction.commit()
            }
            2 -> {
                viewDataBinding.imgBedroom.visibility = View.VISIBLE
                viewDataBinding.imgLayout.visibility = View.INVISIBLE
                viewDataBinding.imgExterior.visibility = View.INVISIBLE
               viewDataBinding.imgBathroom.visibility = View.INVISIBLE
                viewDataBinding.imgLivingRoom.visibility = View.INVISIBLE
                viewDataBinding.imgLivingRoom11.visibility = View.INVISIBLE
                val fragment = BedRoomFragment()
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.saleContainer, fragment)
                transaction.commit()

            }
        }
    }


    private fun addPagerFragments() {
        pagerAdapterView.addFragments(ExteriorFragment())
        pagerAdapterView.addFragments(LayoutFragment())
        pagerAdapterView.addFragments(BedRoomFragment())
    }
}




