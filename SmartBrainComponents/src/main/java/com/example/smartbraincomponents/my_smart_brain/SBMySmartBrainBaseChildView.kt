package com.example.smartbraincomponents.my_smart_brain

import android.content.Context

abstract class SBMySmartBrainBaseChildView<DATA>(
    context: Context,
) : SBMySmartBrainBaseView(context) {

    var data: DATA? = null

    var itemHeaderView: SBMySmartBrainItemHeaderView? = null
}