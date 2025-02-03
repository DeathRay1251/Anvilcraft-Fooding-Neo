package moe.lobster.anvilcraft_fooding.mixin;

import moe.lobster.anvilcraft_fooding.item.ModAxeItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(AxeItem.class)
public class AxeItemMixin {
    @Inject(method = "getAxeStrippingState(Lnet/minecraft/world/level/block/state/BlockState;)Lnet/minecraft/world/level/block/state/BlockState;", at=@At("RETURN"),locals = LocalCapture.CAPTURE_FAILSOFT, cancellable = true)
    private static void getAxeStrippingState(BlockState originalState, CallbackInfoReturnable<BlockState> cir, Block block) {
        if(block == null){
            block=ModAxeItem.STRIPPABLES.get(originalState.getBlock());
        }
        cir.setReturnValue(block != null ? block.defaultBlockState().setValue(RotatedPillarBlock.AXIS, originalState.getValue(RotatedPillarBlock.AXIS)) : null);
    }
}
