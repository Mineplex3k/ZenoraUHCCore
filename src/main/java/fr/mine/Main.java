package fr.mine;

import fr.mine.RelativePlayer.PlayerJoin;
import fr.mine.utils.Title;
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
        this.getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
    }


}