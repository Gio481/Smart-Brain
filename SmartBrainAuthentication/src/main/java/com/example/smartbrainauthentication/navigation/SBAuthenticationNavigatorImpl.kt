package com.example.smartbrainauthentication.navigation


import com.example.smartbrainauthentication.feature.signin.di.SBSignInFeatureComponentImpl
import com.example.smartbrainauthentication.feature.signup.di.SBSignUpFeatureComponentImpl
import com.example.smartbrainnavigation.cicerone.SBNavigationType
import com.example.smartbrainnavigation.cicerone.feature.SBFeatureRouter
import com.example.smartbrainnavigation.cicerone.navigator.SBAppNavigators

class SBAuthenticationNavigatorImpl(private val router: SBFeatureRouter) : SBAppNavigators.Authentication {

    override fun navigateToSignIn(navigationType: SBNavigationType) {
        SBSignInFeatureComponentImpl().featureInject()
        router.navigateTo(
            screen = SBAuthenticationScreens.SignIn,
            navigationType = navigationType
        )
    }

    override fun navigateToSignUp(navigationType: SBNavigationType) {
        SBSignUpFeatureComponentImpl().featureInject()
        router.navigateTo(
            screen = SBAuthenticationScreens.SignUp,
            navigationType = navigationType
        )
    }
}