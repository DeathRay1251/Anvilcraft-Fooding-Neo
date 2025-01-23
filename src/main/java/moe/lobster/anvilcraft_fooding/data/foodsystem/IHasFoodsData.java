package moe.lobster.anvilcraft_fooding.data.foodsystem;

import net.minecraft.nbt.CompoundTag;

public interface IHasFoodsData {

    CompoundTag getPlayerFoodsData();

    void setPlayerFoodsData(CompoundTag customData);
}
