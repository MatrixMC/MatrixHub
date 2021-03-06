package com.thematrixmc.matrixhub.funshop;

import com.thematrixmc.matrixhub.gui.CompassTeleportGUI;
import com.thematrixmc.matrixhub.particles.ParticleUtils;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Ocelot;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerInteract implements Listener{
    
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event){
        Player player = event.getPlayer();
        ItemStack item = event.getItem();
        if(item != KittehCannon.getKittyCannon() | item.getType() != Material.COMPASS){
            return;
        }
        if(item == KittehCannon.getKittyCannon()){
            if(event.getAction() == Action.RIGHT_CLICK_AIR | event.getAction() == Action.LEFT_CLICK_AIR){
                if(player.hasPermission("kittycannon.funparticles")){
                   Ocelot ocelot = (Ocelot) player.getWorld().spawnEntity(player.getLocation(), EntityType.OCELOT);
                    if (ocelot == null){
                        return;
                    }
                    Random random = new Random();
                    int i = random.nextInt(Ocelot.Type.values().length);
                    ocelot.setCatType(Ocelot.Type.values()[i]);
                    ocelot.setTamed(true);
                    ocelot.setBaby();
                    ocelot.setVelocity(player.getEyeLocation().getDirection().multiply(2));
                    try {
                     ParticleUtils.spawnParticles(ocelot.getLocation(), player, "heart", 69);
                     ParticleUtils.spawnParticles(ocelot.getLocation(), player, "flame", 42);
                     ParticleUtils.spawnParticles(ocelot.getLocation(), player, "slime", 22);
                    } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | NoSuchFieldException | IllegalArgumentException | InvocationTargetException ex) {
                    } 
                }else{
                    Ocelot ocelot = (Ocelot) player.getWorld().spawnEntity(player.getLocation(), EntityType.OCELOT);
                    if (ocelot == null){
                        return;
                    }
                    Random random = new Random();
                    int i = random.nextInt(Ocelot.Type.values().length);
                    ocelot.setCatType(Ocelot.Type.values()[i]);
                    ocelot.setTamed(true);
                    ocelot.setBaby();
                    ocelot.setVelocity(player.getEyeLocation().getDirection().multiply(2));
                }
            } 
        }
        if(item.getType() == Material.COMPASS){
            if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK){
                player.openInventory(CompassTeleportGUI.getCompassInventory());
            }
        }
    }
}
