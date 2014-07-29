package com.thematrixmc.matrixhub.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMove implements Listener{
   
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event){
        if(event.getPlayer().getLocation().getY() <= 0)
            event.getPlayer().teleport(Bukkit.getWorld("Hub").getSpawnLocation());
    }
}
