package moe.lobster.anvilcraft_fooding.init;

import com.tterrag.registrate.util.entry.ItemEntry;
import moe.lobster.anvilcraft_fooding.data.FoodTagBuilder;
import moe.lobster.anvilcraft_fooding.data.ModFoods;
import moe.lobster.anvilcraft_fooding.data.foodsystem.Tastes;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.common.Tags;

import static moe.lobster.anvilcraft_fooding.AnvilCraftFooding.REGISTRATE;

public class ModItems {
    public static final ItemEntry<? extends Item> CHILI = REGISTRATE
        .item("chili", p -> new Item(p.food(ModFoods.CHILI)))
        .properties(
            properties -> properties.component(
                DataComponents.CUSTOM_DATA,
                FoodTagBuilder.create()
                    .add(Tastes.HOT.get(), 1)
                    .toCustomData()
            )
        )
        .tag(Tags.Items.FOODS)
        .register();

    public static void test(ItemStack itemStack) {

    }

    public static void register() {

    }
}
