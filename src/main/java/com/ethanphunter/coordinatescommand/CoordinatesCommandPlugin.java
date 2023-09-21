package com.ethanphunter.coordinatescommand;

import org.bukkit.plugin.java.JavaPlugin;
import com.ethanphunter.coordinatescommand.command.CoordinatesCommand;
import org.bukkit.command.PluginCommand;

public class CoordinatesCommandPlugin extends JavaPlugin {
    
    @Override
    public void onEnable() {
        getLogger().info("Starting Coordinates Command Plugin");
        PluginCommand command = this.getCommand("coordinates");
        if (command != null) {
            command.setExecutor(new CoordinatesCommand());
        } else {
            throw new IllegalStateException("Could not register the Coordinates Command!");
        }
    }
}
