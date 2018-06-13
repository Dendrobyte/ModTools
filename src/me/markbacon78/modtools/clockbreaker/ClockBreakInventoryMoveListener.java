package me.markbacon78.modtools.clockbreaker;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

/**
 * Created by Mark on 6/13/2018.
 * Written for project ModTools
 * Please do not use or edit this code unless permissions has been given.
 * If you would like to use this code for modification and/or editing, do so with giving original credit.
 * Contact me on Twitter, @Mobkinz78
 * §
 */
public class ClockBreakInventoryMoveListener implements Listener {

    @EventHandler
    public void onPlayerMoveClockBreaker(InventoryClickEvent event){
        // TODO: Make it so someone can't click on the clockbreaker to move it (it's always added to slot 0)
    }

}
