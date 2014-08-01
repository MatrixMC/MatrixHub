package com.thematrixmc.matrixhub;

import com.thematrixmc.matrixhub.funshop.PlayerInteract;
import com.thematrixmc.matrixhub.gui.CTGUIHandler;
import com.thematrixmc.matrixhub.listeners.EntityDamage;
import com.thematrixmc.matrixhub.listeners.PlayerJoin;
import com.thematrixmc.matrixhub.listeners.PlayerMove;
import com.thematrixmc.matrixhub.visibility.Visibility;
import de.kumpelblase2.remoteentities.EntityManager;
import de.kumpelblase2.remoteentities.RemoteEntities;
import de.kumpelblase2.remoteentities.api.RemoteEntity;
import de.kumpelblase2.remoteentities.api.RemoteEntityType;
import de.kumpelblase2.remoteentities.api.thinking.InteractBehavior;
import de.kumpelblase2.remoteentities.api.thinking.goals.DesireLookAtNearest;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin{
    
    public static Core instance;

    @Override
    public void onEnable() {
        for(Entity e : Bukkit.getWorld("Hub").getEntities()){
                e.remove();
	}
        getConfig().options().copyDefaults(true);
        saveConfig();
        spawnEntities();
        Bukkit.getServer().getPluginManager().registerEvents(new EntityDamage(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new CTGUIHandler(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerInteract(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerMove(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new Visibility(), this);

    }

    public void spawnEntities(){
        EntityManager manager = RemoteEntities.createManager(instance);
        
        Location funShopLocation = new Location(Bukkit.getWorld("Hub"), -127, 73, 222);
        RemoteEntity funShop = manager.createEntity(RemoteEntityType.Villager, funShopLocation, false);
        funShop.setStationary(true);
        funShop.getBukkitEntity().setCustomNameVisible(true);
        funShop.getBukkitEntity().setCustomName("§6Fun§lShop");
        funShop.getMind().addBehaviour(new InteractBehavior(funShop) {
            @Override
            public void onInteract(Player player) {
                player.sendMessage("Sorry, but shops aren't implemented in Beta testing, try again later!");
            }
        });
        
        Location accessoriesShopLocation = new Location(Bukkit.getWorld("Hub"), -136, 73, 222);
        RemoteEntity accessoriesShop = manager.createEntity(RemoteEntityType.Villager, accessoriesShopLocation, false);
        accessoriesShop.setStationary(true);
        accessoriesShop.getBukkitEntity().setCustomNameVisible(true);
        accessoriesShop.getBukkitEntity().setCustomName("§eAccessories§lShop");
        accessoriesShop.getMind().addMovementDesire(new DesireLookAtNearest(funShop, Player.class, 8F), 1);
        accessoriesShop.getMind().addBehaviour(new InteractBehavior(accessoriesShop) {
            @Override
            public void onInteract(Player player) {
                player.sendMessage("Sorry, but shops aren't implemented in Beta testing, try again later!");
            }
        });
    }
}
