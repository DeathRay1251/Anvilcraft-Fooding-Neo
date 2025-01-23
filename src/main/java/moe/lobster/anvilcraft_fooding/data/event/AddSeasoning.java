package moe.lobster.anvilcraft_fooding.data.event;

import com.google.common.base.Predicates;
import moe.lobster.anvilcraft_fooding.AnvilCraftFooding;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.entity.EntityTypeTest;
import net.minecraft.world.phys.AABB;

import java.util.List;
import java.util.Set;


public class AddSeasoning {
    public static void addSeasoning(Level level, BlockPos pos) {
        AABB seasonPos = new AABB(pos).move(0, -1, 0);
        AABB foodPos = new AABB(pos).move(0, -2, 0);
        List<ItemEntity> seasons = level.getEntities(EntityTypeTest.forClass(ItemEntity.class), seasonPos, Predicates.alwaysTrue());
        List<ItemEntity> foods = level.getEntities(EntityTypeTest.forClass(ItemEntity.class), foodPos, Predicates.alwaysTrue());
        if (foods.size() != 1) return;
        ItemEntity food = foods.getFirst();
        ItemStack foodStack = food.getItem();
        CustomData customData1 = foodStack.get(DataComponents.CUSTOM_DATA);
        if (customData1 == null) return;
        if (!customData1.contains(AnvilCraftFooding.MOD_ID)) return;
        CompoundTag foodTag = customData1.copyTag().getCompound(AnvilCraftFooding.MOD_ID);
        for (ItemEntity season : seasons) {
            ItemStack seasonStack = season.getItem();
            CustomData customData2 = seasonStack.get(DataComponents.CUSTOM_DATA);
            if (customData2 == null) continue;
            if (!customData2.contains(AnvilCraftFooding.MOD_ID)) continue;
            CompoundTag seasonTag = customData2.copyTag().getCompound(AnvilCraftFooding.MOD_ID);
            foodTag = mergeTag(foodTag, foodStack.getCount(), seasonTag, seasonStack.getCount());
            seasonStack.setCount(0);
            season.setItem(seasonStack);
        }
        ItemStack outStack = foodStack.copy();
        CompoundTag outTag = new CompoundTag();
        outTag.put(AnvilCraftFooding.MOD_ID, foodTag);
        outStack.set(DataComponents.CUSTOM_DATA, CustomData.of(outTag));
        outStack.setCount(foodStack.getCount());
        foodStack.setCount(0);
        food.setItem(outStack);
    }

    public static CompoundTag mergeTag(CompoundTag foodTag, int foodCount, CompoundTag seasonTag, int seasonCount) {
        CompoundTag outComeTag = new CompoundTag();
        Set<String> seasonKey = seasonTag.getAllKeys();
        Set<String> foodKey = foodTag.getAllKeys();
        for (String key : seasonKey) {
            if (foodTag.contains(key)) {
                int grade = foodTag.getInt(key) * foodCount + seasonTag.getInt(key) * seasonCount;
                grade = grade / foodCount;
                outComeTag.putInt(key, grade);
            } else {
                outComeTag.putInt(key, seasonTag.getInt(key) * seasonCount / foodCount);
            }
        }
        for (String key : foodKey) {
            if (!outComeTag.contains(key)) {
                outComeTag.putInt(key, foodTag.getInt(key));
            }
        }
        return outComeTag;
    }
}
