package com.skillw.uisystem

import com.skillw.pouvoir.api.manager.ManagerData
import com.skillw.pouvoir.api.plugin.SubPouvoir
import com.skillw.pouvoir.api.plugin.annotation.PouManager
import com.skillw.uisystem.api.manager.GuiManager
import com.skillw.uisystem.api.manager.RdataManager
import com.skillw.uisystem.internal.manager.UIConfig
import org.bukkit.plugin.java.JavaPlugin
import taboolib.common.platform.Plugin
import taboolib.module.configuration.Config
import taboolib.module.configuration.ConfigFile
import taboolib.platform.BukkitPlugin

object UISystem : Plugin(), SubPouvoir {

    /** Basic */

    override val key = "UISystem"
    override val plugin: JavaPlugin by lazy(LazyThreadSafetyMode.NONE) {
        BukkitPlugin.getInstance()
    }

    /** Config */
    @Config("config.yml")
    lateinit var config: ConfigFile


    /** Managers */

    override lateinit var managerData: ManagerData

    @JvmStatic
    @PouManager
    lateinit var configManager: UIConfig

    @JvmStatic
    @PouManager
    lateinit var guiManager: GuiManager

    @JvmStatic
    @PouManager
    lateinit var rdataManager: RdataManager



    override fun onLoad() {
        load()
    }

    override fun onEnable() {
        enable()
    }

    override fun onActive() {
        active()
    }

    override fun onDisable() {
        disable()
    }


}