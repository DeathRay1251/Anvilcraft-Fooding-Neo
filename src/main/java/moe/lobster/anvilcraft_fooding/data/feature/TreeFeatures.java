package moe.lobster.anvilcraft_fooding.data.feature;

import moe.lobster.anvilcraft_fooding.init.ModBlocks;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

public class TreeFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> LEMON_TREE = ModFeatureUtils.createKey("lemon_tree");

    private static TreeConfiguration.TreeConfigurationBuilder createStraightBlobTree(Block logBlock, Block leavesBlock, int baseHeight, int addHeightRand, int declineHeightRand, int radius, int placerHeight) {
        return new TreeConfiguration.TreeConfigurationBuilder(
            BlockStateProvider.simple(logBlock),
            new StraightTrunkPlacer(baseHeight, addHeightRand, declineHeightRand),
            BlockStateProvider.simple(leavesBlock),
            new BlobFoliagePlacer(ConstantInt.of(radius), ConstantInt.of(0), placerHeight),
            new TwoLayersFeatureSize(1, 0, 1));
    }

    private static TreeConfiguration.TreeConfigurationBuilder createLemonTree() {
        return createStraightBlobTree(ModBlocks.LEMON_LOG.get(), ModBlocks.LEMON_LEAVE.get(), 1, 0, 0, 2, 1);
    }

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        ModFeatureUtils.register(context, LEMON_TREE, Feature.TREE, createLemonTree().build());
    }
}
