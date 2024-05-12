package com.skillw.uisystem.internal.manager

import com.daxton.unrealcore.been.player.type.CameraTargetType
import com.daxton.unrealcore.been.player.type.PlayerCameraType
import com.daxton.unrealcore.player.CorePlayerController
import com.skillw.pouvoir.api.plugin.SubPouvoir
import com.skillw.pouvoir.util.listSubFiles
import com.skillw.pouvoir.util.loadMultiply
import com.skillw.pouvoir.util.loadYaml
import com.skillw.uisystem.UISystem
import com.skillw.uisystem.api.camera.Camera
import com.skillw.uisystem.api.event.GuiRegisterEvent
import com.skillw.uisystem.api.gui.Gui
import com.skillw.uisystem.api.manager.CameraManager
import com.skillw.uisystem.util.findEnumValue
import org.bukkit.configuration.ConfigurationSection
import org.bukkit.entity.Player
import java.io.File

object CameraManagerImpl: CameraManager() {

    override val key: String  = "CameraManager"
    override val priority: Int = 12
    override val subPouvoir: SubPouvoir = UISystem

    override fun sendCamera(key: String, player: Player) {
        val camera = this[key]
        val core = CorePlayerController(player)
        core.cameraPositionSet(
            camera?.playerCameraType,
            camera?.cameraTargetType,
            "",
            camera?.x,
            camera?.y,
            camera?.z
        )
        core.cameraRotationSet(
            camera?.playerCameraType,
            camera?.cameraTargetType,
            camera?.yaw,
            camera?.pitch
        )
    }

    override fun onEnable() {
        onReload()
    }

    override fun onReload() {
        clear()
        val list = File(UISystem.plugin.dataFolder, "camera").listSubFiles().filter {
            it.extension == "yml"
        }
        list.forEach {file ->
            val yaml = file.loadYaml(true)
            yaml?.getKeys(false)?.forEach {
                Camera.deserialize(yaml[it] as ConfigurationSection).register()
            }
        }
    }
}