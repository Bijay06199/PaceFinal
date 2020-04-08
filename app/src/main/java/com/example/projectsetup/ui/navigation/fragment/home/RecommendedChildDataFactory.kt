package com.example.projectsetup.ui.navigation.fragment.home

import com.example.projectsetup.R
import kotlin.random.Random

object RecommendedChildDataFactory {

    private val random= Random

    private val titles1= arrayListOf("sale","rent","Shiho City", "Okhinara")
    private val titles2= arrayListOf("sale","rent","Shiho City", "Okhinara")
    private val titles3= arrayListOf("sale","rent","Shiho City", "Okhinara")
    private val image= arrayListOf("https://cdn.pixabay.com/photo/2016/11/18/14/50/boat-1835081_960_720.jpg","https://cdn.pixabay.com/photo/2016/11/18/14/50/boat-1835081_960_720.jpg")


    private fun randomTitle1():String{
        val index= random.nextInt(titles1.size)

        return titles1[index]
    }

    private fun randomTitle2():String{
        val index= random.nextInt(titles2.size)

        return titles2[index]
    }

    private fun randomTitle3():String{
        val index= random.nextInt(titles3.size)

        return titles3[index]
    }

    private fun randomImage():String{

        val index= random.nextInt(image.size)
        return image[index]

    }

    fun getChildren(count:Int):ArrayList<RecommendedChildModel>{
        val children = ArrayList<RecommendedChildModel>()
        repeat(count){
            val child= RecommendedChildModel(randomImage(), randomTitle1(), randomTitle2(), randomTitle3())
            children.add(child)
        }
        return children
    }

}