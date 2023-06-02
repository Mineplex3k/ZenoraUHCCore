package fr.mine;

import fr.mine.Commands.CoreEtat;
import fr.mine.Commands.GamePlayerRelative;
import fr.mine.ManageGame.GameManager;
import fr.mine.RelativePlayer.PlayerJoin;
import fr.mine.Utils.Title;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static Main instance;
    public static Main getInstance(){ return instance;}

    public Title title = new Title();

    public GameManager getGameManager() {
        return gameManager;
    }

    public void setGameManager(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    GameManager gameManager = new GameManager();



    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onDisable() {
    }

    @Override
    public void onEnable() {

        this.getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        this.getCommand("corestat").setExecutor(new GamePlayerRelative());
        this.getCommand("coreetat").setExecutor(new CoreEtat());


        Bukkit.broadcastMessage(this.gameManager.getGameState().getName().toLowerCase());
    }



}