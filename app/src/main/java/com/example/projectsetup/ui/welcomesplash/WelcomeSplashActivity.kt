package com.example.projectsetup.ui.welcomesplash

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import com.example.projectsetup.BR
import com.example.projectsetup.R
import com.example.projectsetup.base.BaseActivity
import com.example.projectsetup.databinding.ActivityWelcomeSplashBinding
import com.example.projectsetup.ui.Adapter.ViewPagerAdapter
import com.example.projectsetup.ui.Adapter.ViewPagerListener
import com.example.projectsetup.ui.main.MainActivity
import com.example.projectsetup.ui.welcomesplash.fragment.IntroFirstFragment
import com.example.projectsetup.ui.welcomesplash.fragment.IntroSecondFragment
import com.example.projectsetup.ui.welcomesplash.fragment.IntroThirdFragment
import kotlinx.android.synthetic.main.activity_welcome_splash.*

class WelcomeSplashActivity :BaseActivity<ActivityWelcomeSplashBinding,WelcomeSplashViewModel>() {


    var counter: Int=0

    val SELECTED_TAB_EXTRA_KEY:String = "selectedTabIndex"
  private  lateinit var pagerAdapterView: ViewPagerAdapter


    override fun getLayoutId(): Int =R.layout.activity_welcome_splash

    override fun getViewModel(): WelcomeSplashViewModel =WelcomeSplashViewModel()


    override fun getBindingVariable(): Int {

        return BR.viewModel
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
      //  setContentView(R.layout.activity_welcome_splash)



        initView()





        }

    private fun initView() {

        pagerAdapterView = ViewPagerAdapter(supportFragmentManager)
        addPagerFragments()
        myViewPager.adapter = pagerAdapterView
        myViewPager?.setPageTransformer(true, this::zoomOutTransformation)
        myViewPager?.addOnPageChangeListener(ViewPagerListener(this::onPageSelected))



        with(viewDataBinding){

            btnSplashNext1.setOnClickListener(View.OnClickListener {

                counter++

                if(counter==1){

                    val selected:Int=intent.getIntExtra(SELECTED_TAB_EXTRA_KEY,1 )
                    myViewPager.setCurrentItem(selected)





                }

                else if(counter==2){

                    val selected:Int=intent.getIntExtra(SELECTED_TAB_EXTRA_KEY,2)
                    myViewPager.setCurrentItem(selected)



                }

                else if(counter==3){

                    start(this@WelcomeSplashActivity)
                }

                else{


                    counter=1

                }




            })

            btnSplashNext1.setOnClickListener(View.OnClickListener {



                counter++

                if(counter==1){


                    val selected:Int=intent.getIntExtra(SELECTED_TAB_EXTRA_KEY,counter)
                    myViewPager.setCurrentItem(selected)




                }

                else if(counter==2){

                    val selected:Int=intent.getIntExtra(SELECTED_TAB_EXTRA_KEY,counter)
                    myViewPager.setCurrentItem(selected)



                }

                else if(counter==3){

                    start(this@WelcomeSplashActivity)


                }

                else{

                    counter=1

                }

            })

            imgSkip.setOnClickListener(View.OnClickListener {

                start(this@WelcomeSplashActivity)
            })
        }
    }

    companion object {
        private const val MIN_SCALE = 0.65f
        private const val MIN_ALPHA = 0.3f


        fun start(context: Context) {

            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)

        }

    }


    private fun onPageSelected(position: Int) {
        when (position) {
            0 -> {
                firstDotImageView.setImageResource(R.drawable.selecteditem_dot)
                secondDotImageView.setImageResource(R.drawable.nonselecteditem_dot)
                thirdDotImageView.setImageResource(R.drawable.nonselecteditem_dot)
                counter=0
            }
            1 -> {
                firstDotImageView.setImageResource(R.drawable.nonselecteditem_dot)
                secondDotImageView.setImageResource(R.drawable.selecteditem_dot)
                thirdDotImageView.setImageResource(R.drawable.nonselecteditem_dot)
                counter=1
            }
            2 -> {

                firstDotImageView.setImageResource(R.drawable.nonselecteditem_dot)
                secondDotImageView.setImageResource(R.drawable.nonselecteditem_dot)
                thirdDotImageView.setImageResource(R.drawable.selecteditem_dot)
                counter=2


            }
        }
    }
    private fun addPagerFragments() {
        pagerAdapterView.addFragments(IntroFirstFragment())
        pagerAdapterView.addFragments(IntroSecondFragment())
        pagerAdapterView.addFragments(IntroThirdFragment())
    }
    private fun zoomOutTransformation(page: View, position: Float) {
        when {
            position < -1 ->
                page.alpha = 0f
            position <= 1 -> {
                page.scaleX = Math.max(MIN_SCALE, 1 - Math.abs(position))
                page.scaleY = Math.max(MIN_SCALE, 1 - Math.abs(position))
                page.alpha = Math.max(MIN_ALPHA, 1 - Math.abs(position))
            }
            else -> page.alpha = 0f
        }
    }
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    }




