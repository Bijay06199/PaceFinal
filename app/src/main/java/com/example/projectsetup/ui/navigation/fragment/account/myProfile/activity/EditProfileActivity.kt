package com.example.projectsetup.ui.navigation.fragment.account.myProfile.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.provider.MediaStore
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.PopupWindow
import androidx.lifecycle.Observer
import androidx.transition.TransitionManager
import com.example.projectsetup.BR
import com.example.projectsetup.R
import com.example.projectsetup.base.BaseActivity
import com.example.projectsetup.databinding.ActivityEditProfileBinding
import com.example.projectsetup.ui.navigation.fragment.account.myProfile.viewModel.EditProfileViewModel
import kotlinx.android.synthetic.main.activity_edit_profile.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.io.IOException

class EditProfileActivity : BaseActivity<ActivityEditProfileBinding, EditProfileViewModel>() {
    var   GET_FROM_GALLERY = 3
    override fun getLayoutId(): Int = R.layout.activity_edit_profile

    private val editProfileViewModel: EditProfileViewModel by viewModel()
    override fun getViewModel(): EditProfileViewModel = editProfileViewModel

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_edit_profile)
        initView()
        setUpObservers()
    }

    private fun setUpObservers() {
        with(editProfileViewModel){
            backClickedEvent.observe(this@EditProfileActivity, Observer {
                startActivity(Intent(this@EditProfileActivity,MyProfileActivity::class.java))
                finish()
            })
        }

    }

    private fun initView() {

        with(viewDataBinding) {
            txtSave.setOnClickListener {
                val inflater: LayoutInflater =
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                val view = inflater.inflate(R.layout.popupsave_layout, null)
                overlapSave.setBackgroundColor(resources.getColor(R.color.blur))


                val popupWindow = PopupWindow(
                    view, // Custom view to show in popup window
                    LinearLayout.LayoutParams.MATCH_PARENT, // Width of popup window
                    LinearLayout.LayoutParams.MATCH_PARENT // Window height

                )
                val handler = Handler()
                handler.postDelayed(object : Runnable {
                    public override fun run() {
                        //ToDo your function
                        //hide your popup here
                        popupWindow.dismiss()

                        val intent = Intent(this@EditProfileActivity, MyProfileActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                }, 1500)

                popupWindow.animationStyle = R.anim.slide_in_left
                popupWindow.isTouchable = true
                popupWindow.dismiss()
                popupWindow.isOutsideTouchable = true


                popupWindow.setOnDismissListener(PopupWindow.OnDismissListener {


                    overlapSave.setBackgroundColor(resources.getColor(R.color.transparentpop))

                })







                TransitionManager.beginDelayedTransition(relativeSave)
                popupWindow.showAtLocation(
                    relativeSave, // Location to display popup window
                    Gravity.CENTER, // Exact position of layout to display popup
                    0, // X offset
                    0 // Y offset
                )
            }
        }

    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK)
            when (requestCode) {
                GET_FROM_GALLERY -> {
                    val selectedImage = data!!.data
                    try {
                        val bitmap = MediaStore.Images.Media.getBitmap(
                            this@EditProfileActivity.getContentResolver(),
                            selectedImage
                        )
                        galleryImage.setImageBitmap(bitmap)
                    } catch (e: IOException) {
                        Log.i("TAG", "Some exception $e")
                    }

                }
            }
    }



}
