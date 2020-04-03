package com.example.projectsetup.ui.welcome

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.widget.Toast
import com.example.projectsetup.BR
import com.example.projectsetup.R
import com.example.projectsetup.base.BaseActivity
import com.example.projectsetup.databinding.WelcomeLayoutBinding
import com.example.projectsetup.ui.welcomesplash.WelcomeSplashActivity
import com.example.projectsetup.utils.contracts.AppContracts.LanguageType.ENGLISH
import com.example.projectsetup.utils.contracts.AppContracts.LanguageType.HEBREW
import com.example.projectsetup.utils.contracts.AppContracts.LanguageType.JAPANESE
import com.example.projectsetup.utils.contracts.AppContracts.LanguageType.NEPAL
import com.example.projectsetup.utils.contracts.AppContracts.LanguageType.RUSSIAN
import com.example.projectsetup.utils.contracts.AppContracts.LanguageType.SPANISH
import kotlinx.android.synthetic.main.welcome_layout.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*
import kotlin.collections.ArrayList

class WelcomeActivity : BaseActivity<WelcomeLayoutBinding,WelcomeViewModel>(),WelcomeAdapter.OnItemClickListener {
    override fun onItemClicked(position: Int, property: WelcomeModel) {


//        when(position){
//            0->preferenceManager.setLanguageType(JAPANESE)
//            1->preferenceManager.setLanguageType(ENGLISH)
//            2->preferenceManager.setLanguageType(HEBREW)
//            3->preferenceManager.setLanguageType(RUSSIAN)
//            4->preferenceManager.setLanguageType(SPANISH)
//            5->preferenceManager.setLanguageType(NEPAL)
//
//        }

    }

    lateinit var welcomeAdapter: WelcomeAdapter
    private val welcomeViewModel:WelcomeViewModel by viewModel()
    override fun getLayoutId(): Int =R.layout.welcome_layout
    override fun getViewModel(): WelcomeViewModel = welcomeViewModel


    override fun getBindingVariable(): Int {

        return BR.viewModel
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadlocate()


        if(savedInstanceState==null){

//            preferenceManager.setLanguageType(ENGLISH)
//            when(preferenceManager.getLanguageType()){
//                ENGLISH->iv_tick.visibility=View.VISIBLE
//            }

//            japanTick.visibility= View.INVISIBLE
//            ukTick.visibility=View.VISIBLE
//            hebrewTick.visibility=View.INVISIBLE
//            vietnamTick.visibility=View.INVISIBLE
//            russiaTick.visibility=View.INVISIBLE
//            spanishTick.visibility=View.INVISIBLE
//            nepalTick.visibility=View.INVISIBLE
//            setlocate("en")
//            btnConfirm.text=getText(R.string.confirm)


        }

       initView()
        setUpObservers()
    }



    private fun setUpObservers() {

        with(welcomeViewModel){
            nextClickEvent.observe(this@WelcomeActivity,androidx.lifecycle.Observer {
                onStart(this@WelcomeActivity)
            })
        }

        welcomeAdapter= WelcomeAdapter(this)
        recyclerView.adapter=welcomeAdapter
        var itemList=ArrayList<WelcomeModel>()

        itemList.add(WelcomeModel(R.drawable.japan,"Japan",R.drawable.icontick))
        itemList.add(WelcomeModel(R.drawable.uk,"English",R.drawable.icontick))
        itemList.add(WelcomeModel(R.drawable.indonesia,"Indonesia",R.drawable.icontick))
        itemList.add(WelcomeModel(R.drawable.vietnam,"Vietnam",R.drawable.icontick))
        itemList.add(WelcomeModel(R.drawable.russia,"Russia",R.drawable.icontick))
        itemList.add(WelcomeModel(R.drawable.spain,"Spain",R.drawable.icontick))
        itemList.add(WelcomeModel(R.drawable.nepal,"Nepal",R.drawable.icontick))

        welcomeAdapter.addAll(itemList)

//        when(preferenceManager.getLanguageType()){
//            AppContracts.LanguageType.JAPANESE ->iv_tick.visibility= View.VISIBLE
//            AppContracts.LanguageType.ENGLISH ->iv_tick.visibility= View.VISIBLE
//            AppContracts.LanguageType.HEBREW ->iv_tick.visibility= View.VISIBLE
//            AppContracts.LanguageType.VIETNAM ->iv_tick.visibility= View.VISIBLE
//            AppContracts.LanguageType.RUSSIAN ->iv_tick.visibility= View.VISIBLE
//            AppContracts.LanguageType.SPANISH ->iv_tick.visibility= View.VISIBLE
//            AppContracts.LanguageType.NEPAL ->iv_tick.visibility= View.VISIBLE
//        }

//        with(welcomeViewModel){
//
//            nextClickEvent.observe(this@WelcomeActivity,androidx.lifecycle.Observer {
//                onStart(this@WelcomeActivity)
//
//            })
//        }

    }


