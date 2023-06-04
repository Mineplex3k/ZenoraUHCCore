package fr.mine.Commands;

import fr.mine.Enums.UHCType;
import fr.mine.Inventory.GuiChoise;
import fr.mine.Inventory.GuiHostPrinci;
import fr.mine.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class CoreHost implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(Main.getInstance().getGameManager().getUhcType().getName().equals(UHCType.NONE.getName())){
            GuiChoise.INV.open((Player) commandSender);
        }else{
            GuiHostPrinci.INV.open((Player) commandSender);
        }


        return false;
    }

}
