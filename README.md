# Obsidian

A NeoForge mod for **Minecraft 1.21.1** that adds a full line of obsidian gear: tools, a sword,
and arrows. Obsidian sits at the very top of the material progression — a shade above netherite on
durability and enchantability, with netherite-level mining reach and a strong attack bonus.

Everything is crafted from **Obsidian Shards**, which you break down from obsidian blocks.

## What's added

| Item | Notes |
| --- | --- |
| **Obsidian Shard** | Crafting material. 1 obsidian block → 4 shards. Also repairs obsidian tools. |
| **Obsidian Sword** | Netherite-plus melee damage. |
| **Obsidian Pickaxe** | Mines everything, including ancient debris & obsidian. |
| **Obsidian Axe** | High damage, strips/harvests wood. |
| **Obsidian Shovel** | Fast digging; makes dirt paths. |
| **Obsidian Hoe** | Tills soil; top-tier enchantability. |
| **Obsidian Arrow** | Fired from bows, crossbows, and dispensers. Hits harder than a flint arrow. |

### Material stats (`ObsidianTiers.OBSIDIAN`)

- **Durability:** 2200 (netherite is 2031)
- **Mining speed:** 9.0 (netherite-level)
- **Attack bonus:** +4.0
- **Enchantability:** 15
- **Mining level:** can harvest anything a netherite tool can
- **Repair material:** Obsidian Shard

All tools and the sword are registered in the correct `minecraft:enchantable/*` tags, so they accept
the expected enchantments at an enchanting table (Efficiency, Fortune, Silk Touch, Sharpness,
Unbreaking, Mending, etc.).

## Crafting

```
Obsidian Shard        Sword          Pickaxe        Axe          Shovel        Hoe          Arrow
[Obsidian] -> 4x      S              S S S          S S          S             S S          S
(shapeless)           S              . # .          S #          #             . #          #
                      #              . # .          . #          #             . #          F

S = Obsidian Shard   # = Stick   F = Feather   (Arrow yields 4)
```

## Project layout

```
src/main/java/com/obsidian/
  Obsidian.java                     main mod class + registration
  registry/ObsidianItems.java       items (shard, tools, sword, arrow)
  registry/ObsidianEntities.java    obsidian arrow entity type
  registry/ObsidianCreativeTabs.java creative tab
  item/ObsidianTiers.java           the obsidian tool tier
  item/ObsidianArrowItem.java       arrow item (bow/crossbow/dispenser ammo)
  entity/ObsidianArrow.java         arrow projectile
  client/ObsidianClient.java        client renderer registration
  client/ObsidianArrowRenderer.java arrow renderer
src/main/resources/                 models, textures, lang, recipes, tags
src/main/templates/                 neoforge.mods.toml (version-expanded at build)
```

## Building & running

Requires **JDK 21**. From the project directory:

```bash
./gradlew build        # produces build/libs/obsidian-0.1.0.jar
./gradlew runClient    # launch a dev client with the mod loaded
```

> **Note:** running `./gradlew` from a terminal needs `JAVA_HOME` pointing at a JDK 21
> (e.g. `C:\Program Files\Eclipse Adoptium\jdk-21.0.8.9-hotspot`). Opening the project in
> IntelliJ IDEA and using its Gradle integration avoids that — just set the Gradle JVM to JDK 21.

Key versions (see `gradle.properties`): NeoForge `21.1.250`, Minecraft `1.21.1`, Parchment
`2024.11.17`, ModDevGradle `2.0.146`.

## Textures

The item and arrow textures are simple generated placeholders in the obsidian palette
(dark purple with speckle and highlights). Drop your own 16×16 PNGs into
`src/main/resources/assets/obsidian/textures/item/` (and the 32×32 arrow entity texture into
`textures/entity/`) to replace them.
