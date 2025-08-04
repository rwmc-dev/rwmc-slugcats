package dev.rwmc.slugcatsplugin;

import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;

import java.util.Objects;

public class Utilities {
    public static void updatePlayerDisplay(Player player) {
        String playerSlugcat = player.getPersistentDataContainer().get(Objects.requireNonNull(NamespacedKey.fromString("rwmc:slugcat")), PersistentDataType.STRING);
        String newDisplay = player.getName();
        switch (playerSlugcat) {
            case "survivor":
                newDisplay = player.getName() + " \uE000";
                break;
            case "monk":
                newDisplay = player.getName() + " \uE001";
                break;
            case "hunter":
                newDisplay = player.getName() + " \uE002";
                break;
            case null, default:
                break;
        }
        player.playerListName(Component.text(newDisplay));
        player.displayName(Component.text(newDisplay));
    }
}
