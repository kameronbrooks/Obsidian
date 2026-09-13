package com.obsidian.registry;

import com.obsidian.Obsidian;
import com.obsidian.item.ObsidianArrowItem;
import com.obsidian.item.ObsidianTiers;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * All items added by the mod. Attack damage / speed numbers mirror the vanilla per-item modifiers
 * and the tier contributes netherite's {@code +4} material bonus, so obsidian gear matches
 * netherite stats. Every item is {@code fireResistant()} — like netherite, it survives lava/fire.
 */
public final class ObsidianItems {
    private ObsidianItems() {}

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Obsidian.MOD_ID);

    /** Crafting material for every obsidian item, and the tools' repair ingredient. */
    public static final DeferredItem<Item> OBSIDIAN_SHARD =
            ITEMS.registerSimpleItem("obsidian_shard", new Item.Properties().fireResistant());

    public static final DeferredItem<SwordItem> OBSIDIAN_SWORD = ITEMS.registerItem("obsidian_sword",
            props -> new SwordItem(ObsidianTiers.OBSIDIAN,
                    props.attributes(SwordItem.createAttributes(ObsidianTiers.OBSIDIAN, 3, -2.4F)).fireResistant()));

    public static final DeferredItem<PickaxeItem> OBSIDIAN_PICKAXE = ITEMS.registerItem("obsidian_pickaxe",
            props -> new PickaxeItem(ObsidianTiers.OBSIDIAN,
                    props.attributes(PickaxeItem.createAttributes(ObsidianTiers.OBSIDIAN, 1.0F, -2.8F)).fireResistant()));

    public static final DeferredItem<AxeItem> OBSIDIAN_AXE = ITEMS.registerItem("obsidian_axe",
            props -> new AxeItem(ObsidianTiers.OBSIDIAN,
                    props.attributes(AxeItem.createAttributes(ObsidianTiers.OBSIDIAN, 5.0F, -3.0F)).fireResistant()));

    public static final DeferredItem<ShovelItem> OBSIDIAN_SHOVEL = ITEMS.registerItem("obsidian_shovel",
            props -> new ShovelItem(ObsidianTiers.OBSIDIAN,
                    props.attributes(ShovelItem.createAttributes(ObsidianTiers.OBSIDIAN, 1.5F, -3.0F)).fireResistant()));

    public static final DeferredItem<HoeItem> OBSIDIAN_HOE = ITEMS.registerItem("obsidian_hoe",
            props -> new HoeItem(ObsidianTiers.OBSIDIAN,
                    props.attributes(HoeItem.createAttributes(ObsidianTiers.OBSIDIAN, -4.0F, 0.0F)).fireResistant()));

    public static final DeferredItem<ObsidianArrowItem> OBSIDIAN_ARROW = ITEMS.registerItem("obsidian_arrow",
            props -> new ObsidianArrowItem(props.fireResistant()));
}
