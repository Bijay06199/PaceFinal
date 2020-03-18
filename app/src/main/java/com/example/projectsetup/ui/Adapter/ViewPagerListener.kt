package com.example.projectsetup.ui.Adapter

import androidx.viewpager.widget.ViewPager

class ViewPagerListener(private val closure: (Int) -> Unit) : ViewPager.OnPageChangeListener {
    override fun onPageScrollStateChanged(p0: Int) {
        var count:Int
    }
    override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {
    }
    override fun onPageSelected(position: Int) = closure(position)


}