package noupdate.listeners;

import java.util.List;

import cn.nukkit.block.BlockID;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.block.BlockUpdateEvent;
import cn.nukkit.event.block.LeavesDecayEvent;
import cn.nukkit.event.player.PlayerInteractEvent;
import cn.nukkit.utils.Config;
import noupdate.Main;

public class EventListener implements Listener {

    Config config;
    Main plugin;
        
    public EventListener(Main plugin) {
        this.plugin = plugin;
        this.config = plugin.getConfig();
    }
    
    @EventHandler
    public void onDecay(LeavesDecayEvent event) {
        if (config.getBoolean("decay.protect-all")) { 
            event.setCancelled(true);
        } else {
            List<String> worlds = config.getStringList("decay.worlds");
            String level = event.getBlock().getLevel().getName();
            if (worlds.contains(level)) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onUpdate(BlockUpdateEvent event) {
        if (config.getBoolean("update.protect-all")) { 
            event.setCancelled(true);
        } else {
            List<String> worlds = config.getStringList("update.worlds");
            String level = event.getBlock().getLevel().getName();
            if (worlds.contains(level)) {
                event.setCancelled(true);
            }
        }
    }
    
    @EventHandler
    public void onField(PlayerInteractEvent event) {
        if (config.getBoolean("field.protect-all")) { 
            if (event.getAction() == PlayerInteractEvent.Action.PHYSICAL) {
                if (event.getBlock().getId() == BlockID.FARMLAND) {
                    event.setCancelled();
                }
            }
        } else {
            List<String> worlds = config.getStringList("field.worlds");
            String level = event.getBlock().getLevel().getName();
            if (worlds.contains(level)) {
                if (event.getAction() == PlayerInteractEvent.Action.PHYSICAL) {
                    if (event.getBlock().getId() == BlockID.FARMLAND) {
                        event.setCancelled();
                    }
                }
            }
        }
    }
}
