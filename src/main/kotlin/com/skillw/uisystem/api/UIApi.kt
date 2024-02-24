package com.skillw.uisystem.api

import com.daxton.unrealcore.display.controller.HUDController
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

    @JvmStatic
    internal fun Player.sendHud(key: String){
        UISystem.hudManager.sendHud(this, key)
    }

    @JvmStatic
    internal fun Player.removeHud(key: String){
        UISystem.hudManager.removeHud(this,key)
    }

    @JvmStatic
    internal fun Player.clearHud(){
        HUDController.clearHUD(this)
    }

}