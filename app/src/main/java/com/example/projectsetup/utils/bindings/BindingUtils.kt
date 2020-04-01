package com.example.projectsetup.utils.bindings

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.projectsetup.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions


object BindingUtils {

    /**
     *  handle view visibility through databinding where @param b is received from layout
     * if @param b is true view will be visible to user otherwise gone
     * @param v
     * @param b
     */
    @BindingAdapter("isVisible")
    @JvmStatic
    fun setIsVisible(v: View, b: Boolean) {
        if (b) {
            v.visibility = View.VISIBLE
        } else {
            v.visibility = View.GONE
        }
    }

    @BindingAdapter("imageSrc")
    @JvmStatic
    fun setImageSrc(imageView: ImageView, imageSrc: String?) {
        with(imageView) {
            Glide.with(context)
                    .load(imageSrc)
                    .thumbnail(0.1f)
                    .apply(RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL)
                            .placeholder(R.color.material_white)
                            .error(R.color.black))
                    .into(imageView)
        }
    }
}