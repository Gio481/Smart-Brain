package com.example.smartbrainnavigation.cicerone.service

import com.example.smartbrainnavigation.cicerone.flow.SBFlowRouter

interface SBFlowRouterService {
    val router: SBFlowRouter?
}

class SBFlowRouterServiceImpl(override val router: SBFlowRouter?) : SBFlowRouterService