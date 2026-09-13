package com.obsidian.client;

import com.obsidian.Obsidian;
import com.obsidian.entity.ObsidianArrow;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

/** Renders {@link ObsidianArrow} using the standard arrow model with our own texture. */
public class ObsidianArrowRenderer extends ArrowRenderer<ObsidianArrow> {
    private static final ResourceLocation TEXTURE =
            ResourceLocation.fromNamespaceAndPath(Obsidian.MOD_ID, "textures/entity/obsidian_arrow.png");

    public ObsidianArrowRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(ObsidianArrow entity) {
        return TEXTURE;
    }
}
