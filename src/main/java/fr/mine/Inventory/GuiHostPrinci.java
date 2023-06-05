package fr.mine.Inventory;

import fr.mine.Enums.UHCType;
import fr.mine.Inventory.PlusMoins.GuiJoueurs;
import fr.mine.Main;
import fr.mine.Utils.ItemBuilder;
import fr.minuskube.inv.ClickableItem;
import fr.minuskube.inv.SmartInventory;
import fr.minuskube.inv.content.InventoryContents;
import fr.minuskube.inv.content.InventoryProvider;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

public class GuiHostPrinci implements InventoryProvider {
    public static final SmartInventory INV = SmartInventory.builder()
            .id("GuiHostPrinci")
            .manager(Main.getInstance().getInventoryManager())
            .provider(new GuiHostPrinci())
            .size(6,9)
            .title(" §fConfiguration D'Host")
            .type(InventoryType.CHEST)
            .build();

    @Override
    public void init(Player player, InventoryContents contents){

        ItemStack playernum = new ItemBuilder(Material.DIAMOND_SWORD)
                .setName("§bNombre de joueurs pouvent acceder a la partie")
                .toItemStack();

        ItemStack ChoixJeu = new ItemBuilder(Material.DIAMOND)
                .setName("Recommence ton choix de jeux ?")
                .toItemStack();

        contents.set(0,2, ClickableItem.of(playernum, inventoryClickEvent -> {
            GuiJoueurs.INV.open(player);
        }));

        contents.set(5, 8, ClickableItem.of(ChoixJeu, inventoryClickEvent -> {
            GuiChoise.INV.open(player);
        }));


    }

    @Override
    public void update(Player player, InventoryContents contents) {

        ItemStack meetup = new ItemBuilder(Material.WOOL,1, (short) 3)
                .setName("§b" + Main.getInstance().getGameManager().getUhcType().getName().toUpperCase())
                .setLore(" §fMeetup en Mode : §b" + Main.getInstance().getGameManager().getUhcConfig().getName().toUpperCase())
                .toItemStack();

        ItemStack modedejeux = new ItemBuilder(Material.WOOL,1,(short)4)
                .setName("§e" +  Main.getInstance().getGameManager().getUhcType().getName().toUpperCase())
                .toItemStack();

        ItemStack classico = new ItemBuilder(Material.WOOL, 1, (short) 14)
                .setName("§c" +  Main.getInstance().getGameManager().getUhcType().getName().toUpperCase())
                .toItemStack();

        ItemStack none = new ItemBuilder(Material.BEDROCK)
                .setLore("§cGame non configuré.")
                .setName("NONE")
                .toItemStack();

        if(Main.getInstance().getGameManager().getUhcType().getName().equals(UHCType.MEETUP.getName())){
            contents.set(0,0, ClickableItem.of(meetup, inventoryClickEvent -> {
            }));
        }else if(Main.getInstance().getGameManager().getUhcType().getName().equals(UHCType.CLASSICO.getName())){
            contents.set(0,0,ClickableItem.of(modedejeux, inventoryClickEvent -> {
            }));
        }else if(Main.getInstance().getGameManager().getUhcType().getName().equals(UHCType.MODEDEJEUX.getName())){
            contents.set(0,0, ClickableItem.of(classico, inventoryClickEvent -> {
            }));
        }else {
            contents.set(0,0,ClickableItem.of(none, inventoryClickEvent -> {
                GuiChoise.INV.open(player);
            }));
        }
    }

}
