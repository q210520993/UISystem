package com.skillw.uisystem.api.gui

import com.daxton.unrealcore.display.been.module.ModuleData
import com.skillw.pouvoir.api.plugin.map.component.Registrable
import com.skillw.uisystem.UISystem

abstract class Hud: Registrable<String> {

    abstract override val key: String

    abstract val data: List<ModuleData>?

    override fun register() {
        UISystem.hudManager.register(this)
    }

}