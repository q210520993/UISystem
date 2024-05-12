package com.skillw.uisystem

import com.skillw.pouvoir.api.manager.ManagerData
import com.skillw.pouvoir.api.plugin.SubPouvoir
import com.skillw.pouvoir.api.plugin.annotation.PouManager
import com.skillw.uisystem.api.UIApi
import com.skillw.uisystem.api.manager.*
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

    //给JS用的
    @JvmStatic
    val API = UIApi

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
    lateinit var resourceStateManager: ResourceStateManager

    @JvmStatic
    @PouManager
    lateinit var chestManager: ChestManager

    @JvmStatic
    @PouManager
    lateinit var hudManager: HudManager

    @JvmStatic
    @PouManager
    lateinit var clientKeyManager: ClientKeyManager

    @JvmStatic
    @PouManager
    lateinit var serverKeyManager: ServerKeyManager

    @JvmStatic
    @PouManager
    lateinit var cameraManager: CameraManager

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