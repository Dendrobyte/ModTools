package me.markbacon78.modtools.clockbreaker;

import me.markbacon78.modtools.Main;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Mark on 6/13/2018.
 * Written for project ModTools
 * Please do not use or edit this code unless permissions has been given.
 * If you would like to use this code for modification and/or editing, do so with giving original credit.
 * Contact me on Twitter, @Mobkinz78
 * §
 */
public class ClockBreakInventoryMoveListener implements Listener {

    String prefix = Main.getInstance().getPrefix();

    @EventHandler
    public void onPlayerMoveClockBreaker(InventoryClickEvent event){
        BreakerItem breakerItem = new BreakerItem(Material.STICK);

        ItemStack item = event.getCurrentItem();
        if(item.isSimilar(breakerItem.getItem())){
            event.setCancelled(true);
            Player player = (Player) event.getWhoClicked();
            player.sendMessage(prefix + "Please don't move and/or store the ClockBreaker.");
            player.sendMessage(prefix + "(To remove the item, use it or /clearinventory)");
        }
    }

}
