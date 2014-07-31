package com.thematrixmc.matrixhub.visibility;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class Visibility implements Listener{
    
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        if (e.getPlayer().hasPermission("vanishtorch.use")) {
            if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                if (e.getItem().getType() == Material.SUGAR) {
                    Player player = e.getPlayer();
                    for (Player other : Bukkit.getOnlinePlayers()) {
                        player.hidePlayer(other);
                        player.playSound(player.getLocation(), Sound.ANVIL_LAND, 10, 1);
                        player.getInventory().remove(new ItemStack(Material.SUGAR));
                        player.getInventory().addItem(new ItemStack(Material.SULPHUR));
                        player.sendMessage("§eMatrixMC §8\u275A §3Players have been hidden!");
                        return;
                    }
                    return;
                }
                if (e.getItem().getType() == Material.SULPHUR) {
                    Player player = e.getPlayer();
                    for (Player other : Bukkit.getOnlinePlayers()) {
                        player.showPlayer(other);
                        player.playSound(player.getLocation(), Sound.ANVIL_BREAK, 10, 1);
                        player.getInventory().remove(new ItemStack(Material.SULPHUR));
                        player.getInventory().addItem(new ItemStack(Material.SUGAR));
                        player.sendMessage("§eMatrixMC §8\u275A §3Players have been shown!");
                        return;
                    }
                    return;
                }
            }
        }
    }

}
