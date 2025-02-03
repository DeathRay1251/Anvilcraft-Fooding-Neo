package moe.lobster.anvilcraft_fooding.init;

import moe.lobster.anvilcraft_fooding.AnvilCraftFooding;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModBlockTags {
    public static final TagKey<Block> LEMON_LOG = bind("lemon_log");
    private static TagKey<Block> bind(String id) {
        return TagKey.create(Registries.BLOCK, AnvilCraftFooding.of(id));
    }
}
