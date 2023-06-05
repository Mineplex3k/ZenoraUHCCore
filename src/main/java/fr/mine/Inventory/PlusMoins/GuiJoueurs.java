package fr.mine.Inventory.PlusMoins;

import fr.mine.Inventory.GuiHostPrinci;
import fr.mine.Main;
import fr.mine.Utils.ItemBuilder;
import fr.minuskube.inv.ClickableItem;
import fr.minuskube.inv.SmartInventory;
import fr.minuskube.inv.content.InventoryContents;
import fr.minuskube.inv.content.InventoryProvider;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

import static org.bukkit.Bukkit.getServer;

public class GuiJoueurs implements InventoryProvider {
    public static final SmartInventory INV = SmartInventory.builder()
            .id("GuiPlayerMoinsPlus")
            .manager(Main.getInstance().getInventoryManager())
            .provider(new GuiJoueurs())
            .size(3,9)
            .title("§fJoueurs - | + ")
            .type(InventoryType.CHEST)
            .build();

    Player[] players = getServer().getOnlinePlayers().toArray(new Player[0]);
    int playersnum = players.length;

    @Override
    public void init(Player player, InventoryContents contents) {

    }
    @Override
    public void update(Player player, InventoryContents contents) {
        contents.set(1,4, ClickableItem.of(affichage, inventoryClickEvent -> {
        }));

        contents.set(1,5, ClickableItem.of(plus, inventoryClickEvent -> {
            Main.getInstance().getGameManager().setPlayersize(+1);
        }));

        contents.set(1,3,  ClickableItem.of(moins, inventoryClickEvent -> {
            Main.getInstance().getGameManager().setPlayersize(-1);
        }));

        contents.set(2, 8, ClickableItem.of(quitter,inventoryClickEvent -> {
            GuiHostPrinci.INV.open(player);
        }));


    }

    ItemStack affichage = new ItemBuilder(Material.BOOK)
            .setName(" §7" + Main.getInstance().getGameManager().getPlayersize())
            .setLore(" Nombre de joueurs connecté actuellement : §b" + playersnum)
            .toItemStack();

    ItemStack plus = new ItemBuilder(Material.WOOL)
            .setName(" §a+ ")
            .setLore(" §7Augmente le nombre de joueurs disponible dans la partie.")
            .toItemStack();
    ItemStack moins = new ItemBuilder(Material.WOOL)
            .setName(" §c-")
            .setLore(" §7Diminue le nombre de joueurs disponible dans la partie.")
            .toItemStack();

    ItemStack quitter = new ItemBuilder(Material.BARRIER)
            .setName(" Retour au Menu ")
            .toItemStack();
}
