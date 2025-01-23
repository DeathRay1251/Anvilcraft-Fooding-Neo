package moe.lobster.anvilcraft_fooding.utils;

import moe.lobster.anvilcraft_fooding.data.foodsystem.IHasFoodsData;
import net.minecraft.nbt.CompoundTag;

public interface IHasFoodsDataInjector extends IHasFoodsData {
    default CompoundTag getPlayerFoodsData() {
        return this.anc_food$getPlayerFoodsData();
    }

    default void setPlayerFoodsData(CompoundTag customData) {
        this.anc_food$setPlayerFoodsData(customData);
    }

    CompoundTag anc_food$getPlayerFoodsData();

    void anc_food$setPlayerFoodsData(CompoundTag customData);
}
