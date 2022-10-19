package com.uaref

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.uaref.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null

    private var navHostFragment: NavHostFragment? = null
    private var navController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment?.navController
        bottomMenu()
    }

    private fun bottomMenu() {
        if (binding?.chipNavBar?.isActivated == false) {
            binding?.chipNavBar?.setItemSelected(R.id.tab_home)
        }
        binding?.chipNavBar?.setOnItemSelectedListener {
            navController?.let { navController ->
                when (it) {
                    R.id.tab_home -> navController.navigate(R.id.tab_home)
                    R.id.tab_search -> navController.navigate(R.id.tab_search)
                    R.id.tab_ad -> navController.navigate(R.id.tab_ad)
                    R.id.tab_profile -> navController.navigate(R.id.tab_profile)
                }
            }
        }
    }


}
