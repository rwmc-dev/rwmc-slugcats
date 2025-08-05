package dev.rwmc.slugcatsplugin;

import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;

import java.util.Objects;

public class Utilities {
    public static String getPlayerSlugcat(Player player) {
        String playerSlugcat = player.getPersistentDataContainer().get(Objects.requireNonNull(NamespacedKey.fromString("rwmc:slugcat")), PersistentDataType.STRING);
        if (playerSlugcat != null) { return playerSlugcat; } else { return "survivor"; }
    }

    public static void updatePlayerDisplay(Player player) {
        String playerSlugcat = getPlayerSlugcat(player);
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
            default:
                break;
        }
        player.playerListName(Component.text(newDisplay));
        player.displayName(Component.text(newDisplay));
    }

    public static void setPlayerMaxFood(Player player, int maxFood) {
        player.getPersistentDataContainer().set(Objects.requireNonNull(NamespacedKey.fromString("rwmc:max_food")), PersistentDataType.INTEGER, maxFood);
    }
    public static void setPlayerReqFood(Player player, int reqFood) {
        player.getPersistentDataContainer().set(Objects.requireNonNull(NamespacedKey.fromString("rwmc:req_food")), PersistentDataType.INTEGER, reqFood);
    }
    public static void setPlayerFood(Player player, int food) {
        player.getPersistentDataContainer().set(Objects.requireNonNull(NamespacedKey.fromString("rwmc:food")), PersistentDataType.INTEGER, food);
    }
    public static void setPlayerStarving(Player player, boolean isStarving) {
        player.getPersistentDataContainer().set(Objects.requireNonNull(NamespacedKey.fromString("rwmc:is_starving")), PersistentDataType.BOOLEAN, isStarving);
    }

    public static void applyPlayerSlugcat(Player player) {
        String playerSlugcat = getPlayerSlugcat(player);

        double attackDamage = 1.0;
        double movementSpeed = 0.10000000149011612;
        double sneakingSpeed = 0.3;
        int maximumAir = 300;

        switch (playerSlugcat) {
            case "survivor":
                setPlayerMaxFood(player, 7);
                setPlayerReqFood(player, 4);
                break;
            case "monk":
                setPlayerMaxFood(player, 5);
                setPlayerReqFood(player, 3);
                attackDamage *= 0.66;
                maximumAir = (int) (maximumAir * 1.25);
                break;
            case "hunter":
                setPlayerMaxFood(player, 9);
                setPlayerReqFood(player, 6);
                attackDamage *= 1.25;
                movementSpeed *= 1.2;
                sneakingSpeed *= 1.2;
                break;
            default:
                setPlayerMaxFood(player, 0);
                setPlayerReqFood(player, 0);
                break;
        }
        setPlayerFood(player, 0);
        setPlayerStarving(player, false);

        AttributeInstance attackDmgAttrib = player.getAttribute(Attribute.ATTACK_DAMAGE);
        AttributeInstance moveSpeedAttrib = player.getAttribute(Attribute.MOVEMENT_SPEED);
        AttributeInstance sneakSpeedAttrib = player.getAttribute(Attribute.SNEAKING_SPEED);

        if (attackDmgAttrib != null) { attackDmgAttrib.setBaseValue(attackDamage); }
        if (moveSpeedAttrib != null) { moveSpeedAttrib.setBaseValue(movementSpeed); }
        if (sneakSpeedAttrib != null) { sneakSpeedAttrib.setBaseValue(sneakingSpeed); }

        player.setMaximumAir(maximumAir);

    }
}
