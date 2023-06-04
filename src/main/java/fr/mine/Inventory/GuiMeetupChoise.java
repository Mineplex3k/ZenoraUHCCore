package fr.mine.Inventory;

import fr.mine.Enums.GameState;
import fr.mine.Enums.UHCType;
import fr.mine.Main;
import fr.mine.Utils.ItemBuilder;
import fr.minuskube.inv.ClickableItem;
import fr.minuskube.inv.SmartInventory;
import fr.minuskube.inv.content.InventoryContents;
import fr.minuskube.inv.content.InventoryProvider;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

public class GuiMeetupChoise implements InventoryProvider {

    public static final SmartInventory INV = SmartInventory.builder()
            .id("GuiMeetupChoise")
            .manager(Main.getInstance().getInventoryManager())
            .provider(new GuiMeetupChoise())
            .size(3,9)
            .title("§fClassico | ModeDeJeux")
            .type(InventoryType.CHEST)
            .build();

    @Override
    public void init(Player player, InventoryContents contents) {
    }

    @Override
    public void update(Player player, InventoryContents contents) {
        contents.set(1,3, ClickableItem.of(classico, inventoryClickEvent -> {
            Main.getInstance().getGameManager().setUhcConfig(UHCType.CLASSICO);
            GuiHostPrinci.INV.open(player);
        }));

        contents.set(1,5,ClickableItem.of(modedejeux, inventoryClickEvent -> {
            Main.getInstance().getGameManager().setUhcConfig(UHCType.MODEDEJEUX);
            GuiHostPrinci.INV.open(player);
        }));
    }


    ItemStack classico = new ItemBuilder(Material.WOOL, 1, (short) 4)
            .setName("Classico")
            .setLore(" Meetup en mode Classico")
            .toItemStack();
    ItemStack modedejeux = new ItemBuilder(Material.WOOL, 1, (short) 14)
            .setName("Mode de Jeux")
            .setLore(" Meetup en mode Mode De Jeux UHC")
            .toItemStack();
}
