package fr.mine;

import fr.mine.Commands.CoreEtat;
import fr.mine.Commands.CoreHost;
import fr.mine.Commands.CoreSetHost;
import fr.mine.Commands.GamePlayerRelative;
import fr.mine.Enums.GameState;
import fr.mine.Grade.GradeManager;
import fr.mine.ManageGame.GameManager;
import fr.mine.RelativePlayer.PlayerJoin;
import fr.mine.RelativePlayer.PlayerMove;
import fr.mine.Task.Timer;
import fr.mine.Utils.Title;
import fr.minuskube.inv.InventoryManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Main extends JavaPlugin {

    public static Main instance;

    public Main() {
        super();
    }

    public static Main getInstance(){ return instance;}

    private InventoryManager inventoryManager;

    public InventoryManager getInventoryManager() {
        return inventoryManager;
    }
    private ScheduledExecutorService executorMonoThread;
    private ScheduledExecutorService scheduledExecutorService;

    public Title title = new Title();
    public GameManager getGameManager() {
        return gameManager;
    }
    public void setGameManager(GameManager gameManager) {
        this.gameManager = gameManager;
    }
    GameManager gameManager = new GameManager();
    GradeManager gradeManager;
    public GradeManager getGradeManager() {
        return gradeManager;
    }


    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onDisable() {
    }

    @Override
    public void onEnable() {
        this.inventoryManager = new InventoryManager(this);
        this.inventoryManager.init();
        this.gradeManager = new GradeManager();

        this.getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        this.getServer().getPluginManager().registerEvents(new PlayerMove(), this);
        this.getCommand("corestat").setExecutor(new GamePlayerRelative());
        this.getCommand("CoreSetHost").setExecutor(new CoreSetHost());
        this.getCommand("coreetat").setExecutor(new CoreEtat());
        this.getCommand("corehost").setExecutor(new CoreHost());
        this.scheduledExecutorService = Executors.newScheduledThreadPool(16);
        this.executorMonoThread = Executors.newScheduledThreadPool(1);


        Bukkit.getScheduler().runTaskTimer(this, new BukkitRunnable() {
            @Override
            public void run() {

                Player[] players = getServer().getOnlinePlayers().toArray(new Player[0]);
                int playersnum = players.length;

                if(Main.getInstance().getGameManager().getGameState().equals(GameState.WAITING)){
                    for (Player player : players) {
                        Main.getInstance().title.sendActionBar(player, Main.getInstance().gameManager.getPrefix() + " " + Main.getInstance().getGameManager().getGameState().getName() + " §7avec §f" + playersnum + " / " + gameManager.getPlayersize() + " §7en §f" + gameManager.getUhcType().getName().toUpperCase());
                    }
                }

                if(Main.getInstance().getGameManager().getPlayersize() < 1){
                    Main.getInstance().getGameManager().setPlayersize(24);
                }else if(Main.getInstance().getGameManager().getPlayersize() > 150){
                    Main.getInstance().getGameManager().setPlayersize(24);
                }

                if(Main.getInstance().gameManager.getGameState().equals(GameState.GAME)){
                    Timer timer = new Timer();
                    timer.runTaskTimer(Main.getInstance(), 0, 20);
                }

                if(playersnum == Main.getInstance().gameManager.getPlayersize()){
                    Main.getInstance().getGameManager().setGameState(GameState.STARTING);
                }


            }

        },1,5L);

    }


}