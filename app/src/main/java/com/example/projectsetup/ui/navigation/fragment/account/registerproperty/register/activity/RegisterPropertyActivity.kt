package com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projectsetup.R
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.fragment.RegisterMyPropertyFragment
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.fragment.RegisterPropertyRelationshipFragment

class RegisterPropertyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_property)

        RegisterPropertyRelationshipFragment.start(this, R.id.container_register_property)
    }


    override fun onBackPressed() {
        val currentFragment =
            supportFragmentManager.findFragmentById(R.id.container_register_property)
        if (currentFragment is RegisterMyPropertyFragment) {
            finish()
        }
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }

    }
}
