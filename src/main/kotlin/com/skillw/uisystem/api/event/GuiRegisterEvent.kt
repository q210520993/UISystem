package com.skillw.uisystem.api.event

import com.skillw.uisystem.api.gui.Gui
import taboolib.platform.type.BukkitProxyEvent

class GuiRegisterEvent(val key: String, val gui: Gui) : BukkitProxyEvent()
