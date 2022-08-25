package com.example.smartbrainauthentication.navigation


import com.example.smartbrainauthentication.feature.signin.di.SBSignInFeatureComponentImpl
import com.example.smartbrainauthentication.feature.signup.di.SBSignUpFeatureComponentImpl
import com.example.smartbrainnavigation.cicerone.SBNavigationType
import com.example.smartbrainnavigation.cicerone.feature.SBFeatureRouter

class SBAuthenticationNavigatorImpl(private val featureRouter: SBFeatureRouter) : SBAuthenticationNavigator {
    override fun navigateToSignIn() {
        SBSignInFeatureComponentImpl().featureInject()
        featureRouter.navigateTo(screen = SBAuthenticationScreens.SignIn, navigationType = SBNavigationType.REPLACE)
    }

    override fun navigateToSignUp() {
        SBSignUpFeatureComponentImpl().featureInject()
        featureRouter.navigateTo(screen = SBAuthenticationScreens.SignUp, navigationType = SBNavigationType.REPLACE)
    }

}