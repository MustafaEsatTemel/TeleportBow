package tr.mustafaesattemel.teleportbow.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import tr.mustafaesattemel.teleportbow.Main;
import tr.mustafaesattemel.teleportbow.Utility.BowUtils;

public class TeleportBowListener implements Listener {

    private final Main main;

    public TeleportBowListener(Main main){
        this.main=main;
    }

    @EventHandler
    public void onArrowLand(ProjectileHitEvent e){

        if(e.getEntity().getType()== EntityType.ARROW){

            if(e.getEntity().getShooter() instanceof Player){
                Player p = (Player )e.getEntity().getShooter();

                ItemStack itemInMainHand = p.getInventory().getItemInMainHand();

                if(itemInMainHand.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.AQUA+""+ChatColor.BOLD+""+"Teleport Bow")){

                    Location location = e.getEntity().getLocation();
                    p.teleport(location);
                    e.getEntity().remove();
                    p.sendMessage("You have been teleported by the Teleported Bow.");
                    p.playSound(location, Sound.ENTITY_BLAZE_SHOOT,1.0F,1.0F);

                }

            }

        }

    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){

        if(main.getConfig().getBoolean("give-on-join")){

            Player p = e.getPlayer();
            p.getInventory().addItem(BowUtils.createTeleportBow());
            p.getInventory().addItem(new ItemStack(Material.ARROW,1));

            p.sendMessage("You got a perfect grappling bow :)");
        }

    }
}
