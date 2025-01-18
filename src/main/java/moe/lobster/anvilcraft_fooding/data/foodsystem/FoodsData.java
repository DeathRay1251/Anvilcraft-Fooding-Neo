package moe.lobster.anvilcraft_fooding.data.foodsystem;

import net.minecraft.nbt.CompoundTag;

public interface FoodsData {
    CompoundTag getFoodsData();
    void setFoodsData(CompoundTag customData);
}
