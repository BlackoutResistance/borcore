package com.borcore.command

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class Main: CommandExecutor {

    override fun onCommand(sender: CommandSender?, cmd: Command?, label: String?, args: Array<out String>?): Boolean {

        val player: Player = sender as Player
        player.sendMessage("Called main command.")

        return true
    }

}