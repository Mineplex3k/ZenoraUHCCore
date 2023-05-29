package fr.mine;

import fr.mine.Commands.GamePlayerRelative;
import fr.mine.ManageGame.GameManager;
import fr.mine.RelativePlayer.PlayerJoin;
import fr.mine.utils.Title;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static Main instance;
    public static Main getInstance(){ return instance;}

    public Title title = new Title();


    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onDisable() {
    }

    @Override
    public void onEnable() {
        GameManager gameManager = new GameManager();

        this.getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        this.getCommand("corestat").setExecutor(new GamePlayerRelative());


        Bukkit.broadcastMessage(gameManager.getGameState().getName().toLowerCase());
    }



}