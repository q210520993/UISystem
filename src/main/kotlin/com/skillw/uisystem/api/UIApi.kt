package com.skillw.uisystem.api

import com.daxton.unrealcore.resource.controller.ResourceController
import com.skillw.uisystem.UISystem
import com.skillw.uisystem.internal.manager.UIConfig
import org.bukkit.entity.Player

object UIApi {

    @JvmStatic
    internal fun Player.openGui(key: String){
        UISystem.guiManager.OpenGui(this,key)
    }

    @JvmStatic
    internal fun Player.sendRes(){
        ResourceController.load(player, UIConfig.resources, UIConfig.resourcesPassword)
    }
}