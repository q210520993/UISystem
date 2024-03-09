package com.skillw.uisystem.api

import com.daxton.unrealcore.display.controller.HUDController
import com.daxton.unrealcore.resource.controller.ResourceController
import com.skillw.uisystem.UISystem
import com.skillw.uisystem.internal.feather.compat.pouvoir.database.UiContainer
import com.skillw.uisystem.internal.manager.UIConfig
import org.bukkit.entity.Player

object UIApi {

    @JvmStatic
    internal fun setCustomPlayerData(player: Player,key: String, value: String) {
        UiContainer[player.uniqueId.toString(), key] = value
    }

    @JvmStatic
    internal fun removeCustomPlayerData(player: Player,key: String) {
        UiContainer.delete(
            player.uniqueId.toString(),
            key
        )
    }

    @JvmStatic
    internal fun getCustomPlayerData(player: Player,key: String): String? {
        return UiContainer[player.uniqueId.toString(), key]
    }

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

    @JvmStatic
    internal fun Player.sendKeyMapping(key: String){
        UISystem.clientKeyManager.keyMappingSet(this, key)
    }

    @JvmStatic
    internal fun Player.removeKeyMapping(key: String){
        UISystem.clientKeyManager.keyMappingRemove(this, key)
    }

    @JvmStatic
    internal fun Player.clearKeyMapping(){
        UISystem.clientKeyManager.keyMappingClear(this)
    }

}