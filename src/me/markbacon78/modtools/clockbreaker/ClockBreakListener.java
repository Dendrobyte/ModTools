package me.markbacon78.modtools.clockbreaker;

import me.markbacon78.modtools.Main;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Mark on 6/12/2018.
 * Written for project ModTools
 * Please do not use or edit this code unless permissions has been given.
 * If you would like to use this code for modification and/or editing, do so with giving original credit.
 * Contact me on Twitter, @Mobkinz78
 * §
 */
public class ClockBreakListener implements Listener {

    String prefix = Main.getInstance().getPrefix();

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event){
        if(event.getBlock().getType().equals(Material.GRASS)){
            event.setCancelled(true);
            event.getPlayer().sendMessage("Protected area that you can't edit, almost like a plot...");
        }
    }

    @EventHandler
    public void onClockBreak(BlockBreakEvent event){
        Player player = event.getPlayer();
        Block block = event.getBlock(); // To be used for the block check. See the TO-DO below.
        ItemStack itemInHand = player.getInventory().getItemInMainHand();
        BreakerItem clockBreaker = new BreakerItem(Material.STICK);
        if(!itemInHand.equals(clockBreaker.getItem())){
            return;
        }
        else if(itemInHand.equals(clockBreaker.getItem())){
            // TODO: Check to make sure they are in the creative world (Add a config value!)
            if(!player.hasPermission("modtools.use")){
                player.sendMessage(prefix + "§4You can't use that tool!");
                player.getInventory().getItemInMainHand().setAmount(0);

                
                return;
            }
            player.sendMessage(prefix + "Removing item which is assumably part of a clock!");
            event.setCancelled(false); // Careful!
        }

    }

}
