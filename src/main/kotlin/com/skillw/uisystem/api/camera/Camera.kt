package com.skillw.uisystem.api.camera

import com.daxton.unrealcore.been.player.type.CameraTargetType
import com.daxton.unrealcore.been.player.type.PlayerCameraType
import com.skillw.pouvoir.api.plugin.map.component.Registrable
import com.skillw.uisystem.UISystem
import com.skillw.uisystem.util.findEnumValue
import org.bukkit.configuration.serialization.ConfigurationSerializable

abstract class Camera: Registrable<String> {

    abstract override val key: String

    abstract val cameraTargetType: CameraTargetType?

    abstract val playerCameraType: PlayerCameraType?

    private val target: String = ""

    abstract val x: String

    abstract val y: String

    abstract val z: String

    abstract val yaw: String

    abstract val pitch: String

    fun cameraRotationBeen(): String {
        return "CameraRotationBeen(playerCameraType=${playerCameraType}, cameraTargetType=${cameraTargetType}, yaw=${yaw}, pitch=${pitch})"
    }

    override fun toString(): String {
        return "CameraPositionBeen(playerCameraType=${playerCameraType}, cameraTargetType=${cameraTargetType}, targetUUID=${target}, posX=${x}, posY=${y}, posZ=${z})"
    }

    companion object {
        @JvmStatic
        fun deserialize(section: org.bukkit.configuration.ConfigurationSection): Camera {
            return object : Camera() {
                override val key: String = section.name
                init {
                    println(key)
                    println(section.name)
                    println(section.getString("cameraTargetType"))
                    println(section)
                }
                override val cameraTargetType: CameraTargetType? = findEnumValue<CameraTargetType>(
                    section.getString("cameraTargetType") ?: "SELF"
                )
                override val playerCameraType: PlayerCameraType? = findEnumValue<PlayerCameraType>(
                    section.getString("cameraCameraType") ?: "FIRST_PERSON"
                )
                override val x: String = section.getString("x") ?: "0"
                override val y: String = section.getString("y") ?: "0"
                override val z: String = section.getString("z") ?: "0"
                override val yaw: String = section.getString("yaw") ?: "0"
                override val pitch: String = section.getString("pitch") ?: "0"
            }
        }
    }

    override fun register() {
        UISystem.cameraManager.register(this)
    }

}