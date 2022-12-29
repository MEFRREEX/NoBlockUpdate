package noupdate;

import cn.nukkit.event.Listener;
import cn.nukkit.plugin.PluginBase;
import noupdate.listeners.EventListener;

public class Main extends PluginBase implements Listener {
        
    public void onEnable() {
        this.saveDefaultConfig();
        this.getServer().getPluginManager().registerEvents(new EventListener(this), this);
    }  
}
