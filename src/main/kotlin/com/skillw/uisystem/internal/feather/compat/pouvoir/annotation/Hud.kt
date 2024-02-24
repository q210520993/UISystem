package com.skillw.uisystem.internal.feather.compat.pouvoir.annotation

import com.daxton.unrealcore.display.been.module.ModuleData
import com.skillw.pouvoir.Pouvoir
import com.skillw.pouvoir.api.plugin.annotation.AutoRegister
import com.skillw.pouvoir.api.script.annotation.ScriptAnnotation
import com.skillw.pouvoir.api.script.annotation.ScriptAnnotationData
import com.skillw.pouvoir.util.toArgs
import com.skillw.uisystem.api.gui.Hud

@AutoRegister
internal object Hud: ScriptAnnotation("HudCreate"){
    override fun handle(data: ScriptAnnotationData) {
        val script = data.script
        val args = data.args.toArgs()
        val key = if (args.isEmpty() || args[0] == "") data.function else args[0]
        object : Hud() {

            override val key: String = key

            override val data = Pouvoir.scriptManager.invoke<List<ModuleData>?>(script, "setting")

        }.register()
    }
}