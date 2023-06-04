package fr.mine.Utils;

import net.md_5.bungee.api.ChatColor;

public class ChatUtils {

    public static String ChatFormat(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

}
