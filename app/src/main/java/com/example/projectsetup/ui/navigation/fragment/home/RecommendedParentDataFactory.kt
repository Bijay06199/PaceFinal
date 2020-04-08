package com.example.projectsetup.ui.navigation.fragment.home

import kotlin.random.Random

object RecommendedParentDataFactory {

    private  val random= Random

    private val titles1= arrayListOf("Popular Cities","Recommended Property")



    private fun randomChildren():ArrayList<RecommendedChildModel>{

        return RecommendedChildDataFactory.getChildren(20)
    }

    fun getParents(count:Int):List<RecommendedParentModel>{
        val parents= mutableListOf<RecommendedParentModel>()
        repeat(count){

            val parent = RecommendedParentModel( randomChildren())
            parents.add(parent)
        }
        return parents


    }

}