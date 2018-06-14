package me.markbacon78.modtools;

import me.markbacon78.modtools.clockbreaker.ClockBreakInventoryMoveListener;
import me.markbacon78.modtools.clockbreaker.ClockBreakListener;
import me.markbacon78.modtools.clockbreaker.ClockBreakerDropListener;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.HashMap;

/**
 * Created by Mark on 6/12/2018.
 * Written for project ModTools
 * Please do not use or edit this code unless permissions has been given.
 * If you would like to use this code for modification and/or editing, do so with giving original credit.
 * Contact me on Twitter, @Mobkinz78
 * §
 */
public class Main extends JavaPlugin {

    private static Main main;
    private static String prefix = "§8[§3ModTools§8]§3 ";
    private static HashMap<Player, Integer> clockBreakerClicks = new HashMap<Player, Integer>(); // Used for limiting clicks for the clockbreaker item.

    @Override
    public void onEnable(){
        Bukkit.getServer().getLogger().info(prefix + "ModTools " + getDescription().getVersion() + " has successfully been enabled!");
        if(main != null){
            this.main = this;
        }

        makeConfig();

        // Enable commands
        this.getCommand("modtools").setExecutor(new CommandBase());

        // Register events
        Bukkit.getServer().getPluginManager().registerEvents(new ClockBreakListener(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new ClockBreakerDropListener(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new ClockBreakInventoryMoveListener(), this);
    }

    @Override
    public void onDisable(){

    }

    public void makeConfig(){
        if(!getDataFolder().exists()){
            getDataFolder().mkdirs();
        }
        File file = new File(getDataFolder(), "config.yml");
        if(!file.exists()){
            getLogger().info("Config.yml for ModTools not found, creating now...");
            saveDefaultConfig();
        } else {
            getLogger().info("Config.yml found for ModTools, loading now...");
        }
    }

    public static Main getInstance(){
        return main;
    }

    public static String getPrefix(){
        return prefix;
    }

    public static HashMap<Player, Integer> getClockBreakerClicks(){
        return clockBreakerClicks;
    }

}
