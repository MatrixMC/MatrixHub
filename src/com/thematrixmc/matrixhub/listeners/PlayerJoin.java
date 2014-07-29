package com.thematrixmc.matrixhub.listeners;

import com.thematrixmc.matrixhub.funshop.KittehCannon;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener{
        
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        event.getPlayer().getInventory().setItem(4, KittehCannon.getKittyCannon());
    }
}
