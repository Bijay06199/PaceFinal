package com.example.projectsetup.ui.navigation.fragment.home


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projectsetup.BR

import com.example.projectsetup.R
import com.example.projectsetup.base.BaseFragment
import com.example.projectsetup.databinding.FragmentHomeBinding
import com.example.projectsetup.databinding.FragmentHomeBinding.inflate
import com.example.projectsetup.ui.Adapter.ViewPagerAdapter
import com.example.projectsetup.ui.Adapter.ViewPagerListener
import com.example.projectsetup.ui.navigation.NavigationActivity
import com.example.projectsetup.ui.navigation.fragment.home.listener.fragment.HomeFirstFragment
import com.example.projectsetup.ui.navigation.fragment.home.listener.fragment.HomeSecondFragment
import com.example.projectsetup.ui.navigation.fragment.home.listener.fragment.HomeThirdFragment
import com.example.projectsetup.ui.navigation.salehome.SaleHomeActivity
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.recommended_property_parent.*
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeFragmentViewModel>() {

    override fun getLayoutId(): Int = R.layout.fragment_home
    private val homeFragmentViewModel: HomeFragmentViewModel by viewModel()
    override fun getViewModel(): HomeFragmentViewModel = homeFragmentViewModel
    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    var recyclerView1 = recyclerview_reccommended_parent
    var recyclerView2 = recyclerview_reccommended_child

    private lateinit var pagerAdapterView: ViewPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewDataBinding = inflate(inflater, container, false)
        return viewDataBinding.root


    }


    private fun setUpRecyclerView() {

        recyclerView1 = recyclerview_reccommended_parent
        recyclerView2 = recyclerview_reccommended_child
        recyclerView1.affectOnItemClicks { position, view ->
            startActivity(
                Intent(
                    context,
                    SaleHomeActivity::class.java
                )
            )
        }
        recyclerView.affectOnItemClicks { position, view ->
            startActivity(
                Intent(
                    context,
                    SaleHomeActivity::class.java
                )
            )
        }


        recyclerView1.apply {
            layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)

            adapter = RecommendedParentAdapter(RecommendedParentDataFactory.getParents(40))
        }

        val productAdapter = ProductAdapter()
        recyclerView.adapter = productAdapter

        var productList = ArrayList<Product>()

        productList.add(Product("Tokyo", R.drawable.rectangle))
        productList.add(Product("Nara", R.drawable.rectangle14))
        productList.add(Product("Akhibara", R.drawable.rectangle149))
        productList.add(Product("Okinaw", R.drawable.rectangle1492))
        productList.add(Product("Geman", R.drawable.rectangle))
        productList.add(Product("France", R.drawable.rectangle14))
        productList.add(Product("Akhibara", R.drawable.rectangle149))
        productList.add(Product("Sochua", R.drawable.rectangle1492))


        productAdapter.addAll(productList)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()

        pagerAdapterView = ViewPagerAdapter(childFragmentManager)
        addPagerFragments()
        myViewPager1?.adapter = pagerAdapterView
        myViewPager1?.addOnPageChangeListener(ViewPagerListener(this::onPageSelected))
    }


    private fun onPageSelected(position: Int) {
        when (position) {
            0 -> {
                firstDotImageView1.setImageResource(R.drawable.selecteditemhome_dot)
                secondDotImageView1.setImageResource(R.drawable.nonselecteditemhome_dot)
                thirdDotImageView1.setImageResource(R.drawable.nonselecteditemhome_dot)
            }
            1 -> {
                firstDotImageView1.setImageResource(R.drawable.nonselecteditemhome_dot)
                secondDotImageView1.setImageResource(R.drawable.selecteditemhome_dot)
                thirdDotImageView1.setImageResource(R.drawable.nonselecteditemhome_dot)
            }
            2 -> {

                firstDotImageView1.setImageResource(R.drawable.nonselecteditemhome_dot)
                secondDotImageView1.setImageResource(R.drawable.nonselecteditemhome_dot)
                thirdDotImageView1.setImageResource(R.drawable.selecteditemhome_dot)


            }
        }
    }

    private fun addPagerFragments() {
        pagerAdapterView.addFragments(HomeFirstFragment())
        pagerAdapterView.addFragments(HomeSecondFragment())
        pagerAdapterView.addFragments(HomeThirdFragment())
    }

}
