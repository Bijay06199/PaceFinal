package com.example.projectsetup.ui.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.projectsetup.BR
import com.example.projectsetup.R
import com.example.projectsetup.base.BaseActivity
import com.example.projectsetup.databinding.ActivityNavigationBinding
import com.example.projectsetup.ui.navigation.fragment.account.AccountFragment
import com.example.projectsetup.ui.navigation.fragment.chat.ChatFragment
import com.example.projectsetup.ui.navigation.fragment.home.HomeFragment
import com.example.projectsetup.ui.navigation.fragment.search.SearchFragment
import kotlinx.android.synthetic.main.activity_navigation.*

class NavigationActivity : BaseActivity<ActivityNavigationBinding, NavigationViewModel>() {
    override fun getLayoutId(): Int = R.layout.activity_navigation

    override fun getViewModel(): NavigationViewModel = NavigationViewModel()

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_navigation)

        if (savedInstanceState == null) {
            val fragment = HomeFragment()
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.commit()
            home.setTextColor(resources.getColor(R.color.colorAccent))
            chat.setTextColor(resources.getColor(R.color.saved))
            saved.setTextColor(resources.getColor(R.color.saved))
            search.setTextColor(resources.getColor(R.color.saved))
            user.setTextColor(resources.getColor(R.color.saved))
        }

        initView()
    }

    private fun initView() {

        with(viewDataBinding) {


            chat.setOnClickListener(View.OnClickListener {
                val fragment = ChatFragment()
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.fragment_container, fragment)
                transaction.commit()


                home.setTextColor(resources.getColor(R.color.saved))
                chat.setTextColor(resources.getColor(R.color.colorAccent))
                saved.setTextColor(resources.getColor(R.color.saved))
                search.setTextColor(resources.getColor(R.color.saved))
                user.setTextColor(resources.getColor(R.color.saved))
            })


            home.setOnClickListener(View.OnClickListener {
                val fragment = HomeFragment()
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.fragment_container, fragment)
                transaction.commit()



                home.setTextColor(resources.getColor(R.color.colorAccent))
                chat.setTextColor(resources.getColor(R.color.saved))
                saved.setTextColor(resources.getColor(R.color.saved))
                search.setTextColor(resources.getColor(R.color.saved))
                user.setTextColor(resources.getColor(R.color.saved))
            })


            saved.setOnClickListener(View.OnClickListener {
                val fragment = SearchFragment()
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.fragment_container, fragment)
                transaction.commit()


                home.setTextColor(resources.getColor(R.color.saved))
                chat.setTextColor(resources.getColor(R.color.saved))
                saved.setTextColor(resources.getColor(R.color.colorAccent))
                search.setTextColor(resources.getColor(R.color.saved))
                user.setTextColor(resources.getColor(R.color.saved))
            })


            search.setOnClickListener(View.OnClickListener {
                val fragment = SearchFragment()
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.fragment_container, fragment)
                transaction.commit()


                home.setTextColor(resources.getColor(R.color.saved))
                chat.setTextColor(resources.getColor(R.color.saved))
                saved.setTextColor(resources.getColor(R.color.saved))
                search.setTextColor(resources.getColor(R.color.colorAccent))
                user.setTextColor(resources.getColor(R.color.saved))
            })

            fab.setOnClickListener(View.OnClickListener {
                val fragment = SearchFragment()
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.fragment_container, fragment)
                transaction.commit()


            })


            user.setOnClickListener(View.OnClickListener {
                val fragment = AccountFragment()
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.fragment_container, fragment)
                transaction.commit()



                home.setTextColor(resources.getColor(R.color.saved))
                chat.setTextColor(resources.getColor(R.color.saved))
                saved.setTextColor(resources.getColor(R.color.saved))
                search.setTextColor(resources.getColor(R.color.saved))
                user.setTextColor(resources.getColor(R.color.colorAccent))
            })

        }

    }
}
