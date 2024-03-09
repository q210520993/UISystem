package com.skillw.uisystem.api.manager

import com.skillw.pouvoir.api.manager.Manager
import com.skillw.pouvoir.api.plugin.map.KeyMap
import com.skillw.uisystem.api.key.ServerKey

abstract class ServerKeyManager: Manager, KeyMap<String, ServerKey>()