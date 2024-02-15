package com.skillw.uisystem.api.gui

import com.daxton.unrealcore.display.been.gui.MainGUIData
import com.daxton.unrealcore.display.content.gui.UnrealCoreGUI
import com.daxton.unrealcore.display.content.module.ModuleComponents
import com.skillw.pouvoir.api.plugin.map.component.Registrable
import com.skillw.uisystem.UISystem

abstract class Gui :
    Registrable<String>, UnrealCoreGUI() {

    abstract override val key: String

    abstract override fun opening()

    var release = false

    abstract override fun close()

    final override fun register() {
        com.skillw.uisystem.UISystem.guiManager.register(this)
    }

}
