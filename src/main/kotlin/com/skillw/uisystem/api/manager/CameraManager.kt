package com.skillw.uisystem.api.manager

import com.skillw.pouvoir.api.manager.Manager
import com.skillw.pouvoir.api.plugin.map.KeyMap
import com.skillw.uisystem.api.camera.Camera
import org.bukkit.entity.Player

abstract class CameraManager: Manager, KeyMap<String, Camera>() {
    abstract fun sendCamera(key: String, player: Player)

}