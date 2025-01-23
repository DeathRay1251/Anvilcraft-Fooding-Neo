package moe.lobster.anvilcraft_fooding.data.foodsystem;

import moe.lobster.anvilcraft_fooding.AnvilCraftFooding;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;


public class FoodTagBuilder {
    private static final Map<ItemLike, FoodTagBuilder> FOOD_LIST = new HashMap<>();

    private final @Nullable ItemLike item;
    private final CompoundTag tag = new CompoundTag();

    private FoodTagBuilder(@Nullable ItemLike item) {
        this.item = item;
    }

    public static @NotNull FoodTagBuilder create(@Nullable ItemLike item) {
        return new FoodTagBuilder(item);
    }

    public static @NotNull FoodTagBuilder create() {
        return new FoodTagBuilder(null);
    }

    public FoodTagBuilder add(String key, int value) {
        tag.putInt(key, value);
        return this;
    }

    public void register() {
        if (this.item == null) return;
        FoodTagBuilder.FOOD_LIST.put(item, this);
    }

    public static boolean contains(ItemLike item) {
        return FoodTagBuilder.FOOD_LIST.containsKey(item);
    }

    public static FoodTagBuilder get(ItemLike item) {
        return FoodTagBuilder.FOOD_LIST.getOrDefault(item, null);
    }

    public CustomData toCustomData(CompoundTag @NotNull ... tags) {
        CompoundTag compoundTag = new CompoundTag();
        compoundTag.put(AnvilCraftFooding.MOD_ID, tag);
        for (CompoundTag tag : tags) compoundTag.merge(tag);
        return CustomData.of(compoundTag);
    }
}
