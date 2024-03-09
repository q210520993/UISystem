package com.skillw.uisystem.internal.feather.listener

import com.skillw.uisystem.UISystem
import com.skillw.uisystem.api.event.FinishLoading
import taboolib.common.platform.event.SubscribeEvent

object Chest {
    @SubscribeEvent
    fun finishLoading(finishLoading: FinishLoading) {
        UISystem.chestManager.forEach{ title ->
            UISystem.chestManager.setPlayer(finishLoading.player,title.key)
        }
    }

}