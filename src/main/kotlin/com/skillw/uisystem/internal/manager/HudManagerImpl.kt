package com.skillw.uisystem.internal.manager

import com.daxton.unrealcore.application.UnrealCoreAPI
import com.skillw.pouvoir.api.plugin.SubPouvoir
import com.skillw.uisystem.UISystem
import com.skillw.uisystem.api.UIApi.clearHud
import com.skillw.uisystem.api.manager.HudManager
import org.bukkit.Bukkit
import org.bukkit.entity.Player

object HudManagerImpl: HudManager() {

    override val key: String = "HudManager"
    override val priority: Int = 3
    override val subPouvoir: SubPouvoir = UISystem

    override fun sendHud(player: Player, key: String) {
        UnrealCoreAPI.setHUD(player,this[key]?.data)
    }

    override fun removeHud(player: Player, key: String) {
        UnrealCoreAPI.removeHUD(player,this[key]?.data)
    }

    override fun onReload() {
        Bukkit.getServer().onlinePlayers.forEach {zxy ->
//            UISystem.hudManager.forEach{
//                UISystem.hudManager.removeHud(zxy,it.key)
//            }
            zxy.clearHud()
            UIConfig.AutoEnableHUD.forEach {
                UISystem.hudManager.sendHud(zxy,it)
            }
        }
        super.onReload()
    }


}