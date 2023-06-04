package fr.mine.RelativePlayer;

import fr.mine.Enums.GameState;
import fr.mine.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMove implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event){
        if(Main.getInstance().getGameManager().getGameState().getName().equals(GameState.WAITING.getName())){
            //Main.getInstance().title.sendActionBar(event.getPlayer(), Main.getInstance().getGameManager().getPrefix() + " " + Main.getInstance().getGameManager().getGameState().getName().toUpperCase());
        }
    }
}
