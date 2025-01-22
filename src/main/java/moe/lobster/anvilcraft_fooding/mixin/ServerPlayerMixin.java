package moe.lobster.anvilcraft_fooding.mixin;

import moe.lobster.anvilcraft_fooding.AnvilCraftFooding;
import moe.lobster.anvilcraft_fooding.data.foodsystem.FoodsData;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(ServerPlayer.class)
public class ServerPlayerMixin implements FoodsData{
    @Unique
    private CompoundTag foodsData;
    @Inject(method = "<init>", at = @At("RETURN"))
    private void onInit(CallbackInfo info) {
        this.foodsData = new CompoundTag();
    }
    @Inject(method = "readAdditionalSaveData", at = @At("TAIL"))
    private void readFoodsData(CompoundTag compound, CallbackInfo info) {
        if (compound.contains(AnvilCraftFooding.MOD_ID, 10)) {
            this.foodsData = compound.getCompound(AnvilCraftFooding.MOD_ID);
        } else {
            this.foodsData = new CompoundTag();
        }
    }
    @Inject(method = "addAdditionalSaveData", at = @At("TAIL"))
    private void addFoodsData(CompoundTag compound, CallbackInfo info) {
        if (this.foodsData != null) {
            compound.put(AnvilCraftFooding.MOD_ID, this.foodsData);
        }
    }
    @Inject(method = "restoreFrom",at = @At("TAIL"))
    private void onPlayerClone(ServerPlayer oldPlayer, boolean alive, CallbackInfo info) {
        if (!alive) {
            this.foodsData = ((FoodsData) oldPlayer).getFoodsData();
        }
    }

    @Override
    public CompoundTag getFoodsData() {
        return foodsData;
    }

    @Override
    public void setFoodsData(CompoundTag customData) {
        this.foodsData = customData;
    }
}
