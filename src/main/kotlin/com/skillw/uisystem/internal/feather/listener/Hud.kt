package com.skillw.uisystem.internal.feather.listener

import com.skillw.uisystem.api.UIApi.sendHud
import com.skillw.uisystem.api.event.FinishLoading
import com.skillw.uisystem.internal.manager.UIConfig
import taboolib.common.platform.event.SubscribeEvent

object Hud {
    @SubscribeEvent
    fun finishLoading(finishLoading: FinishLoading) {
        UIConfig.AutoEnableHUD.forEach {
            finishLoading.player.sendHud(it)
        }
    }
}