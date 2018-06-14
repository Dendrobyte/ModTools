package me.markbacon78.modtools.clockbreaker;

import me.markbacon78.modtools.Main;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * Created by Mark on 6/12/2018.
 * Written for project ModTools
 * Please do not use or edit this code unless permissions has been given.
 * If you would like to use this code for modification and/or editing, do so with giving original credit.
 * Contact me on Twitter, @Mobkinz78
 * §
 */
public class ClockBreakerDropListener implements Listener {
    // In case a Moderator drops an item (or attempts to give it to someone...)

    String prefix = Main.getInstance().getPrefix();

    @EventHandler
    public void ClockBreakerDrop(PlayerDropItemEvent event){
        Player dropper = event.getPlayer();
        Item droppedStick = event.getItemDrop();
        ItemStack itemDropped = droppedStick.getItemStack();
        BreakerItem clockBreaker = new BreakerItem(Material.STICK);
        if(itemDropped.equals(clockBreaker.getItem())){
            itemDropped.setAmount(0);
            dropper.sendMessage(prefix + "You've dropped your ClockBreaker and it has thus been destroyed. Please be careful!");
        }
    }


}
