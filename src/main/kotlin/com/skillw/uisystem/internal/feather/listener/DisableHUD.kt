package com.skillw.uisystem.internal.feather.listener

import com.daxton.unrealcore.application.UnrealCoreAPI
import com.daxton.unrealcore.display.controller.HUDController
import com.daxton.unrealcore.display.type.HUDType
import com.skillw.uisystem.api.event.FinishLoading
import com.skillw.uisystem.internal.manager.UIConfig
import com.skillw.uisystem.util.findEnumValue
import taboolib.common.platform.event.SubscribeEvent
import taboolib.common.platform.function.warning

object DisableHUD {
    @SubscribeEvent
    fun finish(event: FinishLoading){
        UIConfig.disableHud.forEach { zxy ->
            val a = findEnumValue<HUDType>(zxy) ?: return@forEach warning("这似乎不是一个正确的类型")
            HUDController.setHUDDisplay(event.player,a,false)
        }
        UnrealCoreAPI.inst(event.player).commonHelper
    }

}