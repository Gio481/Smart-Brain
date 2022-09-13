package com.example.smartbrain.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.smartbrain.R
import com.example.smartbrain.databinding.ActivityMainBinding
import com.example.smartbraincomponents.base.SBBaseFragment
import com.example.smartbrainnavigation.cicerone.constants.CICERONE_FEATURE
import com.example.smartbrainnavigation.cicerone.feature.SBFeatureRouter
import com.example.smartbrainnavigation.cicerone.feature.SBFeatureScreen
import com.example.smartbrainnavigation.cicerone.navigator.SBAppNavigator
import com.example.smartbrainnavigation.cicerone.navigator.SBNavigator
import com.example.smartbrainnavigation.cicerone.navigator.SBNavigatorHolder
import com.example.smartbrainsplash.navigation.SBSplashNavigator
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject
import org.koin.core.qualifier.StringQualifier

class SBMainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val navigatorHolder by inject<SBNavigatorHolder>(StringQualifier("Feature"))
    private val featureRouter by inject<SBFeatureRouter>()

    private val splashNavigator = get<SBSplashNavigator>()

    private val navigator: SBNavigator by lazy {
        object : SBAppNavigator<SBFeatureScreen>(
            this,
            R.id.mainFragmentContainerView,
            get(CICERONE_FEATURE),
            supportFragmentManager
        ) {
            override fun activityBack() {
                featureRouter.back()
            }
        }
    }

    private fun getCurrentFragment(): Fragment? {
        return supportFragmentManager.findFragmentById(R.id.mainFragmentContainerView)
    }

    override fun onBackPressed() {
        when (val currentFragment = getCurrentFragment()) {
            is SBBaseFragment<*> -> {
                if (currentFragment.onBackPressed()) return
                if (supportFragmentManager.backStackEntryCount == 0) {
                    finishAffinity()
                } else {
                    supportFragmentManager.popBackStack()
                }
            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        splashNavigator.navigateToSplash()
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }
}