package com.example.projectsetup.ui.navigation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.example.projectsetup.BR
import com.example.projectsetup.R
import com.example.projectsetup.base.BaseActivity
import com.example.projectsetup.databinding.ActivityNavigationBinding
import com.example.projectsetup.ui.navigation.fragment.account.AccountFragment
import com.example.projectsetup.ui.navigation.fragment.chat.ChatFragment
import com.example.projectsetup.ui.navigation.fragment.home.HomeFragment
import com.example.projectsetup.ui.navigation.fragment.saved.SavedFragment
import com.example.projectsetup.ui.navigation.fragment.search.MapsActivity
import kotlinx.android.synthetic.main.activity_navigation.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class NavigationActivity : BaseActivity<ActivityNavigationBinding, NavigationViewModel>() {

    private val navigationViewModel:NavigationViewModel by viewModel()
    override fun getLayoutId(): Int = R.layout.activity_navigation

    override fun getViewModel(): NavigationViewModel = navigationViewModel

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
        setUpObservers()
    }

    private fun setUpObservers() {

        with(navigationViewModel){
            txtHomeClicked.observe(this@NavigationActivity, Observer {




            })

            txtChatClicked.observe(this@NavigationActivity, Observer {

            })
        }

    }

    private fun initView() {

        with(viewDataBinding) {


            chat.setOnClickListener(View.OnClickListener {
                home.setTextColor(resources.getColor(R.color.saved))
                chat.setTextColor(resources.getColor(R.color.colorAccent))
                saved.setTextColor(resources.getColor(R.color.saved))
                search.setTextColor(resources.getColor(R.color.saved))
                user.setTextColor(resources.getColor(R.color.saved))

                val fragment = ChatFragment()
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.fragment_container, fragment)
                transaction.commit()
            })


            home.setOnClickListener(View.OnClickListener {
                home.setTextColor(resources.getColor(R.color.colorAccent))
                chat.setTextColor(resources.getColor(R.color.saved))
                saved.setTextColor(resources.getColor(R.color.saved))
                search.setTextColor(resources.getColor(R.color.saved))
                user.setTextColor(resources.getColor(R.color.saved))

                val fragment=HomeFragment()
                val transaction=supportFragmentManager.beginTransaction()
                transaction.replace(R.id.fragment_container,fragment)
                transaction.commit()
            })


            saved.setOnClickListener(View.OnClickListener {
                val fragment = SavedFragment()
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



                home.setTextColor(resources.getColor(R.color.saved))
                chat.setTextColor(resources.getColor(R.color.saved))
                saved.setTextColor(resources.getColor(R.color.saved))
                search.setTextColor(resources.getColor(R.color.colorAccent))
                user.setTextColor(resources.getColor(R.color.saved))
            })

            fab.setOnClickListener(View.OnClickListener {

                onstart(this@NavigationActivity)



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

    fun onstart(context: Context){
      val intent=Intent(this@NavigationActivity, MapsActivity::class.java)
      context.startActivity(intent)
    }
}
