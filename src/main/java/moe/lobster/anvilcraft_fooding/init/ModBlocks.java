package moe.lobster.anvilcraft_fooding.init;

import com.tterrag.registrate.providers.RegistrateBlockstateProvider;
import com.tterrag.registrate.providers.RegistrateRecipeProvider;
import com.tterrag.registrate.providers.loot.RegistrateBlockLootTables;
import com.tterrag.registrate.util.entry.BlockEntry;
import moe.lobster.anvilcraft_fooding.AnvilCraftFooding;
import moe.lobster.anvilcraft_fooding.block.ChiliCropBlock;
import moe.lobster.anvilcraft_fooding.block.FruitLeavesBlock;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.VariantBlockStateBuilder;

import java.util.function.Function;

import static com.ibm.icu.impl.CurrencyData.provider;
import static moe.lobster.anvilcraft_fooding.AnvilCraftFooding.REGISTRATE;
import static moe.lobster.anvilcraft_fooding.init.ModTreeGrowers.LEMON_TREE_GROWER;

public class ModBlocks {
    public static final BlockEntry<ChiliCropBlock> CHILI_CROP = REGISTRATE
        .block("chili_crop", ChiliCropBlock::new)
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
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(ChiliCropBlock.AGE, 7));
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
            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ctx.get(), 3)
                .requires(ModItems.CHILI.get())
                .unlockedBy("has_chili", RegistrateRecipeProvider.has(ModItems.CHILI.get()))
                .save(provider))
        .build()
        .register();

    public static final BlockEntry<RotatedPillarBlock> LEMON_LOG = REGISTRATE
        .block("lemon_log", RotatedPillarBlock::new)
        .tag(BlockTags.LOGS, BlockTags.LOGS_THAT_BURN, BlockTags.MINEABLE_WITH_AXE, BlockTags.OVERWORLD_NATURAL_LOGS, BlockTags.SNAPS_GOAT_HORN)
        .properties(
            p -> p
                .mapColor(pro -> pro.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MapColor.WOOD : MapColor.COLOR_BROWN)
                .instrument(NoteBlockInstrument.BASS)
                .strength(2.0F)
                .sound(SoundType.WOOD)
                .ignitedByLava()
        )
        .onRegisterAfter(Registries.BLOCK, ctx -> ((FireBlock) Blocks.FIRE).setFlammable(ctx, 5, 5))
        .blockstate((context, provider) -> provider.logBlock(context.get()))
        .loot(RegistrateBlockLootTables::dropSelf)
        .item()
        .burnTime(300)
        .build()
        .register();

    public static final BlockEntry<RotatedPillarBlock> LEMON_WOOD = REGISTRATE
        .block("lemon_wood", RotatedPillarBlock::new)
        .tag(BlockTags.LOGS, BlockTags.LOGS_THAT_BURN, BlockTags.MINEABLE_WITH_AXE)
        .properties(
            p -> p
                .mapColor(MapColor.COLOR_BROWN)
                .instrument(NoteBlockInstrument.BASS)
                .strength(2.0F)
                .sound(SoundType.WOOD)
                .ignitedByLava()
        )
        .onRegisterAfter(Registries.BLOCK, ctx -> ((FireBlock) Blocks.FIRE).setFlammable(ctx, 5, 5))
        .blockstate((context, provider) -> provider.axisBlock(context.get(), provider.blockTexture(LEMON_LOG.get()), provider.blockTexture(LEMON_LOG.get())))
        .loot(RegistrateBlockLootTables::dropSelf)
        .item()
        .burnTime(300)
        .build()
        .register();
    public static final BlockEntry<FruitLeavesBlock> LEMON_LEAVE = REGISTRATE
        .block("lemon_leave", FruitLeavesBlock::new)
        .tag(BlockTags.LEAVES, BlockTags.MINEABLE_WITH_HOE)
        .properties(
            p -> p
                .noOcclusion()
                .mapColor(MapColor.PLANT)
                .randomTicks()
                .sound(SoundType.GRASS)
                .pushReaction(PushReaction.DESTROY)
                .ignitedByLava()
        )
        .onRegisterAfter(Registries.BLOCK, ctx -> ((FireBlock) Blocks.FIRE).setFlammable(ctx, 30, 60))
        .blockstate((context, provider) -> {
            VariantBlockStateBuilder variantBuilder = provider.getVariantBuilder(context.get());
            leaveModule(provider, variantBuilder, state -> state.with(FruitLeavesBlock.AGE, 0), "lemon_leave_stage0");
            leaveModule(provider, variantBuilder, state -> state.with(FruitLeavesBlock.AGE, 1), "lemon_leave_stage1");
        })
//        .blockstate((context, provider) -> {
//        })
        .item()
        .model((context, provider) -> {
            ResourceLocation itemKey = BuiltInRegistries.ITEM.getKey(context.get());
            ResourceLocation blockModel = AnvilCraftFooding.of("block/lemon_leave_stage0");
            provider.withExistingParent(itemKey.toString(), blockModel);
        })
        .build()
        .register();

    public static final BlockEntry<SaplingBlock> LEMON_SAPLING = REGISTRATE
        .block("lemon_sapling", p -> new SaplingBlock(LEMON_TREE_GROWER, p))
        .tag(BlockTags.MINEABLE_WITH_AXE, BlockTags.SAPLINGS)
        .properties(
            p -> p.noCollission()
                .instabreak()
                .randomTicks()
                .mapColor(MapColor.PLANT)
                .sound(SoundType.GRASS)
                .pushReaction(PushReaction.DESTROY)
                .ignitedByLava()
        )
        .blockstate(
            (context, provider) ->
                provider.simpleBlock(context.get(),
                    provider.models().cross(context.getName(), provider.blockTexture(context.get())).renderType("cutout")
                ))
        .loot(RegistrateBlockLootTables::dropSelf)
        .item()
        .burnTime(100)
        .model((ctx, provider) ->
            provider.withExistingParent(ctx.getName(), provider.mcLoc("item/generated"))
                .texture("layer0", provider.itemTexture(ctx))
        )
        .build()
        .register();

    public static void register() {
    }

    private static void leaveModule(RegistrateBlockstateProvider provider, VariantBlockStateBuilder variantBuilder, Function<VariantBlockStateBuilder.PartialBlockstate, VariantBlockStateBuilder.PartialBlockstate> stateFactory, String path) {
        ResourceLocation location = AnvilCraftFooding.of("block/" + path);
        BlockModelBuilder stage = provider.models().leaves(path, location).renderType("cutout");
        VariantBlockStateBuilder.PartialBlockstate state = stateFactory.apply(variantBuilder.partialState());
        variantBuilder.addModels(state, new ConfiguredModel(stage));
    }
}
