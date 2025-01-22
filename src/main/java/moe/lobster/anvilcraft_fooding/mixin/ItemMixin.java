package moe.lobster.anvilcraft_fooding.mixin;

import moe.lobster.anvilcraft_fooding.AnvilCraftFooding;
import moe.lobster.anvilcraft_fooding.data.foodsystem.FinishEating;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Objects;


@Mixin(Item.class)
public class ItemMixin {
//    @Inject(method = "finishUsingItem", at = @At("HEAD"))
//    private void finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity, CallbackInfoReturnable<ItemStack> cir) {
//        if(livingEntity.level().isClientSide()) return;
//        if(!(livingEntity instanceof ServerPlayer)) return;
//        if(!stack.has(DataComponents.CUSTOM_DATA)) return;
//        if(!Objects.requireNonNull(stack.get(DataComponents.CUSTOM_DATA)).contains(AnvilCraftFooding.MOD_ID))   return;
//        CompoundTag compoundTag = Objects.requireNonNull(stack.get(DataComponents.CUSTOM_DATA)).copyTag();
//        FinishEating.onFinishEating((ServerPlayer) livingEntity,compoundTag);
//    }
}
