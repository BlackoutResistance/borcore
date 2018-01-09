package com.borcore.command

import com.borcore.teleport.Request
import com.borcore.teleport.TeleportContainer
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class Teleport: CommandExecutor {

    override fun onCommand(sender: CommandSender, cmd: Command, label: String, args: Array<String>): Boolean {

        val player: Player = sender as Player

        //TODO Add some colors!
        val message: String? = when(label) {
            "tpa" -> {
                if(args.size != 1) return false
                val receiver: Player = Bukkit.getPlayer(args[0])
                TeleportContainer.addRequestToQueue(Request(player.uniqueId, receiver.uniqueId))
                receiver.sendMessage("${sender.name} has requested to teleport to you.")
                "Teleport request sent to ${receiver.name}."
            }
            "tpaccept" -> {
                if(TeleportContainer.findRequestByReceiver(player.uniqueId)?.accept() == null)
                    "No pending requests."
                else "Teleport request accepted."
            }
            "tpdeny" -> {
                val request = TeleportContainer.findRequestByReceiver(player.uniqueId)
                if(request == null) "No pending requests."
                else {
                    TeleportContainer.removeRequestFromQueue(request)
                    "Teleport request denied."
                }
            }
            else -> "Unknown error."
        }

        player.sendMessage(message)

        return true
    }

}