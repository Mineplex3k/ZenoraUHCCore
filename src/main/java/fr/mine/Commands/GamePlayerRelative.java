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

        if(player.hasPermission("op") || gameManager.getGameState().getName().equalsIgnoreCase("Fermeture")){
            player.sendMessage(" §m- - - - - - - - - - - - - - - - - - - ");
            player.sendMessage(" Stats de votre Game : " );
            if(gameManager.getGameState().getName().equalsIgnoreCase("en attente")){
                player.sendMessage("    §7Statue §f: - §6En Attente");
            }else if(gameManager.getGameState().getName().equalsIgnoreCase("en jeu")){
                player.sendMessage("    §7Statue §f: - §aEn Jeu");
            } else if(gameManager.getGameState().getName().equalsIgnoreCase("lancement")) {
                player.sendMessage("    §7Statue §f: - §cLancement");
            }

        }else{
            player.sendMessage("§b[Zenora] §7| §cVous n'avez pas la permission d'executer cette commande. ");
            player.playSound(ploc, Sound.VILLAGER_HIT, 1F, 1F);
        }

        return false;
    }
}
