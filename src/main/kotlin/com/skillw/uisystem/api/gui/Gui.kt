package com.skillw.uisystem.api.gui

import com.daxton.unrealcore.display.been.module.ModuleData
import com.daxton.unrealcore.display.content.gui.UnrealCoreGUI
import com.daxton.unrealcore.display.content.module.ModuleComponents
import com.skillw.pouvoir.api.plugin.map.component.Keyable
import com.skillw.pouvoir.api.plugin.map.component.Registrable
import com.skillw.pouvoir.api.script.annotation.ScriptAnnotationData
import com.skillw.uisystem.UISystem

abstract class Gui : Keyable<String>, UnrealCoreGUI() {

    abstract override val key: String

    var release: Boolean = false

    abstract val customData: MutableMap<String, Any>

    abstract val chest: Boolean
}
