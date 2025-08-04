package dev.rwmc.slugcatsplugin;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.tree.LiteralCommandNode;
import dev.rwmc.slugcatsplugin.listeners.InventoryListener;
import dev.rwmc.slugcatsplugin.listeners.PlayerListener;
import dev.rwmc.slugcatsplugin.screens.SelectScreen;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import io.papermc.paper.command.brigadier.Commands;
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;
import java.util.logging.Logger;

public final class RWMCSlugcats extends JavaPlugin {

    public Logger Logger;

    @Override
    @SuppressWarnings({"UnstableApiUsage"})
    public void onEnable() {
        Logger = this.getLogger();
        Logger.log(Level.INFO, "RWMC Slugcats is enabled!");

        Items.initialiseItems();

        getServer().getPluginManager().registerEvents(new InventoryListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerListener(), this);

        LiteralCommandNode<CommandSourceStack> slugcatsCommand = Commands.literal("slugcat")
                .then(Commands.literal("select")
                    .executes(ctx -> {
                        CommandSender sender = ctx.getSource().getSender();
                        Entity executor = ctx.getSource().getExecutor();

                        if (!(executor instanceof Player)) {
                            sender.sendMessage(Component.text("The Slugcat selection screen can only be opened for players!", NamedTextColor.RED));
                            return Command.SINGLE_SUCCESS;
                        }

                        SelectScreen selectScreen = new SelectScreen(this);
                        ((Player) executor).openInventory(selectScreen.getInventory());

                        return Command.SINGLE_SUCCESS;
                    }))
                .build();
        //noinspection CodeBlock2Expr
        this.getLifecycleManager().registerEventHandler(LifecycleEvents.COMMANDS, commands -> {
            commands.registrar().register(slugcatsCommand);
        });
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
