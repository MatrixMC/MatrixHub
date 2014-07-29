package com.thematrixmc.matrixhub.gui;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CompassTeleportGUI {

    public static Inventory getCompassInventory(){
        Inventory inv = Bukkit.createInventory(null, 9, "§7Where should we go?");
        {
            ItemStack item = new ItemStack(Material.BOOK, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§dHub");
            List<String> lore = new ArrayList<>();
            lore.add("§6Teleport back to the hub of the server.");
            meta.setLore(lore);
            item.setItemMeta(meta);
            inv.setItem(0, item);
            inv.setItem(8, item);
        }
        {
            ItemStack item = new ItemStack(Material.EGG, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§3Fun§lShop");
            List<String> lore = new ArrayList<>();
            lore.add("§6Teleport to the fun shop. You can guess what it does. Oooh, aaah.");
            meta.setLore(lore);
            item.setItemMeta(meta);
            inv.setItem(4, item);
        }
        
        {
            ItemStack item = new ItemStack(Material.STONE_SWORD, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§a1v1");
            List<String> lore = new ArrayList<>();
            lore.add("§6Teleport to the 1v1 board, where you can find different arenas to join.");
            meta.setLore(lore);
            item.setItemMeta(meta);
            inv.setItem(3, item);
        }
        {
            ItemStack item = new ItemStack(Material.IRON_SWORD, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§c4v4");
            List<String> lore = new ArrayList<>();
            lore.add("§6Teleport to the 4v4 board, where you can find different arenas to join.");
            meta.setLore(lore);
            item.setItemMeta(meta);
            inv.setItem(4, item);
        }
        {
            ItemStack item = new ItemStack(Material.DIAMOND_SWORD, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§eFFA");
            List<String> lore = new ArrayList<>();
            lore.add("§6Teleport to the FFA board, where you can find different arenas to join.");
            meta.setLore(lore);
            item.setItemMeta(meta);
            inv.setItem(5, item);
        }
        {
            ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§bAccessories§lShop");
            List<String> lore = new ArrayList<>();
            lore.add("§6Teleport to the accessories shop, where you can buy some vanity items in return for tokens.");
            meta.setLore(lore);
            item.setItemMeta(meta);
            inv.setItem(6, item);
        }
        return inv;
    }
    
    public static Location getHubLocation(){
        return Bukkit.getWorld("Hub").getSpawnLocation();
    }
    public static Location getFunShopLocation(){
        Location loc = new Location(Bukkit.getWorld("Hub"), 0, 0, 0);
        return loc;
    }
    public static Location get1v1Location(){
        Location loc = new Location(Bukkit.getWorld("Hub"), 1, Integer.parseInt("v"), 1);
        return loc;
    }
    public static Location get4v4Location(){
        Location loc = new Location(Bukkit.getWorld("Hub"), 4, Integer.parseInt("v"), 4);
        return loc;
    }
    public static Location getFFALocation(){
        Location loc = new Location(Bukkit.getWorld("Hub"), 69, 69, 69);
        return loc;
    }
    public static Location getAccessoriesShopLocation(){
        Location loc = new Location(Bukkit.getWorld("Hub"), 1337, 1337, 1337);
        return loc;
    }
}
