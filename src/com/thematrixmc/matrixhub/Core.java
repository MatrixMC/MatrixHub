package com.thematrixmc.matrixhub;

import com.thematrixmc.matrixhub.funshop.PlayerInteract;
import com.thematrixmc.matrixhub.gui.CTGUIHandler;
import com.thematrixmc.matrixhub.listeners.EntityDamage;
import com.thematrixmc.matrixhub.listeners.PlayerJoin;
import com.thematrixmc.matrixhub.listeners.PlayerMove;
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

    @Override
    public void onEnable() {
        for(Entity e : Bukkit.getWorld("Hub").getEntities()){
                e.remove();
	}
        spawnEntities();
        Bukkit.getServer().getPluginManager().registerEvents(new EntityDamage(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new CTGUIHandler(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerInteract(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerMove(), this);

    }

    public void spawnEntities(){
        EntityManager manager = RemoteEntities.createManager(this);
        
        Location funShopLocation = new Location(Bukkit.getWorld("Hub"), -833, 22, 386);
        RemoteEntity funShop = manager.createEntity(RemoteEntityType.Human, funShopLocation, false);
        funShop.setStationary(true);
        funShop.getBukkitEntity().setCustomNameVisible(true);
        funShop.getBukkitEntity().setCustomName("§6Fun§lShop");
        funShop.setName("gamemster2468");
        funShop.getMind().addMovementDesire(new DesireLookAtNearest(funShop, Player.class, 8F), 1);
        funShop.getMind().addBehaviour(new InteractBehavior(funShop) {
            @Override
            public void onInteract(Player player) {
                player.sendMessage("Sorry, but shops aren't implemented in Beta testing, try again later!");
            }
        });
        
        Location accessoriesShopLocation = new Location(Bukkit.getWorld("Hub"), -833, 22, 386);
        RemoteEntity accessoriesShop = manager.createEntity(RemoteEntityType.Human, accessoriesShopLocation, false);
        accessoriesShop.setStationary(true);
        accessoriesShop.getBukkitEntity().setCustomNameVisible(true);
        accessoriesShop.getBukkitEntity().setCustomName("§eAccessories§lShop");
        accessoriesShop.setName("gamemster2468");
        accessoriesShop.getMind().addMovementDesire(new DesireLookAtNearest(funShop, Player.class, 8F), 1);
        accessoriesShop.getMind().addBehaviour(new InteractBehavior(accessoriesShop) {
            @Override
            public void onInteract(Player player) {
                player.sendMessage("Sorry, but shops aren't implemented in Beta testing, try again later!");
            }
        });
    }
}
