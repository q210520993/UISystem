package com.skillw.uisystem.api.event

import org.bukkit.entity.Player
import taboolib.platform.type.BukkitProxyEvent

class FinishLoading(val player: Player) : BukkitProxyEvent()