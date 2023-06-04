package fr.mine.Inventory;

import fr.mine.Enums.GameState;
import fr.mine.Enums.UHCType;
import fr.mine.Main;

import fr.mine.Utils.ItemBuilder;
import fr.minuskube.inv.ClickableItem;
import fr.minuskube.inv.SmartInventory;
import fr.minuskube.inv.content.InventoryContents;
import fr.minuskube.inv.content.InventoryProvider;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

public class GuiChoise implements InventoryProvider {

    public static final SmartInventory INV = SmartInventory.builder()
            .id("GuiChoise")
            .manager(Main.getInstance().getInventoryManager())
            .provider(new GuiChoise())
            .size(3,9)
            .title(" §fVotre Host")
            .type(InventoryType.CHEST)
            .build();

    @Override
    public void init(Player player, InventoryContents contents) {
    }

    @Override
    public void update(Player player, InventoryContents contents) {
        contents.set(1,3,ClickableItem.of(Meetup,inventoryClickEvent -> {
            Main.getInstance().getGameManager().setUhcType(UHCType.MEETUP);
            GuiMeetupChoise.INV.open(player);
        }));
        contents.set(1,4,ClickableItem.of(Classico,inventoryClickEvent -> {
            Main.getInstance().getGameManager().setUhcType(UHCType.CLASSICO);
            GuiHostPrinci.INV.open(player);
        }));
        contents.set(1,5,ClickableItem.of(UhcModeDeJeux,inventoryClickEvent -> {
            Main.getInstance().getGameManager().setUhcType(UHCType.MODEDEJEUX);
            GuiHostPrinci.INV.open(player);
        }));
    }


    ItemStack Meetup = new ItemBuilder(Material.WOOL, 1, (short) 3)
            .setName("§3Meetup")
            .setLore(" §bConfigure ton Host comme une Meetup ")
            .toItemStack();

    ItemStack Classico = new ItemBuilder(Material.WOOL, 1, (short) 4)
            .setName("§eClassico")
            .setLore(" §bConfigure ton Host comme un Classico UHC")
            .toItemStack();

    ItemStack UhcModeDeJeux = new ItemBuilder(Material.WOOL, 1, (short) 14)
            .setName("§cMode De Jeux")
            .setLore(" §bConfigure ton Host comme un Mode De Jeux UHC")
            .toItemStack();
}
