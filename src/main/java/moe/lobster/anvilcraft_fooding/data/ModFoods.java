package moe.lobster.anvilcraft_fooding.data;

import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties CHILI = new FoodProperties.Builder()
        .nutrition(1)
        .saturationModifier(0.0f)
        .alwaysEdible()
        .fast()
        .build();
}
