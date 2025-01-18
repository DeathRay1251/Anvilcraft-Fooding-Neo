package moe.lobster.anvilcraft_fooding.mixin;

import moe.lobster.anvilcraft_fooding.init.minecraft.FoodFix;
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

import static moe.lobster.anvilcraft_fooding.AnvilCraftFooding.MOD_ID;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {




    @Inject(method = "<init>(Lnet/minecraft/world/level/ItemLike;ILnet/minecraft/core/component/PatchedDataComponentMap;)V",at=@At("TAIL"))
    private void tag( ItemLike item, int count, PatchedDataComponentMap components, CallbackInfo ci ){
        if( FoodFix.FoodList.containsKey(item.asItem())){
            this.set( DataComponents.CUSTOM_DATA,foodData( FoodFix.FoodList.get( item.asItem() ) ));
        }
    }

    @Shadow @Nullable public abstract < T > T set( DataComponentType< ? super T > component, @org.jetbrains.annotations.Nullable T value );

    private static CustomData foodData( CompoundTag compoundTag ){
        CompoundTag compoundTag2 = new CompoundTag();
        compoundTag2.put( MOD_ID,compoundTag );
        return CustomData.of( compoundTag2 );
    }
}
