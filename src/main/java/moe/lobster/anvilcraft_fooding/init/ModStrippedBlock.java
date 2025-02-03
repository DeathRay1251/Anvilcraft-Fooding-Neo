package moe.lobster.anvilcraft_fooding.init;

import moe.lobster.anvilcraft_fooding.item.ModAxeItem;

public class ModStrippedBlock {
    public static void register() {
        ModAxeItem.addAxeItem(ModBlocks.LEMON_LOG.get(), ModBlocks.STRIPPED_LEMON_LOG.get());
        ModAxeItem.addAxeItem(ModBlocks.LEMON_WOOD.get(), ModBlocks.STRIPPED_LEMON_WOOD.get());
    }
}
