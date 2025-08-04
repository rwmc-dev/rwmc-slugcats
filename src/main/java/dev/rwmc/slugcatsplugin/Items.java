package dev.rwmc.slugcatsplugin;

import io.papermc.paper.datacomponent.DataComponentTypes;
import io.papermc.paper.datacomponent.item.ItemLore;
import io.papermc.paper.datacomponent.item.TooltipDisplay;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.Style;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Items {
    public static ItemStack guiBorder;

    public static ItemStack selectSurvivor;
    public static ItemStack selectMonk;
    public static ItemStack selectHunter;

    @SuppressWarnings("UnstableApiUsage")
    public static void initialiseItems() {
        guiBorder = ItemStack.of(Material.GRAY_STAINED_GLASS_PANE);
        guiBorder.setData(DataComponentTypes.ITEM_MODEL, Key.key("rwmc:gui_border"));
        guiBorder.setData(DataComponentTypes.TOOLTIP_DISPLAY, TooltipDisplay.tooltipDisplay().hideTooltip(true).build());

        selectSurvivor = ItemStack.of(Material.PAPER);
        selectSurvivor.setData(DataComponentTypes.ITEM_MODEL, Key.key("rwmc:slugcat_survivor"));
        selectSurvivor.setData(DataComponentTypes.ITEM_NAME, Component.text("Survivor"));
        selectSurvivor.setData(DataComponentTypes.LORE, ItemLore.lore()
                .addLine(Component.text("A nimble omnivore, both predator and prey.", Style.style(NamedTextColor.DARK_GRAY)))
                .addLine(Component.empty())
                .addLine(Component.text("\uE00A\uE00A\uE00A\uE00A\uE00B\uE00C\uE00C\uE00C", Style.style(NamedTextColor.WHITE).decoration(TextDecoration.ITALIC,false)))
                .addLine(Component.empty())
                .addLine(Component.text("/ Standard damage", Style.style(NamedTextColor.GRAY).decoration(TextDecoration.ITALIC,false)))
                .addLine(Component.text("/ Standard diet", Style.style(NamedTextColor.GRAY).decoration(TextDecoration.ITALIC,false)))
                .addLine(Component.text("/ Standard oxygen", Style.style(NamedTextColor.GRAY).decoration(TextDecoration.ITALIC,false)))
                .build());
        selectMonk = ItemStack.of(Material.PAPER);
        selectMonk.setData(DataComponentTypes.ITEM_MODEL, Key.key("rwmc:slugcat_monk"));
        selectMonk.setData(DataComponentTypes.ITEM_NAME, Component.text("Monk"));
        selectMonk.setData(DataComponentTypes.LORE, ItemLore.lore()
                .addLine(Component.text("Weak in body but strong in spirit.", Style.style(NamedTextColor.DARK_GRAY)))
                .addLine(Component.empty())
                .addLine(Component.text("\uE00A\uE00A\uE00A\uE00B\uE00C\uE00C", Style.style(NamedTextColor.WHITE).decoration(TextDecoration.ITALIC,false)))
                .addLine(Component.empty())
                .addLine(Component.text("- 0.66x damage", Style.style(NamedTextColor.RED).decoration(TextDecoration.ITALIC,false)))
                .addLine(Component.text("/ Standard diet", Style.style(NamedTextColor.GRAY).decoration(TextDecoration.ITALIC,false)))
                .addLine(Component.text("+ 1.25x oxygen", Style.style(NamedTextColor.GREEN).decoration(TextDecoration.ITALIC,false)))
                .addLine(Component.text("+ Used Karma Flower respawns on death", Style.style(NamedTextColor.GREEN).decoration(TextDecoration.ITALIC,false)))
                .addLine(Component.text("+ Reduced visibility from hostile mobs", Style.style(NamedTextColor.GREEN).decoration(TextDecoration.ITALIC,false)))
                .build());
        selectHunter = ItemStack.of(Material.PAPER);
        selectHunter.setData(DataComponentTypes.ITEM_MODEL, Key.key("rwmc:slugcat_hunter"));
        selectHunter.setData(DataComponentTypes.ITEM_NAME, Component.text("Hunter"));
        selectHunter.setData(DataComponentTypes.LORE, ItemLore.lore()
                .addLine(Component.text("Strong and quick, with a fierce metabolism", Style.style(NamedTextColor.DARK_GRAY)))
                .addLine(Component.text("requiring a steady diet of meat.", Style.style(NamedTextColor.DARK_GRAY)))
                .addLine(Component.empty())
                .addLine(Component.text("\uE00A\uE00A\uE00A\uE00A\uE00A\uE00A\uE00B\uE00C\uE00C\uE00C", Style.style(NamedTextColor.WHITE).decoration(TextDecoration.ITALIC,false)))
                .addLine(Component.empty())
                .addLine(Component.text("- Karma Flowers are unusable", Style.style(NamedTextColor.RED).decoration(TextDecoration.ITALIC,false)))
                .addLine(Component.text("/ Carnivorous diet", Style.style(NamedTextColor.GRAY).decoration(TextDecoration.ITALIC,false)))
                .addLine(Component.text("/ Standard oxygen", Style.style(NamedTextColor.GRAY).decoration(TextDecoration.ITALIC,false)))
                .addLine(Component.text("+ 1.25x damage", Style.style(NamedTextColor.GREEN).decoration(TextDecoration.ITALIC,false)))
                .addLine(Component.text("+ 1.2x speed", Style.style(NamedTextColor.GREEN).decoration(TextDecoration.ITALIC,false)))
                .build());

    }
}
