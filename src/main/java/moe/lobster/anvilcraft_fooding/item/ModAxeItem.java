package moe.lobster.anvilcraft_fooding.item;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.block.Block;

import java.util.HashMap;
import java.util.Map;

public class ModAxeItem extends DiggerItem {
    public static Map<Block, Block> STRIPPABLES = new HashMap<>();

    public ModAxeItem(Tier tier, TagKey<Block> blocks, Properties properties) {
        super(tier, blocks, properties);
    }

    public static void addAxeItem(Block log,Block stripped_log){
        STRIPPABLES.put(log,stripped_log);
    }
}
