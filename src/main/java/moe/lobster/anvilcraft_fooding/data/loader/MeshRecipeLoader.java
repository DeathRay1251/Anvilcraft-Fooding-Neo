package moe.lobster.anvilcraft_fooding.data.loader;

import com.tterrag.registrate.providers.RegistrateRecipeProvider;
import dev.dubhe.anvilcraft.recipe.anvil.MeshRecipe;
import moe.lobster.anvilcraft_fooding.AnvilCraftFooding;
import moe.lobster.anvilcraft_fooding.init.ModBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.storage.loot.providers.number.BinomialDistributionGenerator;

public class MeshRecipeLoader {
    public static void init(RegistrateRecipeProvider provider) {
        mesh(provider, Items.SHORT_GRASS, ModBlocks.CHILI_CROP.asItem(), 0.01f);
        mesh(provider, Items.ACACIA_LEAVES, ModBlocks.LEMON_SAPLING.asItem(), 0.01f);
    }

    private static void mesh(RegistrateRecipeProvider provider, ItemLike input, ItemLike result, float chance) {
        MeshRecipe.builder()
            .input(Ingredient.of(input))
            .result(new ItemStack(result))
            .resultAmount(BinomialDistributionGenerator.binomial(1, chance))
            .save(
                provider,
                AnvilCraftFooding.of("mesh/%s/%s"
                    .formatted(
                        BuiltInRegistries.ITEM
                            .getKey(input.asItem())
                            .getPath(),
                        BuiltInRegistries.ITEM
                            .getKey(result.asItem())
                            .getPath())));
    }
}
