package com.obsidian.registry;

import com.obsidian.Obsidian;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

/**
 * Creative-mode tabs. Registers a dedicated "Obsidian" tab holding every item, and also injects the
 * items into the matching vanilla tabs (Combat, Tools &amp; Utilities, Ingredients) so they show up
 * where players expect them.
 */
@EventBusSubscriber(modid = Obsidian.MOD_ID)
public final class ObsidianCreativeTabs {
    private ObsidianCreativeTabs() {}

    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Obsidian.MOD_ID);

    public static final Supplier<CreativeModeTab> OBSIDIAN = TABS.register("obsidian", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.obsidian"))
            .icon(() -> new ItemStack(ObsidianItems.OBSIDIAN_PICKAXE.get()))
            .displayItems((parameters, output) -> {
                output.accept(ObsidianItems.OBSIDIAN_SHARD.get());
                output.accept(ObsidianItems.OBSIDIAN_SWORD.get());
                output.accept(ObsidianItems.OBSIDIAN_PICKAXE.get());
                output.accept(ObsidianItems.OBSIDIAN_AXE.get());
                output.accept(ObsidianItems.OBSIDIAN_SHOVEL.get());
                output.accept(ObsidianItems.OBSIDIAN_HOE.get());
                output.accept(ObsidianItems.OBSIDIAN_ARROW.get());
            })
            .build());

    /** Add obsidian items to the relevant vanilla creative tabs, mirroring where netherite lives. */
    @SubscribeEvent
    static void addToVanillaTabs(BuildCreativeModeTabContentsEvent event) {
        ResourceKey<CreativeModeTab> tab = event.getTabKey();
        if (tab == CreativeModeTabs.COMBAT) {
            event.accept(ObsidianItems.OBSIDIAN_SWORD.get());
            event.accept(ObsidianItems.OBSIDIAN_AXE.get());
            event.accept(ObsidianItems.OBSIDIAN_ARROW.get());
        } else if (tab == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ObsidianItems.OBSIDIAN_PICKAXE.get());
            event.accept(ObsidianItems.OBSIDIAN_AXE.get());
            event.accept(ObsidianItems.OBSIDIAN_SHOVEL.get());
            event.accept(ObsidianItems.OBSIDIAN_HOE.get());
        } else if (tab == CreativeModeTabs.INGREDIENTS) {
            event.accept(ObsidianItems.OBSIDIAN_SHARD.get());
        }
    }
}
