package com.skillw.uisystem.api.gui

import com.daxton.unrealcore.common.type.MouseActionType
import com.daxton.unrealcore.common.type.MouseButtonType
import com.daxton.unrealcore.display.content.gui.UnrealCoreGUI
import com.daxton.unrealcore.display.content.module.control.ButtonModule
import com.skillw.pouvoir.api.plugin.map.component.Registrable
import com.skillw.uisystem.UISystem

abstract class Gui() : Registrable<String>, UnrealCoreGUI() {

    abstract override val key: String

    abstract override fun opening()

    abstract override fun close()

    var release: Boolean = false

    abstract val chest: Boolean

    abstract override fun buttonClick(buttonModule: ButtonModule?, button: MouseButtonType?, action: MouseActionType?)

    override fun register() {
        UISystem.guiManager.register(this)
        if (chest) UISystem.chestManager.register(this)
    }

}
