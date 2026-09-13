package com.obsidian.entity;

import com.obsidian.registry.ObsidianEntities;
import com.obsidian.registry.ObsidianItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

/**
 * The obsidian arrow projectile.
 *
 * <p>Hits far harder than a flint arrow — obsidian's heavy edge deals massive damage (roughly a
 * fully-drawn vanilla arrow's damage several times over). Otherwise it behaves like a normal
 * arrow: it can be picked up, fired from bows, crossbows, and dispensers, and dropped as its item
 * form. Actual damage scales with draw strength, since the game multiplies this base by velocity.
 */
public class ObsidianArrow extends AbstractArrow {
    // Vanilla arrows use 2.0. This is deliberately high so obsidian arrows hit very hard.
    private static final double BASE_DAMAGE = 10.0D;

    /** Factory constructor used by the entity type when the game spawns or loads the arrow. */
    public ObsidianArrow(EntityType<? extends ObsidianArrow> type, Level level) {
        super(type, level);
        this.setBaseDamage(BASE_DAMAGE);
    }

    /** Fired from a living shooter (bow / crossbow). */
    public ObsidianArrow(Level level, LivingEntity owner, ItemStack pickupItemStack, @Nullable ItemStack firedFromWeapon) {
        super(ObsidianEntities.OBSIDIAN_ARROW.get(), owner, level, pickupItemStack, firedFromWeapon);
        this.setBaseDamage(BASE_DAMAGE);
    }

    /** Launched from a fixed position (dispenser). */
    public ObsidianArrow(Level level, double x, double y, double z, ItemStack pickupItemStack, @Nullable ItemStack firedFromWeapon) {
        super(ObsidianEntities.OBSIDIAN_ARROW.get(), x, y, z, level, pickupItemStack, firedFromWeapon);
        this.setBaseDamage(BASE_DAMAGE);
    }

    @Override
    protected ItemStack getDefaultPickupItem() {
        return new ItemStack(ObsidianItems.OBSIDIAN_ARROW.get());
    }
}
