package com.borcore.teleport

import org.bukkit.Bukkit
import java.util.*

class Request(val sender: UUID, val receiver: UUID) {

    fun accept() {
        Bukkit.getPlayer(sender).teleport(Bukkit.getPlayer(receiver))
    }

}