package fr.mine.Commands;

import fr.mine.Enums.GameState;
import fr.mine.Enums.UHCType;
import fr.mine.Main;
import fr.mine.ManageGame.GameManager;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamePlayerRelative implements CommandExecutor {

    GameManager gameManager = new GameManager();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        Player player = (Player) commandSender;
        Location ploc = player.getLocation();

        if(player.hasPermission("op")){
            player.sendMessage(" §m- - - - - - - - - - - - - - - - - - - ");
            player.sendMessage(" Stats de votre §cHost §f: " );
            player.sendMessage("  Votre Partie est actuellement sur :");
            player.sendMessage("     - " + Main.getInstance().getGameManager().getGameState().getName().toUpperCase());
            player.sendMessage("  Votre Partie est un : ");
            player.sendMessage("     - " + Main.getInstance().getGameManager().getUhcType().getName().toUpperCase());
            player.sendMessage("  Votre Partie peut contenir un maximum de :");
            player.sendMessage("     - " + Main.getInstance().getGameManager().getPlayersize() + " joueurs.");
            player.sendMessage("  L'invicibilité durera : ");
            player.sendMessage("     - " + Main.getInstance().getGameManager().getInvinci() + " Minutes.");
            if(Main.getInstance().getGameManager().getUhcType().getName().equals(UHCType.MODEDEJEUX.getName())){
                player.sendMessage( "  Les Roles seront distribués a partir de :");
                player.sendMessage("     - " + Main.getInstance().getGameManager().getRoledistritime() + " Minutes.");
                player.sendMessage(" §m- - - - - - - - - - - - - - - - - - - ");
            }else{
                player.sendMessage(" §m- - - - - - - - - - - - - - - - - - - ");
            }
            player.sendMessage(" ");
            player.sendMessage(Main.getInstance().getGameManager().getPrefix() + " Bon Host sur notre serveur.");

        }else{
            player.sendMessage(Main.getInstance().getGameManager().getPrefix() + " §cVous n'avez pas la permission d'executer cette commande. ");
            player.playSound(ploc, Sound.VILLAGER_HIT, 1F, 1F);
        }

        return false;
    }
}
