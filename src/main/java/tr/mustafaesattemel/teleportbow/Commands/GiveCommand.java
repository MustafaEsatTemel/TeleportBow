package tr.mustafaesattemel.teleportbow.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import tr.mustafaesattemel.teleportbow.Utility.BowUtils;

public class GiveCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player ){
            Player player = (Player) sender;
            if(player.hasPermission("tpbow.getbow")){
                if(args.length==0){

                    ItemStack bow = BowUtils.createTeleportBow();
                    player.getInventory().addItem(bow);
                    player.getInventory().addItem(new ItemStack(Material.ARROW,1));
                    player.sendMessage(ChatColor.GOLD+"You have been given a teleport bow!!!");


                }else{
                    Player target = Bukkit.getPlayerExact(args[0]);

                    if(target==null){
                        player.sendMessage(ChatColor.LIGHT_PURPLE+"This player is not online or does not exist.");

                        return false;
                    }
                    ItemStack bow = BowUtils.createTeleportBow();
                    target.getInventory().addItem(bow);
                    target.getInventory().addItem(new ItemStack(Material.ARROW,1));
                    target.sendMessage(ChatColor.GOLD+"You have been given a teleport bow!!!");
                }

            }else{
                player.sendMessage("You dont have permission");
            }

        }



        return false;
    }

}
