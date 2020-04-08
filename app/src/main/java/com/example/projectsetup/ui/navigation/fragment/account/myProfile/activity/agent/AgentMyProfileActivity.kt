package com.example.projectsetup.ui.navigation.fragment.account.myProfile.activity.agent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projectsetup.BR
import com.example.projectsetup.R
import com.example.projectsetup.base.BaseActivity
import com.example.projectsetup.databinding.ActivityAgentMyProfileBinding
import com.example.projectsetup.ui.navigation.fragment.account.myProfile.activity.agent.fragment.AgentOptionsFragment
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.agent.fragment.AgentProfileFragment
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.agent.fragment.FindAgentByAreaFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class AgentMyProfileActivity :AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agent_my_profile)
        AgentOptionsFragment.start(this,R.id.container_agent_profile)
    }

    override fun onBackPressed() {
        val currentFragment =
            supportFragmentManager.findFragmentById(R.id.container_agent_profile)

        if(currentFragment is AgentOptionsFragment){
            finish()
        }

        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }

    }
}
