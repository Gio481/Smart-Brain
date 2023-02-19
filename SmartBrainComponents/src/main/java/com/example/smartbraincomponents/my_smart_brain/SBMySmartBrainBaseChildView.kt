package com.example.smartbraincomponents.my_smart_brain

import android.content.Context

abstract class SBMySmartBrainBaseChildView(
    context: Context,
) : SBMySmartBrainBaseView(context) {


    var itemHeaderView: SBMySmartBrainItemHeaderView? = null
}