    private fun initView() {



//
//        japanTick.visibility=View.INVISIBLE
//        ukTick.visibility=View.INVISIBLE
//        hebrewTick.visibility=View.INVISIBLE
//        vietnamTick.visibility=View.INVISIBLE
//        russiaTick.visibility=View.INVISIBLE
//        spanishTick.visibility=View.INVISIBLE
//        nepalTick.visibility=View.INVISIBLE



//        layoutJapan.setOnClickListener(View.OnClickListener {
//            preferenceManager.setLanguageType(JAPANESE)
//
////            japanTick.visibility= View.VISIBLE
////            ukTick.visibility=View.INVISIBLE
////            hebrewTick.visibility=View.INVISIBLE
////            vietnamTick.visibility=View.INVISIBLE
////            russiaTick.visibility=View.INVISIBLE
////            spanishTick.visibility=View.INVISIBLE
////            nepalTick.visibility=View.INVISIBLE
////            setlocate("ja")
////            btnConfirm.text=getText(R.string.confirm)
//
//        })
//
//
//        layoutHebrew.setOnClickListener(View.OnClickListener {
//            preferenceManager.setLanguageType(HEBREW)
//
//
//
////            japanTick.visibility= View.INVISIBLE
////            ukTick.visibility=View.INVISIBLE
////            hebrewTick.visibility=View.VISIBLE
////            vietnamTick.visibility=View.INVISIBLE
////            russiaTick.visibility=View.INVISIBLE
////            spanishTick.visibility=View.INVISIBLE
////            nepalTick.visibility=View.INVISIBLE
////            setlocate("in")
////            btnConfirm.text=getText(R.string.confirm)
//        })
//
//        layoutUk.setOnClickListener(View.OnClickListener {
//
//            preferenceManager.setLanguageType(ENGLISH)
////            japanTick.visibility= View.INVISIBLE
////            ukTick.visibility=View.VISIBLE
////            hebrewTick.visibility=View.INVISIBLE
////            vietnamTick.visibility=View.INVISIBLE
////            russiaTick.visibility=View.INVISIBLE
////            spanishTick.visibility=View.INVISIBLE
////            nepalTick.visibility=View.INVISIBLE
////            setlocate("en")
////            btnConfirm.text=getText(R.string.confirm)
//
//
//        })
//
//
//        layoutVietnam.setOnClickListener(View.OnClickListener {
//
//            preferenceManager.setLanguageType(VIETNAM)
//
//
////            japanTick.visibility= View.INVISIBLE
////            ukTick.visibility=View.INVISIBLE
////            hebrewTick.visibility=View.INVISIBLE
////            vietnamTick.visibility=View.VISIBLE
////            russiaTick.visibility=View.INVISIBLE
////            spanishTick.visibility=View.INVISIBLE
////            nepalTick.visibility=View.INVISIBLE
////            setlocate("vi")
////            btnConfirm.text=getText(R.string.confirm)
//        })
//
//        layoutSpanish.setOnClickListener(View.OnClickListener {
//
//
//            preferenceManager.setLanguageType(SPANISH)
//
////            japanTick.visibility= View.INVISIBLE
////            ukTick.visibility=View.INVISIBLE
////            hebrewTick.visibility=View.INVISIBLE
////            vietnamTick.visibility=View.INVISIBLE
////            russiaTick.visibility=View.INVISIBLE
////            spanishTick.visibility=View.VISIBLE
////            nepalTick.visibility=View.INVISIBLE
////            setlocate("vi")
////            btnConfirm.text=getText(R.string.confirm)
//        })
//
//        layoutRussian.setOnClickListener(View.OnClickListener {
//
//
//            preferenceManager.setLanguageType(RUSSIAN)
//
////            japanTick.visibility= View.INVISIBLE
////            ukTick.visibility=View.INVISIBLE
////            hebrewTick.visibility=View.INVISIBLE
////            vietnamTick.visibility=View.INVISIBLE
////            russiaTick.visibility=View.VISIBLE
////            spanishTick.visibility=View.INVISIBLE
////            nepalTick.visibility=View.INVISIBLE
////            setlocate("vi")
////            btnConfirm.text=getText(R.string.confirm)
//        })
//
//        layoutNepal.setOnClickListener(View.OnClickListener {
//
//            preferenceManager.setLanguageType(NEPAL)
//
//
////            japanTick.visibility= View.INVISIBLE
////            ukTick.visibility=View.INVISIBLE
////            hebrewTick.visibility=View.INVISIBLE
////            vietnamTick.visibility=View.INVISIBLE
////            russiaTick.visibility=View.INVISIBLE
////            spanishTick.visibility=View.INVISIBLE
////            nepalTick.visibility=View.VISIBLE
////            setlocate("vi")
////            btnConfirm.text=getText(R.string.confirm)
//        })



    }


    companion object{

         fun onStart(context: Context){

             val intent=Intent(context,WelcomeSplashActivity::class.java)
             context.startActivity(intent)

        }
    }


    private fun loadlocate() {
        val sharedPreferences=getSharedPreferences("Settings", Activity.MODE_PRIVATE)
        val language= sharedPreferences.getString("My lang","")
        setlocate(language)

    }



    private fun setlocate(Lang: String?) {

        val locale= Locale(Lang)

        Locale.setDefault(locale)

        val config= Configuration()

        config.locale= locale
        baseContext.resources.updateConfiguration(config,baseContext.resources.displayMetrics)

        val editor= getSharedPreferences("Settings",Context.MODE_PRIVATE).edit()
        editor.putString("My lang",Lang)
        editor.apply()

    }


    }

