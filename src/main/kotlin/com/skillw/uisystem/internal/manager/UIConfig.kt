package com.skillw.uisystem.internal.manager

import com.skillw.pouvoir.Pouvoir
import com.skillw.pouvoir.api.manager.ConfigManager
import com.skillw.pouvoir.util.static
import com.skillw.uisystem.UISystem
import org.spigotmc.AsyncCatcher
import taboolib.common.platform.function.getDataFolder
import java.io.File

object UIConfig : ConfigManager(UISystem) {
    override val priority: Int = 0


    override fun onLoad() {
        AsyncCatcher.enabled = false
        createIfNotExists("scripts", "example.js")
        Pouvoir.scriptEngineManager.globalVariables.let {
            it["UISystem"] = UISystem::class.java.static()
        }
    }

    override fun onEnable() {
        onReload()
    }
    override fun subReload() {
        Pouvoir.scriptManager.addScriptDir(scripts)
    }

    private val scripts = File(getDataFolder(), "scripts")

    var isDebug = false

    val debug: Boolean
        get() = this["config"].getBoolean("options.debug") || isDebug

    val resources: String?
        get() = this["config"].getString("resources.name")
    val resourcesEnable: Boolean
        get() = this["config"].getBoolean("resources.enable")
    val resourcesPassword: String?
        get() = this["config"].getString("resources.password")

    @JvmStatic
    fun debug(debug: () -> Unit) {
        if (this.debug) {
            debug.invoke()
        }
    }
}