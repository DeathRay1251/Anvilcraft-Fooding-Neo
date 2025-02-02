package moe.lobster.anvilcraft_fooding.data.loader;

import com.tterrag.registrate.providers.RegistrateRecipeProvider;
import dev.dubhe.anvilcraft.recipe.anvil.StampingRecipe;
import moe.lobster.anvilcraft_fooding.AnvilCraftFooding;
import moe.lobster.anvilcraft_fooding.init.ModItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;

public class StampingRecipeLoader {

    public static void init(RegistrateRecipeProvider provider) {
        stamping(provider, ModItems.CHILI, 8, ModItems.CHILI_JAM);
    }

    private static void stamping(RegistrateRecipeProvider provider, ItemLike input, int inputCount, ItemLike result, int resultCount) {
        StampingRecipe.builder()
            .requires(input, inputCount)
            .result(result, resultCount)
            .save(provider,
                AnvilCraftFooding.of("stamping/%s/%s"
                    .formatted(
                        BuiltInRegistries.ITEM
                            .getKey(input.asItem())
                            .getPath(),
                        BuiltInRegistries.ITEM
                            .getKey(result.asItem())
                            .getPath())));
    }

    private static void stamping(RegistrateRecipeProvider provider, ItemLike input, ItemLike result) {
        stamping(provider, input, 1, result, 1);
    }

    private static void stamping(RegistrateRecipeProvider provider, ItemLike input, int inputCount, ItemLike result) {
        stamping(provider, input, inputCount, result, 1);
    }

    private static void stamping(RegistrateRecipeProvider provider, ItemLike input, ItemLike result, int resultCount) {
        stamping(provider, input, 1, result, resultCount);
    }

    private static @NotNull String getName(@NotNull ItemLike item) {
        return BuiltInRegistries.ITEM.getKey(item.asItem()).getPath();
    }
}
