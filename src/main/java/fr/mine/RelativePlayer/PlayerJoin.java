package fr.mine.RelativePlayer;

import fr.mine.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();

        if(player.hasPermission("op")){
            Main.getInstance().title.sendActionBar(player, " §cZenoraCoreUHC est activé ");
        }else{
            Main.getInstance().title.sendActionBar(player, " §bMerci de Patienter, l'§lHost §bprepare l'ouverture");
        }
    }
}
