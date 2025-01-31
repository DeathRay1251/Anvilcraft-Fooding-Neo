package moe.lobster.anvilcraft_fooding.init;

import com.tterrag.registrate.util.entry.BlockEntry;
import moe.lobster.anvilcraft_fooding.block.ChiliBlock;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;

import static moe.lobster.anvilcraft_fooding.AnvilCraftFooding.REGISTRATE;

public class ModBlocks {
    public static final BlockEntry<ChiliBlock> CHILI_CROP = REGISTRATE
        .block("chili_crop", ChiliBlock::new)
        .properties(p -> p
            .mapColor(MapColor.PLANT)
            .noCollission()
            .randomTicks()
            .instabreak()
            .sound(SoundType.CROP)
            .pushReaction(PushReaction.DESTROY))
        .blockstate((context, provider) -> {
        })
        .loot((table, block) -> {
            LootItemCondition.Builder builder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.CHILI_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(ChiliBlock.AGE, 7));
            table.add(block, table.createCropDrops(ModBlocks.CHILI_CROP.get(), ModItems.CHILI.get(), ModBlocks.CHILI_CROP.asItem(), builder));
        })
        .item()
        .model((context, provider) -> {
        })
        .tag()
        .recipe((ctx, provider) -> {
            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ctx.get())
                .requires(ModItems.CHILI.get())
                .unlockedBy("has_chili", provider.has(ModItems.CHILI.get()))
                .save(provider);
        })
        .build()
        .register();

    public static void register() {
    }
}
