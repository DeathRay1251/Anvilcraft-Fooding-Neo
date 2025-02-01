package moe.lobster.anvilcraft_fooding.init;

import moe.lobster.anvilcraft_fooding.data.feature.TreeFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class ModTreeGrowers {
    public static final TreeGrower LEMON_TREE_GROWER =
        new TreeGrower("lemon",
            Optional.empty(),
            Optional.of(TreeFeatures.LEMON_TREE),
            Optional.empty());
}
