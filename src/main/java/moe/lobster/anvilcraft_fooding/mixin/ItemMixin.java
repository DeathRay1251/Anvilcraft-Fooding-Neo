package moe.lobster.anvilcraft_fooding.mixin;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static moe.lobster.anvilcraft_fooding.init.ModItems.test;


@Mixin(Item.class)
public class ItemMixin {
    @Inject(method = "finishUsingItem", at = @At("HEAD"))
    private void finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity, CallbackInfoReturnable<ItemStack> cir) {
        test(stack);
    }
}
