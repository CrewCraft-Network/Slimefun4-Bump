package bxx2004.bump.slimefun.items.weapon;

import bxx2004.bump.Bump;
import bxx2004.bump.slimefun.BumpItemGroups;
import bxx2004.bump.slimefun.BumpItems;
import bxx2004.bump.util.Utils;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.BowShootHandler;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import org.bukkit.entity.Player;
import org.bukkit.entity.WitherSkull;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

public class WitherSkullBow extends BumpBow {

    public WitherSkullBow() {
        super(BumpItemGroups.WEAPON, BumpItems.WITHERSKULL_ROW, RecipeType.ARMOR_FORGE, new ItemStack[] {
            SlimefunItems.NECROTIC_SKULL, BumpItems.PEACH_WOOD, SlimefunItems.NECROTIC_SKULL,
            SlimefunItems.POWER_CRYSTAL, BumpItems.PEACH_WOOD, SlimefunItems.NECROTIC_SKULL,
            BumpItems.PEACH_WOOD, null, null
        });
    }

    @Nonnull
    @Override
    public BowShootHandler onShoot() {
        return (e, n) -> {
            Player p = (Player) e.getDamager();

            if (p.getFoodLevel() >= 5) {
                Utils.changeFoodLevel(p, p.getFoodLevel() - 5);

                e.setCancelled(true);
                Bump.getLocalization().sendActionbarMessage(p, "weapon.wither_skull_bow");
                p.launchProjectile(WitherSkull.class);

            } else {
                Bump.getLocalization().sendActionbarMessage(p, "weapon.low-food-level");
            }
        };
    }
}
