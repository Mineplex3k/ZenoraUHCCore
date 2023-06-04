package fr.mine.Inventory;

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
        if(Main.getInstance().getGameManager().getUhcType().getName().equals(UHCType.MEETUP.getName())){
            contents.set(0,0, ClickableItem.of(meetup, inventoryClickEvent -> {
            }));
        }else if(Main.getInstance().getGameManager().getUhcType().getName().equals(UHCType.CLASSICO.getName())){
            contents.set(0,0,ClickableItem.of(modedejeux, inventoryClickEvent -> {
            }));
        }else if(Main.getInstance().getGameManager().getUhcType().getName().equals(UHCType.MODEDEJEUX.getName())){
            contents.set(0,0, ClickableItem.of(classico, inventoryClickEvent -> {
            }));
        }
    }

    @Override
    public void update(Player player, InventoryContents contents) {
    }

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
}
