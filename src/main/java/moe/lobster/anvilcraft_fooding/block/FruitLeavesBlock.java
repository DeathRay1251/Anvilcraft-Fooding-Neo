package moe.lobster.anvilcraft_fooding.block;

import moe.lobster.anvilcraft_fooding.init.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.neoforge.common.CommonHooks;
import org.jetbrains.annotations.NotNull;

public class FruitLeavesBlock extends LeavesBlock {
    public static final int MAX_AGE = 1;
    public static final IntegerProperty AGE = BlockStateProperties.AGE_1;

    public FruitLeavesBlock(Properties properties) {
        super(properties);
        this.registerDefaultState((((this.stateDefinition.any())
//            .setValue(DISTANCE, DECAY_DISTANCE))
//            .setValue(PERSISTENT, false))
//            .setValue(WATERLOGGED, false)
            .setValue(AGE, 0))));
    }

    protected IntegerProperty getAgeProperty() {
        return AGE;
    }

    public int getMaxAge() {
        return MAX_AGE;
    }

    public final boolean isMaxAge(BlockState state) {
        return this.getAge(state) == this.getMaxAge();
    }

    public int getAge(BlockState state) {
        return state.getValue(this.getAgeProperty());
    }

    @Override
    protected boolean isRandomlyTicking(@NotNull BlockState state) {
        return (state.getValue(DISTANCE) == 7 && !(Boolean) state.getValue(PERSISTENT)) || (!this.isMaxAge(state));
    }

    @Override
    protected void randomTick(@NotNull BlockState state, @NotNull ServerLevel level, @NotNull BlockPos pos, @NotNull RandomSource random) {
        if (this.decaying(state)) {
            dropResources(state, level, pos);
            level.removeBlock(pos, false);
        } else {
            if (!level.isAreaLoaded(pos, 1)) return;
            int i = state.getValue(AGE);
            if (i < MAX_AGE && CommonHooks.canCropGrow(level, pos, state, random.nextInt(10) == 0)) {
                BlockState blockstate = state.setValue(AGE, i + 1);
                level.setBlock(pos, blockstate, 2);
                CommonHooks.fireCropGrowPost(level, pos, state);
                level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(blockstate));
            }
        }
    }

    protected @NotNull InteractionResult useWithoutItem(BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull BlockHitResult hitResult) {
        int i = state.getValue(AGE);
        if (i == MAX_AGE) {
            int j = 1 + level.random.nextInt(2);
            popResource(level, pos, new ItemStack(ModItems.LEMON.get(), j));
            level.playSound(null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);
            BlockState blockstate = state.setValue(AGE, 0);
            level.setBlock(pos, blockstate, 2);
            level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, blockstate));
            return InteractionResult.sidedSuccess(level.isClientSide);
        } else {
            return super.useWithoutItem(state, level, pos, player, hitResult);
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{DISTANCE, PERSISTENT, WATERLOGGED, AGE});
    }
}
