package com.skillw.uisystem.internal.Listener

import com.skillw.uisystem.UISystem
import com.skillw.uisystem.api.UIApi.sendHud
import com.skillw.uisystem.api.event.FinishLoading
import com.skillw.uisystem.internal.manager.UIConfig
import taboolib.common.platform.event.SubscribeEvent

object hud {
    @SubscribeEvent
    fun finishLoading(finishLoading: FinishLoading) {
        UIConfig.AutoEnableHUD.forEach {
            finishLoading.player.sendHud(it)
        }
    }
}