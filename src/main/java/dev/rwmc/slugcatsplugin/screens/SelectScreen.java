package dev.rwmc.slugcatsplugin.screens;

import dev.rwmc.slugcatsplugin.Items;
import dev.rwmc.slugcatsplugin.RWMCSlugcats;
import net.kyori.adventure.text.Component;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;

public class SelectScreen implements InventoryHolder {
    private final Inventory inventory;

    public SelectScreen(RWMCSlugcats plugin) {
        this.inventory = plugin.getServer().createInventory(this, 27, Component.text("Slugcat Select"));
        this.inventory.setContents(Collections.nCopies(27, Items.guiBorder).toArray(new ItemStack[0]));
        this.inventory.setItem(11, Items.selectMonk);
        this.inventory.setItem(13, Items.selectSurvivor);
        this.inventory.setItem(15, Items.selectHunter);
    }

    @Override
    public @NotNull Inventory getInventory() {
        return this.inventory;
    }
}
