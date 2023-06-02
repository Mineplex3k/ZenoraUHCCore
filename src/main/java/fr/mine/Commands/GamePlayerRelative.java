package fr.mine.Commands;

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
            player.sendMessage(" Stats de votre Game : " );
            player.sendMessage(   " - " + Main.getInstance().getGameManager().getGameState().getName().toUpperCase());


        }else{
            player.sendMessage("§b[Zenora] §7| §cVous n'avez pas la permission d'executer cette commande. ");
            player.playSound(ploc, Sound.VILLAGER_HIT, 1F, 1F);
        }

        return false;
    }
}
