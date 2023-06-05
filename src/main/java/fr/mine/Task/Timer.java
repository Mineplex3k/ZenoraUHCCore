package fr.mine.Task;

import fr.mine.Enums.GameState;
import fr.mine.Main;
import fr.mine.ManageGame.GameManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import static org.bukkit.Bukkit.getServer;

public class Timer extends BukkitRunnable {

    @Override
    public void run() {

        if(Main.getInstance().getGameManager().getPlayersize() < 1){
            Main.getInstance().getGameManager().setPlayersize(24);
        }else if(Main.getInstance().getGameManager().getPlayersize() > 150){
            Main.getInstance().getGameManager().setPlayersize(24);
        }



    }

}
