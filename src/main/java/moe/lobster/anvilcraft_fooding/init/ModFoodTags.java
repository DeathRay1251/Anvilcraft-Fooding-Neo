package moe.lobster.anvilcraft_fooding.init;

import dev.dubhe.anvilcraft.init.ModItems;
import moe.lobster.anvilcraft_fooding.data.FoodTagBuilder;
import moe.lobster.anvilcraft_fooding.data.foodsystem.Tastes;
import net.minecraft.world.item.Items;

public class ModFoodTags {
    public static void register() {
        FoodTagBuilder.create(Items.APPLE)
            .add(Tastes.FRUIT.get(), 1)
            .register();
        FoodTagBuilder.create(Items.GOLDEN_APPLE)
            .add(Tastes.LUXURIOUS.get(), 1)
            .add(Tastes.FRUIT.get(), 1)
            .register();
        FoodTagBuilder.create(Items.ENCHANTED_GOLDEN_APPLE)
            .add(Tastes.LUXURIOUS.get(), 2)
            .add(Tastes.FRUIT.get(), 1)
            .add(Tastes.MYSTERY.get(), 1)
            .add(Tastes.UNBELIEVABLE.get(), 1)
            .register();
        FoodTagBuilder.create(Items.MELON_SLICE)
            .add(Tastes.FRUIT.get(), 2)
            .register();
        FoodTagBuilder.create(Items.SWEET_BERRIES)
            .add(Tastes.FRUIT.get(), 1)
            .register();
        FoodTagBuilder.create(Items.GLOW_BERRIES)
            .add(Tastes.FRUIT.get(), 1)
            .add(Tastes.UNBELIEVABLE.get(), 1)
            .register();
        FoodTagBuilder.create(Items.CHORUS_FRUIT)
            .add(Tastes.FRUIT.get(), 1)
            .add(Tastes.UNBELIEVABLE.get(), 1)
            .register();
        FoodTagBuilder.create(Items.CARROT)
            .add(Tastes.VEGETABLE.get(), 1)
            .register();
        FoodTagBuilder.create(Items.GOLDEN_CARROT)
            .add(Tastes.VEGETABLE.get(), 1)
            .add(Tastes.LUXURIOUS.get(), 1)
            .register();
        FoodTagBuilder.create(Items.POTATO)
            .add(Tastes.RAW.get(), 1)
            .add(Tastes.VEGETABLE.get(), 1)
            .register();
        FoodTagBuilder.create(Items.BAKED_POTATO)
            .add(Tastes.VEGETABLE.get(), 1)
            .add(Tastes.FULL.get(), 1)
            .add(Tastes.BAKED.get(), 1)
            .register();
        FoodTagBuilder.create(Items.POISONOUS_POTATO)
            .add(Tastes.RAW.get(), 1)
            .add(Tastes.VEGETABLE.get(), 1)
            .add(Tastes.POISON.get(), 1)
            .register();
        FoodTagBuilder.create(Items.BEETROOT)
            .add(Tastes.SWEET.get(), 1)
            .add(Tastes.VEGETABLE.get(), 1)
            .register();
        FoodTagBuilder.create(Items.DRIED_KELP)
            .add(Tastes.VEGETABLE.get(), 1)
            .add(Tastes.SEAFOOD.get(), 1)
            .register();
        FoodTagBuilder.create(Items.BEEF)
            .add(Tastes.MEAT.get(), 1)
            .add(Tastes.RAW.get(), 1)
            .register();
        FoodTagBuilder.create(Items.COOKED_BEEF)
            .add(Tastes.BAKED.get(), 1)
            .add(Tastes.MEAT.get(), 1)
            .register();
        FoodTagBuilder.create(Items.PORKCHOP)
            .add(Tastes.MEAT.get(), 1)
            .add(Tastes.RAW.get(), 1)
            .register();
        FoodTagBuilder.create(Items.COOKED_PORKCHOP)
            .add(Tastes.MEAT.get(), 1)
            .add(Tastes.BAKED.get(), 1)
            .register();
        FoodTagBuilder.create(Items.MUTTON)
            .add(Tastes.MEAT.get(), 1)
            .add(Tastes.RAW.get(), 1)
            .register();
        FoodTagBuilder.create(Items.COOKED_MUTTON)
            .add(Tastes.BAKED.get(), 1)
            .add(Tastes.MEAT.get(), 1)
            .register();
        FoodTagBuilder.create(Items.CHICKEN)
            .add(Tastes.POISON.get(), 1)
            .add(Tastes.MEAT.get(), 1)
            .add(Tastes.RAW.get(), 1)
            .register();
        FoodTagBuilder.create(Items.COOKED_CHICKEN)
            .add(Tastes.MEAT.get(), 1)
            .add(Tastes.BAKED.get(), 1)
            .register();
        FoodTagBuilder.create(Items.RABBIT)
            .add(Tastes.MEAT.get(), 1)
            .add(Tastes.RAW.get(), 1)
            .register();
        FoodTagBuilder.create(Items.COOKED_RABBIT)
            .add(Tastes.MEAT.get(), 1)
            .add(Tastes.BAKED.get(), 1)
            .register();
        FoodTagBuilder.create(Items.COD)
            .add(Tastes.SEAFOOD.get(), 1)
            .add(Tastes.MEAT.get(), 1)
            .add(Tastes.RAW.get(), 1)
            .register();
        FoodTagBuilder.create(Items.COOKED_COD)
            .add(Tastes.SEAFOOD.get(), 1)
            .add(Tastes.MEAT.get(), 1)
            .add(Tastes.BAKED.get(), 1)
            .register();
        FoodTagBuilder.create(Items.SALMON)
            .add(Tastes.SEAFOOD.get(), 1)
            .add(Tastes.MEAT.get(), 1)
            .add(Tastes.RAW.get(), 1)
            .register();
        FoodTagBuilder.create(Items.COOKED_SALMON)
            .add(Tastes.SEAFOOD.get(), 1)
            .add(Tastes.MEAT.get(), 1)
            .add(Tastes.BAKED.get(), 1)
            .register();
        FoodTagBuilder.create(Items.TROPICAL_FISH)
            .add(Tastes.SEAFOOD.get(), 1)
            .add(Tastes.MEAT.get(), 1)
            .add(Tastes.RAW.get(), 1)
            .register();
        FoodTagBuilder.create(Items.PUFFERFISH)
            .add(Tastes.SEAFOOD.get(), 1)
            .add(Tastes.MEAT.get(), 1)
            .add(Tastes.RAW.get(), 1)
            .add(Tastes.POISON.get(), 1)
            .register();
        FoodTagBuilder.create(Items.BREAD)
            .add(Tastes.FULL.get(), 1)
            .register();
        FoodTagBuilder.create(Items.COOKIE)
            .add(Tastes.CHOCOLATE.get(), 1)
            .add(Tastes.SWEET.get(), 1)
            .add(Tastes.BAKED.get(), 1)
            .register();
        FoodTagBuilder.create(Items.PUMPKIN_PIE)
            .add(Tastes.VEGETABLE.get(), 1)
            .add(Tastes.FULL.get(), 1)
            .register();
        FoodTagBuilder.create(Items.ROTTEN_FLESH)
            .add(Tastes.POISON.get(), 2)
            .register();
        FoodTagBuilder.create(Items.SPIDER_EYE)
            .add(Tastes.POISON.get(), 2)
            .add(Tastes.MYSTERY.get(), 1)
            .register();
        FoodTagBuilder.create(Items.MUSHROOM_STEW)
            .add(Tastes.SOUP.get(), 1)
            .add(Tastes.MUSHROOM.get(), 1)
            .add(Tastes.WARM.get(), 1)
            .register();
        FoodTagBuilder.create(Items.BEETROOT_SOUP)
            .add(Tastes.SOUP.get(), 1)
            .add(Tastes.VEGETABLE.get(), 1)
            .add(Tastes.WARM.get(), 1)
            .add(Tastes.SWEET.get(), 1)
            .register();
        FoodTagBuilder.create(Items.RABBIT_STEW)
            .add(Tastes.VEGETABLE.get(), 1)
            .add(Tastes.SOUP.get(), 1)
            .add(Tastes.MUSHROOM.get(), 1)
            .add(Tastes.MEAT.get(), 1)
            .add(Tastes.WARM.get(), 1)
            .register();
        FoodTagBuilder.create(Items.MILK_BUCKET)
            .add(Tastes.MILK.get(), 1)
            .register();
        FoodTagBuilder.create(dev.dubhe.anvilcraft.init.ModItems.CREAM.asItem())
            .add(Tastes.CREAM.get(), 1)
            .add(Tastes.WESTERN.get(), 1)
            .register();
        FoodTagBuilder.create(dev.dubhe.anvilcraft.init.ModItems.FLOUR.asItem())
            .add(Tastes.FULL.get(), 1)
            .register();
        FoodTagBuilder.create(dev.dubhe.anvilcraft.init.ModItems.DOUGH.asItem())
            .add(Tastes.FULL.get(), 2)
            .register();
        FoodTagBuilder.create(dev.dubhe.anvilcraft.init.ModItems.COCOA_LIQUOR.asItem())
            .add(Tastes.WESTERN.get(), 1)
            .add(Tastes.CHOCOLATE.get(), 1)
            .register();
        FoodTagBuilder.create(dev.dubhe.anvilcraft.init.ModItems.COCOA_BUTTER.asItem())
            .add(Tastes.WESTERN.get(), 1)
            .add(Tastes.CHOCOLATE.get(), 1)
            .register();
        FoodTagBuilder.create(dev.dubhe.anvilcraft.init.ModItems.COCOA_POWDER.asItem())
            .add(Tastes.WESTERN.get(), 1)
            .add(Tastes.CHOCOLATE.get(), 1)
            .register();
        FoodTagBuilder.create(dev.dubhe.anvilcraft.init.ModItems.CHOCOLATE.asItem())
            .add(Tastes.SWEET.get(), 2)
            .add(Tastes.WESTERN.get(), 2)
            .add(Tastes.CHOCOLATE.get(), 2)
            .register();
        FoodTagBuilder.create(dev.dubhe.anvilcraft.init.ModItems.CHOCOLATE_BLACK.asItem())
            .add(Tastes.BITTER.get(), 1)
            .add(Tastes.SWEET.get(), 1)
            .add(Tastes.WESTERN.get(), 2)
            .add(Tastes.CHOCOLATE.get(), 2)
            .register();
        FoodTagBuilder.create(dev.dubhe.anvilcraft.init.ModItems.CHOCOLATE_WHITE.asItem())
            .add(Tastes.SWEET.get(), 3)
            .add(Tastes.WESTERN.get(), 2)
            .add(Tastes.CHOCOLATE.get(), 2)
            .register();
        FoodTagBuilder.create(dev.dubhe.anvilcraft.init.ModItems.CREAMY_BREAD_ROLL.asItem())
            .add(Tastes.CREAM.get(), 1)
            .add(Tastes.WESTERN.get(), 1)
            .add(Tastes.FULL.get(), 2)
            .add(Tastes.SWEET.get(), 1)
            .register();
        FoodTagBuilder.create(dev.dubhe.anvilcraft.init.ModItems.BEEF_MUSHROOM_STEW.asItem())
            .add(Tastes.MEAT.get(), 1)
            .add(Tastes.MUSHROOM.get(), 2)
            .add(Tastes.SOUP.get(), 1)
            .add(Tastes.WARM.get(), 1)
            .register();
        FoodTagBuilder.create(ModItems.UTUSAN.asItem())
            .add(Tastes.POISON.get(), 1)
            .add(Tastes.MYSTERY.get(), 2)
            .register();
        FoodTagBuilder.create(Items.HONEY_BOTTLE)
            .add(Tastes.SWEET.get(), 3)
            .register();
        FoodTagBuilder.create(Items.KELP)
            .add(Tastes.SEAFOOD.get(), 1)
            .add(Tastes.RAW.get(), 1)
            .register();
        FoodTagBuilder.create(Items.SEA_PICKLE)
            .add(Tastes.SEAFOOD.get(), 1)
            .add(Tastes.RAW.get(), 1)
            .register();
        FoodTagBuilder.create(Items.SUGAR_CANE)
            .add(Tastes.SWEET.get(), 1)
            .add(Tastes.VEGETABLE.get(), 1)
            .register();
        FoodTagBuilder.create(Items.SUGAR)
            .add(Tastes.SWEET.get(), 2)
            .register();
        FoodTagBuilder.create(Items.COCOA_BEANS)
            .add(Tastes.CHOCOLATE.get(), 1)
            .register();
        FoodTagBuilder.create(Items.PUMPKIN)
            .add(Tastes.VEGETABLE.get(), 1)
            .register();
        FoodTagBuilder.create(Items.MELON)
            .add(Tastes.FRUIT.get(), 1)
            .add(Tastes.SWEET.get(), 1)
            .register();
        FoodTagBuilder.create(Items.HONEY_BLOCK)
            .add(Tastes.SWEET.get(), 14)
            .register();
    }
}
