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
        showOnlinePlayers(player)
        return true
    }

    private fun showOnlinePlayers(player: Player) {
        player.sendMessage("${ChatColor.YELLOW}Online players:")
        val nameList = Bukkit.getOnlinePlayers().map(Player::getDisplayName)
        player.sendMessage(nameList.joinToString(", "))
    }

}