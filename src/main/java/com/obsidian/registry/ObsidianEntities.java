package com.obsidian.registry;

import com.obsidian.Obsidian;
import com.obsidian.entity.ObsidianArrow;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

/** Entity type registration. Currently just the obsidian arrow projectile. */
public final class ObsidianEntities {
    private ObsidianEntities() {}

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(Registries.ENTITY_TYPE, Obsidian.MOD_ID);

    public static final Supplier<EntityType<ObsidianArrow>> OBSIDIAN_ARROW =
            ENTITY_TYPES.register("obsidian_arrow", () -> EntityType.Builder
                    .<ObsidianArrow>of(ObsidianArrow::new, MobCategory.MISC)
                    .sized(0.5F, 0.5F)
                    .eyeHeight(0.13F)
                    .clientTrackingRange(4)
                    .updateInterval(20)
                    .build("obsidian_arrow"));
}
