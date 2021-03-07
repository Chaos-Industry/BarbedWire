package com.github.chaosindustory.barbedwire;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.ItemStack;
import org.bukkit.event.Listener;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class Coral implements Listener {

    @EventHandler
    public void CoralMethod(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Location loc = player.getLocation();
        Block b = loc.getBlock();
        if (b.getRelative(0, 0, 0).getType().equals(Material.DEAD_BRAIN_CORAL)) {
            player.damage(2);
            player.setVelocity(player.getLocation().getDirection().multiply(-0.1));
        }
    }

    @EventHandler
    public void SwordMethod(PlayerInteractEvent event) {
        if (event.getAction().toString().equalsIgnoreCase("RIGHT_CLICK_BLOCK")) {
            if (event.getClickedBlock().getType().toString().equalsIgnoreCase("DEAD_BRAIN_CORAL")) {
                Player player = event.getPlayer();
                ItemStack items = player.getInventory().getItemInMainHand();
                String item = items.getType().toString();
                String regex = "SWORD";
                Pattern p = Pattern.compile(regex);
                Matcher match = p.matcher(item);
                if (match.find()) {
                    Location loc = event.getClickedBlock().getLocation();
                    Block b = loc.getBlock();
                    b.setType(Material.AIR);
                }
            }
        }
    }
}

