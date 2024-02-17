package com.skillw.uisystem.internal.Listener

import com.daxton.unrealcore.display.controller.HUDController
import com.skillw.uisystem.api.event.FinishLoading
import com.skillw.uisystem.internal.manager.UIConfig
import com.skillw.uisystem.util.findHUDType
import taboolib.common.platform.Awake
import taboolib.common.platform.event.SubscribeEvent
import taboolib.common.platform.function.warning

object disableHUD {
    @SubscribeEvent
    fun finish(event: FinishLoading){
        UIConfig.disableHud.forEach { zxy ->
            val a = findHUDType(zxy) ?: return@forEach warning("这似乎不是一个正确的类型")
            HUDController.setHUDDisplay(event.player,a,false)
        }
    }

}