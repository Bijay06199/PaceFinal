package com.example.projectsetup.ui.navigation.fragment.account.registerproperty.agent.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projectsetup.R
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.agent.fragment.AgentProfileFragment
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.agent.fragment.FindAgentByAreaFragment
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.fragment.RegisterMyPropertyFragment

class AgentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agent)
        FindAgentByAreaFragment.start(this,R.id.container_agent)
    }

    override fun onBackPressed() {
        val currentFragment =
            supportFragmentManager.findFragmentById(R.id.container_agent)
        if (currentFragment is AgentProfileFragment) {
            finish()
        }
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }

    }
}
