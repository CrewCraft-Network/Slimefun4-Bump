package io.github.slimefunguguproject.bump.utils;

import javax.annotation.Nonnull;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import lombok.experimental.UtilityClass;

@UtilityClass
@SuppressWarnings("ConstantConditions")
public final class Utils {
    /**
     * Get a {@link String} of consecutive stars, maximum at 10.
     * <p>
     * When there are over 10 stars, returns number + star.
     *
     * @param n The number of stars
     * @return {@link String} of consecutive stars.
     */
    @Nonnull
    public static String getStars(int n) {
        if (n <= 10) {
            StringBuilder builder = new StringBuilder();
            while (n > 0) {
                builder.append("⭐");
                n--;
            }
            return builder.toString();
        } else {
            return n + " ⭐";
        }
    }

    /**
     * Make the {@link ItemStack} glow.
     *
     * @param item The {@link ItemStack} to be dealt with.
     */
    public static void glowItem(@Nonnull ItemStack item) {
        if (!ValidateUtils.noAirItem(item)) {
            return;
        }

        final ItemMeta itemMeta = item.getItemMeta();
        itemMeta.addEnchant(Enchantment.LUCK, 1, true);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(itemMeta);
    }
}
