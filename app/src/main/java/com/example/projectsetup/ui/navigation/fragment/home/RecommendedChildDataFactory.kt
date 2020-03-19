package com.example.projectsetup.ui.navigation.fragment.home

import com.example.projectsetup.R
import kotlin.random.Random

object RecommendedChildDataFactory {

    private val random= Random

    private val titles1= arrayListOf("sale","rent","Shiho City", "Okhinara")
    private val titles2= arrayListOf("sale","rent","Shiho City", "Okhinara")
    private val titles3= arrayListOf("sale","rent","Shiho City", "Okhinara")
    private val image= arrayListOf(R.drawable.rectangle85,R.drawable.rectangle85)


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

    private fun randomImage():Int{

        val index= random.nextInt(image.size)
        return image[index]

    }

    fun getChildren(count:Int):List<RecommendedChildModel>{
        val children = mutableListOf<RecommendedChildModel>()
        repeat(count){
            val child= RecommendedChildModel(randomImage(), randomTitle1(), randomTitle2(), randomTitle3())
            children.add(child)
        }
        return children
    }

}