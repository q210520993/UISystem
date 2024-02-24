package com.skillw.uisystem.internal.Listener

import com.skillw.uisystem.UISystem
import com.skillw.uisystem.api.event.FinishLoading
import taboolib.common.platform.event.SubscribeEvent

object chest {
    @SubscribeEvent
    fun finishLoading(finishLoading: FinishLoading) {
        UISystem.chestManager.forEach{ title ->
            UISystem.chestManager.setPlayer(finishLoading.player,title.key)
        }
    }

}