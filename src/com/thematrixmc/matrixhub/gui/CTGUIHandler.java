package com.thematrixmc.matrixhub.gui;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;


public class CTGUIHandler implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (event.getInventory().getTitle().equalsIgnoreCase("[ST] Quick Links")) {
            if (event.getCurrentItem() != null && event.getCurrentItem().getType() != null) {
                event.setCancelled(true);
                Player player = (Player) event.getWhoClicked();
                if (event.getCurrentItem().hasItemMeta() && event.getCurrentItem().getItemMeta().hasDisplayName()) {
                    event.setCancelled(true);
                    ItemStack clicked = event.getCurrentItem();
                    if (clicked != null) {
                        if (event.getCurrentItem().getItemMeta().getDisplayName().contains("§dHub")) {
                            player.teleport(CompassTeleportGUI.getHubLocation());
                        }
                        if (event.getCurrentItem().getItemMeta().getDisplayName().contains("§3Fun§lShop")) {
                            player.teleport(CompassTeleportGUI.getFunShopLocation());
                        }
                        if (event.getCurrentItem().getItemMeta().getDisplayName().contains("§a1v1")) {
                            player.teleport(CompassTeleportGUI.get1v1Location());
                        }
                        if (event.getCurrentItem().getItemMeta().getDisplayName().contains("§c4v4")) {
                            player.teleport(CompassTeleportGUI.get4v4Location());
                        }
                        if (event.getCurrentItem().getItemMeta().getDisplayName().contains("§eFFA")) {
                            player.teleport(CompassTeleportGUI.getFFALocation());
                        }
                        if (event.getCurrentItem().getItemMeta().getDisplayName().contains("§bAccessories§lShop")) {
                            player.teleport(CompassTeleportGUI.getAccessoriesShopLocation());
                            
                        }
                    }

                }
            }
        }
    }

}
