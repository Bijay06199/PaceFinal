package com.example.projectsetup.ui.navigation.fragment.account.myProfile.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.lifecycle.Observer
import com.example.projectsetup.BR
import com.example.projectsetup.R
import com.example.projectsetup.base.BaseActivity
import com.example.projectsetup.databinding.ActivityIdVerificationBinding
import com.example.projectsetup.ui.navigation.fragment.account.myProfile.viewModel.IdVerificationViewModel
import kotlinx.android.synthetic.main.activity_edit_profile.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.io.IOException

class IdVerificationActivity :
    BaseActivity<ActivityIdVerificationBinding, IdVerificationViewModel>() {
    override fun getLayoutId(): Int = R.layout.activity_id_verification
    private val idVerificationViewModel: IdVerificationViewModel by viewModel()
    override fun getViewModel(): IdVerificationViewModel = idVerificationViewModel
    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //  setContentView(R.layout.activity_id_verification)
        initView()
        setUpObservers()
    }

    private fun initView() {


    }

    private fun setUpObservers() {
        with(idVerificationViewModel) {

            backClickedEvent.observe(this@IdVerificationActivity, Observer {
                startActivity(
                    Intent(
                        this@IdVerificationActivity,
                        AccountVerificationActivity::class.java
                    )
                )
                finish()
            })
        }

    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        var GET_FROM_GALLERY = 3
        if (resultCode == Activity.RESULT_OK)
            when (requestCode) {
                GET_FROM_GALLERY -> {
                    val selectedImage = data!!.data
                    try {
                        val bitmap = MediaStore.Images.Media.getBitmap(
                            this@IdVerificationActivity.getContentResolver(),
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
