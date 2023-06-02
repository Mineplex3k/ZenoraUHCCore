package fr.mine.Commands;

import fr.mine.Main;
import fr.mine.Enums.GameState;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CoreEtat implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        Player player = (Player) commandSender;

        if(player.hasPermission("op")){
            if(args.length == 0){
                player.sendMessage(" ");
                player.sendMessage("§b[Zenora] §7| §f/coreetat help !");
                player.sendMessage(" ");
            }else if(args.length == 1 && args[0].equalsIgnoreCase("help")){
                player.sendMessage(" - /corestat lancement");
                player.sendMessage(" - /corestat attente");
                player.sendMessage(" - /corestat game");
            } else if (args.length == 1) {

                if(args[0].equalsIgnoreCase("lancement")){
                    Main.getInstance().getGameManager().setGameState(GameState.STARTING);
                    player.sendMessage(" Etat de : " + Main.getInstance().getGameManager().getGameState().getName().toUpperCase());
                } else if (args[0].equalsIgnoreCase("attente")) {
                    Main.getInstance().getGameManager().setGameState(GameState.WAITING);
                    player.sendMessage(" Etat de : " + Main.getInstance().getGameManager().getGameState().getName().toUpperCase());
                } else if (args[0].equalsIgnoreCase("game")) {
                    Main.getInstance().getGameManager().setGameState(GameState.GAME);
                    player.sendMessage(" Etat de : " + Main.getInstance().getGameManager().getGameState().getName().toUpperCase());
                } else if (args[0].equalsIgnoreCase("finish")) {
                    Main.getInstance().getGameManager().setGameState(GameState.FINISH);
                    player.sendMessage(" Etat de : " + Main.getInstance().getGameManager().getGameState().getName().toUpperCase());
                }else{
                    player.sendMessage(" ");
                    player.sendMessage("§b[Zenora] §7| §cVotre commande est Incorrect");
                    player.sendMessage(" ");
                }

            }
        }
        return false;
    }
}
