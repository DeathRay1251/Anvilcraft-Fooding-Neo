package moe.lobster.anvilcraft_fooding.block;

import com.mojang.serialization.MapCodec;
import moe.lobster.anvilcraft_fooding.init.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class ChiliCropBlock extends CropBlock {
    public static final MapCodec<ChiliCropBlock> CODEC = simpleCodec(ChiliCropBlock::new);
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
        Block.box((double) 0.0F, (double) 0.0F, (double) 0.0F, (double) 16.0F, (double) 2.0F, (double) 16.0F),
        Block.box((double) 0.0F, (double) 0.0F, (double) 0.0F, (double) 16.0F, (double) 3.0F, (double) 16.0F),
        Block.box((double) 0.0F, (double) 0.0F, (double) 0.0F, (double) 16.0F, (double) 4.0F, (double) 16.0F),
        Block.box((double) 0.0F, (double) 0.0F, (double) 0.0F, (double) 16.0F, (double) 5.0F, (double) 16.0F),
        Block.box((double) 0.0F, (double) 0.0F, (double) 0.0F, (double) 16.0F, (double) 6.0F, (double) 16.0F),
        Block.box((double) 0.0F, (double) 0.0F, (double) 0.0F, (double) 16.0F, (double) 7.0F, (double) 16.0F),
        Block.box((double) 0.0F, (double) 0.0F, (double) 0.0F, (double) 16.0F, (double) 8.0F, (double) 16.0F),
        Block.box((double) 0.0F, (double) 0.0F, (double) 0.0F, (double) 16.0F, (double) 9.0F, (double) 16.0F)};

    public ChiliCropBlock(Properties properties) {
        super(properties);
    }

    public @NotNull MapCodec<ChiliCropBlock> codec() {
        return CODEC;
    }

    protected @NotNull ItemLike getBaseSeedId() {
        return ModBlocks.CHILI_CROP.get();
    }

    protected @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return SHAPE_BY_AGE[this.getAge(state)];
    }
}
