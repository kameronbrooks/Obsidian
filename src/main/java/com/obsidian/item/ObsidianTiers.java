package com.obsidian.item;

import com.obsidian.registry.ObsidianItems;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

/**
 * Tool material definition for obsidian.
 *
 * <p>Stats mirror netherite exactly: same durability, mining speed, attack bonus, enchantability,
 * and mining reach (it can harvest anything a netherite tool can). The only difference from
 * netherite is cosmetic and the repair ingredient — {@code Obsidian Shard}s.
 */
public final class ObsidianTiers {
    private ObsidianTiers() {}

    public static final Tier OBSIDIAN = new Tier() {
        @Override
        public int getUses() {
            return 2031; // netherite durability
        }

        @Override
        public float getSpeed() {
            return 9.0F;
        }

        @Override
        public float getAttackDamageBonus() {
            return 4.0F;
        }

        @Override
        public TagKey<Block> getIncorrectBlocksForDrops() {
            return BlockTags.INCORRECT_FOR_NETHERITE_TOOL;
        }

        @Override
        public int getEnchantmentValue() {
            return 15;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.of(ObsidianItems.OBSIDIAN_SHARD.get());
        }
    };
}
