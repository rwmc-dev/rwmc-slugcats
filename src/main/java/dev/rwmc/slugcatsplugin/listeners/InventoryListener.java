package dev.rwmc.slugcatsplugin.listeners;

import dev.rwmc.slugcatsplugin.Items;
import dev.rwmc.slugcatsplugin.Utilities;
import dev.rwmc.slugcatsplugin.screens.SelectScreen;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.Style;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import java.util.Objects;

public class InventoryListener implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Inventory inventory = event.getInventory();
        ItemStack clickedItem = event.getCurrentItem();
        HumanEntity user = inventory.getViewers().getFirst();

        if ((inventory.getHolder(false) instanceof SelectScreen)) {
            if (clickedItem == null || clickedItem == Items.guiBorder) {
                event.setCancelled(true);
                return;
            }
            if (clickedItem.equals(Items.selectSurvivor)) {
                user.sendMessage(Component.text("You have selected the Slugcat: ", Style.style(NamedTextColor.GRAY)).append(Component.text("Survivor", Style.style(NamedTextColor.WHITE))));
                user.getPersistentDataContainer().set(Objects.requireNonNull(NamespacedKey.fromString("rwmc:slugcat")), PersistentDataType.STRING, "survivor");
            } else if (clickedItem.equals(Items.selectMonk)) {
                user.sendMessage(Component.text("You have selected the Slugcat: ", Style.style(NamedTextColor.GRAY)).append(Component.text("Monk", Style.style(NamedTextColor.YELLOW))));
                user.getPersistentDataContainer().set(Objects.requireNonNull(NamespacedKey.fromString("rwmc:slugcat")), PersistentDataType.STRING, "monk");
            } else if (clickedItem.equals(Items.selectHunter)) {
                user.sendMessage(Component.text("You have selected the Slugcat: ", Style.style(NamedTextColor.GRAY)).append(Component.text("Hunter", Style.style(NamedTextColor.RED))));
                user.getPersistentDataContainer().set(Objects.requireNonNull(NamespacedKey.fromString("rwmc:slugcat")), PersistentDataType.STRING, "hunter");
            }
            Utilities.updatePlayerDisplay((Player) user);
            Utilities.applyPlayerSlugcat((Player) user);
            event.setCancelled(true);
        }

    }
}
