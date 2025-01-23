package moe.lobster.anvilcraft_fooding.mixin;

import moe.lobster.anvilcraft_fooding.AnvilCraftFooding;
import moe.lobster.anvilcraft_fooding.data.foodsystem.IHasFoodsData;
import moe.lobster.anvilcraft_fooding.utils.IHasFoodsDataInjector;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(ServerPlayer.class)
public class ServerPlayerMixin implements IHasFoodsDataInjector {
    @Unique
    private CompoundTag anc_food$playerFoodsData;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void onInit(CallbackInfo info) {
        this.anc_food$playerFoodsData = new CompoundTag();
    }

    @Inject(method = "readAdditionalSaveData", at = @At("TAIL"))
    private void readFoodsData(CompoundTag compound, CallbackInfo info) {
        if (compound.contains(AnvilCraftFooding.MOD_ID, 10)) {
            this.anc_food$playerFoodsData = compound.getCompound(AnvilCraftFooding.MOD_ID);
        } else {
            this.anc_food$playerFoodsData = new CompoundTag();
        }
    }

    @Inject(method = "addAdditionalSaveData", at = @At("TAIL"))
    private void addFoodsData(CompoundTag compound, CallbackInfo info) {
        if (this.anc_food$playerFoodsData != null) {
            compound.put(AnvilCraftFooding.MOD_ID, this.anc_food$playerFoodsData);
        }
    }

    @Inject(method = "restoreFrom", at = @At("TAIL"))
    private void onPlayerClone(ServerPlayer oldPlayer, boolean alive, CallbackInfo info) {
        if (!alive) {
            this.anc_food$playerFoodsData = ((IHasFoodsData) oldPlayer).getPlayerFoodsData();
        }
    }

    @Override
    public CompoundTag anc_food$getPlayerFoodsData() {
        return this.anc_food$playerFoodsData;
    }

    @Override
    public void anc_food$setPlayerFoodsData(CompoundTag customData) {
        this.anc_food$playerFoodsData = customData;
    }
}
