package moe.lobster.anvilcraft_fooding.init;

import moe.lobster.anvilcraft_fooding.AnvilCraftFooding;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModItemTags {
    public static final TagKey<Item> LEMON_LOG = bind("lemon_log");
    private static TagKey<Item> bind(String id) {
        return TagKey.create(Registries.ITEM, AnvilCraftFooding.of(id));
    }
}
