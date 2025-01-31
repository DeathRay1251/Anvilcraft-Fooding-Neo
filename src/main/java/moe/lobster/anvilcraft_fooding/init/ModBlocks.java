package moe.lobster.anvilcraft_fooding.init;

import com.tterrag.registrate.providers.RegistrateRecipeProvider;
import com.tterrag.registrate.util.entry.BlockEntry;
import moe.lobster.anvilcraft_fooding.block.ChiliBlock;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
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
        .loot((tables, block) -> {
            HolderLookup.RegistryLookup<Enchantment> lookup = tables.getRegistries().lookupOrThrow(Registries.ENCHANTMENT);
            LootItemCondition.Builder builder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.CHILI_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(ChiliBlock.AGE, 7));
            tables.add(ModBlocks.CHILI_CROP.get(), tables.applyExplosionDecay(
                    ModBlocks.CHILI_CROP.get(),
                    LootTable.lootTable()
                        .withPool(LootPool.lootPool().add(LootItem.lootTableItem(ModBlocks.CHILI_CROP.asItem())))
                        .withPool(
                            LootPool.lootPool()
                                .when(builder)
                                .add(
                                    LootItem.lootTableItem(ModItems.CHILI.get())
                                        .apply(ApplyBonusCount.addBonusBinomialDistributionCount(lookup.getOrThrow(Enchantments.FORTUNE), 0.5714286F, 3))
                                )
                        )
                )
            );
        })
        .item()
        .model((context, provider) -> {
        })
        .tag()
        .recipe((ctx, provider) ->
            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ctx.get())
                .requires(ModItems.CHILI.get())
                .unlockedBy("has_chili", RegistrateRecipeProvider.has(ModItems.CHILI.get()))
                .save(provider))
        .build()
        .register();

    public static void register() {
    }
}
