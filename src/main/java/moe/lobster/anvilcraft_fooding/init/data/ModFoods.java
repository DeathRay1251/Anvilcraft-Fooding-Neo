package moe.lobster.anvilcraft_fooding.init.data;

import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties CHILI = new FoodProperties.Builder()
        .nutrition(1)
        .saturationModifier(0.0f)
        .alwaysEdible()
        .fast()
        .build();
    public static final FoodProperties CHILI_JAM = new FoodProperties.Builder()
        .nutrition(2)
        .saturationModifier(1.0f)
        .alwaysEdible()
        .build();
}
