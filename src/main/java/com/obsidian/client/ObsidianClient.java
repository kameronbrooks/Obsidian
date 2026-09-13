package com.obsidian.client;

import com.obsidian.Obsidian;
import com.obsidian.registry.ObsidianEntities;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

/** Client-only setup. Binds the obsidian arrow entity to its renderer. */
@EventBusSubscriber(modid = Obsidian.MOD_ID, value = Dist.CLIENT)
public final class ObsidianClient {
    private ObsidianClient() {}

    @SubscribeEvent
    static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ObsidianEntities.OBSIDIAN_ARROW.get(), ObsidianArrowRenderer::new);
    }
}
