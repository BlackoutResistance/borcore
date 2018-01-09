package com.borcore.command

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class List: CommandExecutor{

    override fun onCommand(sender: CommandSender, cmd: Command, label: String, args: Array<String>): Boolean {
        val player: Player = sender as Player
        player.showOnlinePlayers()
        return true
    }

    private fun Player.showOnlinePlayers() {
        sendMessage(Bukkit.getOnlinePlayers()
                .joinToString(", ",
                        "${ChatColor.YELLOW}Online players:",
                        transform = Player::getDisplayName))
    }

}