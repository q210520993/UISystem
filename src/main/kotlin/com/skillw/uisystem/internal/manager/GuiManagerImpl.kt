package com.skillw.uisystem.internal.manager

import com.daxton.unrealcore.application.UnrealCoreAPI
import com.skillw.pouvoir.api.plugin.SubPouvoir
import com.skillw.pouvoir.api.script.annotation.ScriptAnnotationData
import com.skillw.uisystem.UISystem
import com.skillw.uisystem.api.event.GuiRegisterEvent
import com.skillw.uisystem.api.gui.Gui
import com.skillw.uisystem.api.manager.GuiManager
import com.skillw.uisystem.internal.core.ScriptGui
import org.bukkit.entity.Player

object GuiManagerImpl: GuiManager() {
    override val key: String = "GuiManager"
    override val priority = 1
    override val subPouvoir: SubPouvoir = UISystem

    override fun OpenGui(player: Player, key: String) {
        this[key]?.let { UnrealCoreAPI.openGUI(player, ScriptGui(it, player)) } ?: return
    }

    override fun close(player: Player) {
        UnrealCoreAPI.closeGUI(player)
    }

    override fun register(key: String, value: ScriptAnnotationData): ScriptAnnotationData? {
        val e = GuiRegisterEvent(key, value)
        e.call()
        if (e.isCancelled) return null
        return put(key,value)
    }

}
