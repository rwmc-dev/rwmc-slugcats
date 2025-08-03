package dev.rwmc.slugcatsplugin;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.tree.LiteralCommandNode;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import io.papermc.paper.command.brigadier.Commands;
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents;
import org.bukkit.command.CommandSender;
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

        LiteralCommandNode<CommandSourceStack> slugcatsCommand = Commands.literal("slugcat")
                .then(Commands.literal("select")
                    .executes(ctx -> {
                        CommandSender sender = ctx.getSource().getSender();
                        sender.sendPlainMessage("Debug message confirming that the command works.");
                        return Command.SINGLE_SUCCESS;
                    }))
                .build();
        this.getLifecycleManager().registerEventHandler(LifecycleEvents.COMMANDS, commands -> {
            commands.registrar().register(slugcatsCommand);
        });
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
