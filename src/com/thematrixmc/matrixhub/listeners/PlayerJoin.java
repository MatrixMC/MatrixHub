package com.thematrixmc.matrixhub.listeners;

import com.thematrixmc.matrixhub.Core;
import com.thematrixmc.matrixhub.funshop.KittehCannon;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;

public class PlayerJoin implements Listener{
    
    public ItemStack getCompass(){
        ItemStack item = new ItemStack(Material.RAW_FISH, 1, (short) 3);
        ItemMeta im = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        im.setDisplayName("§aQuick §eTeleporter");
        lore.add("§6The ultimate hub item.");
        im.setLore(lore);
        item.setItemMeta(im);
        return item;
    }
    
    public ItemStack getBook(){
        List <String> pages = Core.instance.getConfig().getStringList("BookPages");
        ItemStack bookItem = new ItemStack(Material.WRITTEN_BOOK, 1);
        BookMeta metaData = (BookMeta) bookItem.getItemMeta();
        metaData.setTitle(Core.instance.getConfig().getString("BookName"));
        metaData.setAuthor(Core.instance.getConfig().getString("AuthorName"));
        
        for(String page : pages){
            metaData.addPage(page.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
        }
        
        bookItem.setItemMeta(metaData);
        return bookItem;
    }
        
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        event.getPlayer().getInventory().clear();
        event.getPlayer().getInventory().setItem(0, getCompass());
        event.getPlayer().getInventory().setItem(4, KittehCannon.getKittyCannon());
        event.getPlayer().getInventory().setItem(8, getBook());
    }
}
