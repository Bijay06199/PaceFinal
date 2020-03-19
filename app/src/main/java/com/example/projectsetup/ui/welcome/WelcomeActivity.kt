package com.example.projectsetup.ui.welcome

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.projectsetup.BR
import com.example.projectsetup.R
import com.example.projectsetup.base.BaseActivity
import com.example.projectsetup.databinding.ActivityWelcomeBinding
import com.example.projectsetup.databinding.ActivityWelcomeBindingImpl
import com.example.projectsetup.ui.login.LoginActivity
import com.example.projectsetup.ui.welcomesplash.WelcomeSplashActivity
import kotlinx.android.synthetic.main.activity_welcome.*
import java.util.*

class WelcomeActivity : BaseActivity<ActivityWelcomeBinding,WelcomeViewModel>() {

    override fun getLayoutId(): Int =R.layout.activity_welcome
    override fun getViewModel(): WelcomeViewModel = WelcomeViewModel()


    override fun getBindingVariable(): Int {

        return BR.viewModel
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_welcome)
        loadlocate()

        if(savedInstanceState==null){


            japanTick.visibility= View.INVISIBLE
            ukTick.visibility=View.VISIBLE
            hebrewTick.visibility=View.INVISIBLE
            vietnamTick.visibility=View.INVISIBLE
            russiaTick.visibility=View.INVISIBLE
            spanishTick.visibility=View.INVISIBLE
            nepalTick.visibility=View.INVISIBLE
            setlocate("en")
            btnConfirm.text=getText(R.string.confirm)


        }

        initView()
    }




    private fun initView() {

        japanTick.visibility=View.INVISIBLE
        ukTick.visibility=View.VISIBLE
        hebrewTick.visibility=View.INVISIBLE
        vietnamTick.visibility=View.INVISIBLE
        russiaTick.visibility=View.INVISIBLE
        spanishTick.visibility=View.INVISIBLE
        nepalTick.visibility=View.INVISIBLE



        layoutJapan.setOnClickListener(View.OnClickListener {


            japanTick.visibility= View.VISIBLE
            ukTick.visibility=View.INVISIBLE
            hebrewTick.visibility=View.INVISIBLE
            vietnamTick.visibility=View.INVISIBLE
            russiaTick.visibility=View.INVISIBLE
            spanishTick.visibility=View.INVISIBLE
            nepalTick.visibility=View.INVISIBLE
            setlocate("ja")
            btnConfirm.text=getText(R.string.confirm)

        })


        layoutHebrew.setOnClickListener(View.OnClickListener {




            japanTick.visibility= View.INVISIBLE
            ukTick.visibility=View.INVISIBLE
            hebrewTick.visibility=View.VISIBLE
            vietnamTick.visibility=View.INVISIBLE
            russiaTick.visibility=View.INVISIBLE
            spanishTick.visibility=View.INVISIBLE
            nepalTick.visibility=View.INVISIBLE
            setlocate("in")
            btnConfirm.text=getText(R.string.confirm)
        })

        layoutUk.setOnClickListener(View.OnClickListener {


            japanTick.visibility= View.INVISIBLE
            ukTick.visibility=View.VISIBLE
            hebrewTick.visibility=View.INVISIBLE
            vietnamTick.visibility=View.INVISIBLE
            russiaTick.visibility=View.INVISIBLE
            spanishTick.visibility=View.INVISIBLE
            nepalTick.visibility=View.INVISIBLE
            setlocate("en")
            btnConfirm.text=getText(R.string.confirm)


        })


        layoutVietnam.setOnClickListener(View.OnClickListener {




            japanTick.visibility= View.INVISIBLE
            ukTick.visibility=View.INVISIBLE
            hebrewTick.visibility=View.INVISIBLE
            vietnamTick.visibility=View.VISIBLE
            russiaTick.visibility=View.INVISIBLE
            spanishTick.visibility=View.INVISIBLE
            nepalTick.visibility=View.INVISIBLE
            setlocate("vi")
            btnConfirm.text=getText(R.string.confirm)
        })

        layoutSpanish.setOnClickListener(View.OnClickListener {




            japanTick.visibility= View.INVISIBLE
            ukTick.visibility=View.INVISIBLE
            hebrewTick.visibility=View.INVISIBLE
            vietnamTick.visibility=View.INVISIBLE
            russiaTick.visibility=View.INVISIBLE
            spanishTick.visibility=View.VISIBLE
            nepalTick.visibility=View.INVISIBLE
            setlocate("vi")
            btnConfirm.text=getText(R.string.confirm)
        })

        layoutRussian.setOnClickListener(View.OnClickListener {




            japanTick.visibility= View.INVISIBLE
            ukTick.visibility=View.INVISIBLE
            hebrewTick.visibility=View.INVISIBLE
            vietnamTick.visibility=View.INVISIBLE
            russiaTick.visibility=View.VISIBLE
            spanishTick.visibility=View.INVISIBLE
            nepalTick.visibility=View.INVISIBLE
            setlocate("vi")
            btnConfirm.text=getText(R.string.confirm)
        })

        layoutNepal.setOnClickListener(View.OnClickListener {




            japanTick.visibility= View.INVISIBLE
            ukTick.visibility=View.INVISIBLE
            hebrewTick.visibility=View.INVISIBLE
            vietnamTick.visibility=View.INVISIBLE
            russiaTick.visibility=View.INVISIBLE
            spanishTick.visibility=View.INVISIBLE
            nepalTick.visibility=View.VISIBLE
            setlocate("vi")
            btnConfirm.text=getText(R.string.confirm)
        })



        with(viewDataBinding){

            btnConfirm.setOnClickListener(View.OnClickListener {

                onStart(this@WelcomeActivity)
            })
        }
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
