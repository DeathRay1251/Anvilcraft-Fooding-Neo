package moe.lobster.anvilcraft_fooding.mixin;

import moe.lobster.anvilcraft_fooding.data.FoodTagBuilder;
import net.minecraft.core.component.DataComponentHolder;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.component.PatchedDataComponentMap;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.ItemLike;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import javax.annotation.Nullable;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin implements DataComponentHolder {
    @Shadow
    @Nullable
    public abstract <T> T set(DataComponentType<? super T> component, @Nullable T value);

    @Inject(method = "<init>(Lnet/minecraft/world/level/ItemLike;ILnet/minecraft/core/component/PatchedDataComponentMap;)V", at = @At("TAIL"))
    private void tag(ItemLike item, int count, PatchedDataComponentMap components, CallbackInfo ci) {
        if (!FoodTagBuilder.contains(item)) return;
        CustomData customData = this.get(DataComponents.CUSTOM_DATA);
        CompoundTag tag = new CompoundTag();
        if (customData != null) tag = customData.copyTag();
        this.set(DataComponents.CUSTOM_DATA, FoodTagBuilder.get(item).toCustomData(tag));
    }
}
