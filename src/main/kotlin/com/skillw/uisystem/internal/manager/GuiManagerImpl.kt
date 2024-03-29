package com.skillw.uisystem.internal.manager

import com.daxton.unrealcore.application.UnrealCoreAPI
import com.skillw.pouvoir.api.plugin.SubPouvoir
import com.skillw.uisystem.UISystem
import com.skillw.uisystem.api.event.GuiRegisterEvent
import com.skillw.uisystem.api.gui.Gui
import com.skillw.uisystem.api.manager.GuiManager
import com.skillw.uisystem.internal.manager.UIConfig.debug
import org.bukkit.entity.Player
import taboolib.common.platform.function.warning

object GuiManagerImpl: GuiManager() {
    override val key: String = "GuiManager"
    override val priority = 1
    override val subPouvoir: SubPouvoir = UISystem

    override fun OpenGui(player: Player, key: String) {
        this[key]?.let { UnrealCoreAPI.openGUI(player, it) } ?: return
    }

    override fun close(player: Player) {
        UnrealCoreAPI.closeGUI(player)
    }

    override fun onReload() {
        this.entries.filter { it.value.release }.forEach { remove(it.key) }
    }

    override fun register(key: String, value: Gui): Gui? {
        val e = GuiRegisterEvent(key, gui = value)
        e.call()
        if (e.isCancelled) return null
        debug {
            println("${key}注册成功")
            println("组件列表${value.addModuleMap}")
            println("MainGuiDataModuleMap${value.mainGUIData.moduleDataMap}")
        }
        return put(key,value)
    }
}
