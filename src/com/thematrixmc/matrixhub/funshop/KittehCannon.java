package com.thematrixmc.matrixhub.funshop;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class KittehCannon {
    
    public static ItemStack getKittyCannon(){
        ItemStack item = new ItemStack(Material.RAW_FISH, 1, (short) 3);
        ItemMeta im = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        im.setDisplayName("§aK§bi§ct§dt§ey§2§lS§3§lu§4§lr§5§lp§6§lr§8§li§a§ls§b§le");
        lore.add("§8§oA little fish with a big surprise...");
        im.setLore(lore);
        item.setItemMeta(im);
        return item;
        
    }

}
