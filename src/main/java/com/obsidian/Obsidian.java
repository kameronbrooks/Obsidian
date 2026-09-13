package com.obsidian;

import com.mojang.logging.LogUtils;
import com.obsidian.registry.ObsidianCreativeTabs;
import com.obsidian.registry.ObsidianEntities;
import com.obsidian.registry.ObsidianItems;
import net.minecraft.world.level.block.DispenserBlock;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import org.slf4j.Logger;

/**
 * Obsidian — top-tier obsidian gear.
 *
 * <p>Adds an obsidian tool set (pickaxe, axe, shovel, hoe), an obsidian sword, and obsidian
 * arrows, all crafted from {@code Obsidian Shard}s. Obsidian sits above diamond and level with
 * netherite: high durability, fast mining, and a strong attack bonus. This class only wires up
 * registration; the material's stats live in {@link com.obsidian.item.ObsidianTiers}.
 */
@Mod(Obsidian.MOD_ID)
public final class Obsidian {
    public static final String MOD_ID = "obsidian";
    public static final Logger LOGGER = LogUtils.getLogger();

    public Obsidian(IEventBus modBus, ModContainer container) {
        ObsidianItems.ITEMS.register(modBus);
        ObsidianEntities.ENTITY_TYPES.register(modBus);
        ObsidianCreativeTabs.TABS.register(modBus);

        modBus.addListener(this::commonSetup);

        LOGGER.info("Obsidian initialising — forging obsidian gear.");
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // Let dispensers shoot obsidian arrows, just like vanilla arrows.
        event.enqueueWork(() -> DispenserBlock.registerProjectileBehavior(ObsidianItems.OBSIDIAN_ARROW.get()));
    }
}
