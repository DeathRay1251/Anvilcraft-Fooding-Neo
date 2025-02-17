package moe.lobster.anvilcraft_fooding.init;

import com.tterrag.registrate.providers.RegistrateRecipeProvider;
import com.tterrag.registrate.providers.loot.RegistrateBlockLootTables;
import com.tterrag.registrate.util.entry.BlockEntry;
import moe.lobster.anvilcraft_fooding.AnvilCraftFooding;
import moe.lobster.anvilcraft_fooding.block.ChiliCropBlock;
import moe.lobster.anvilcraft_fooding.block.FruitLeavesBlock;
import moe.lobster.anvilcraft_fooding.data.ModCompostable;
import moe.lobster.anvilcraft_fooding.data.model.ModModelProvider;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.client.model.generators.VariantBlockStateBuilder;

import static moe.lobster.anvilcraft_fooding.AnvilCraftFooding.REGISTRATE;
import static moe.lobster.anvilcraft_fooding.init.ModTreeGrowers.LEMON_TREE_GROWER;

public class ModBlocks {
    public static final BlockEntry<ChiliCropBlock> CHILI_CROP = REGISTRATE
        .block("chili_crop", ChiliCropBlock::new)
        .tag(BlockTags.CROPS)
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
        .compostable(ModCompostable.CROP_CHANCE)
        .model((context, provider) -> {
        })
        .recipe((ctx, provider) ->
            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ctx.get(), 3)
                .requires(ModItems.CHILI.get())
                .unlockedBy("has_chili", RegistrateRecipeProvider.has(ModItems.CHILI.get()))
                .save(provider))
        .build()
        .register();

    public static final BlockEntry<RotatedPillarBlock> LEMON_LOG = REGISTRATE
        .block("lemon_log", RotatedPillarBlock::new)
        .tag(BlockTags.LOGS, BlockTags.LOGS_THAT_BURN, BlockTags.MINEABLE_WITH_AXE, ModBlockTags.LEMON_LOG)
        .properties(
            p -> BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)
        )
        .onRegisterAfter(Registries.BLOCK, ctx -> ((FireBlock) Blocks.FIRE).setFlammable(ctx, 5, 5))
        .blockstate((context, provider) -> provider.logBlock(context.get()))
        .loot(RegistrateBlockLootTables::dropSelf)
        .item()
        .tag(ItemTags.LOGS, ModItemTags.LEMON_LOG)
        .burnTime(300)
        .build()
        .register();

    public static final BlockEntry<RotatedPillarBlock> STRIPPED_LEMON_LOG = REGISTRATE
        .block("stripped_lemon_log", RotatedPillarBlock::new)
        .tag(BlockTags.LOGS, BlockTags.LOGS_THAT_BURN, BlockTags.MINEABLE_WITH_AXE, ModBlockTags.LEMON_LOG)
        .properties(
            p -> BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)
        )
        .onRegisterAfter(Registries.BLOCK, ctx -> ((FireBlock) Blocks.FIRE).setFlammable(ctx, 5, 5))
        .blockstate((context, provider) -> provider.logBlock(context.get()))
        .loot(RegistrateBlockLootTables::dropSelf)
        .item()
        .tag(ItemTags.LOGS, ModItemTags.LEMON_LOG)
        .burnTime(300)
        .build()
        .register();

    public static final BlockEntry<RotatedPillarBlock> LEMON_WOOD = REGISTRATE
        .block("lemon_wood", RotatedPillarBlock::new)
        .tag(BlockTags.LOGS, BlockTags.LOGS_THAT_BURN, BlockTags.MINEABLE_WITH_AXE, ModBlockTags.LEMON_LOG)
        .properties(
            p -> BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)
        )
        .onRegisterAfter(Registries.BLOCK, ctx -> ((FireBlock) Blocks.FIRE).setFlammable(ctx, 5, 5))
        .blockstate((context, provider) ->
            provider.axisBlock(
                context.get(),
                provider.blockTexture(LEMON_LOG.get()),
                provider.blockTexture(LEMON_LOG.get())
            )
        )
        .loot(RegistrateBlockLootTables::dropSelf)
        .item()
        .recipe((ctx, provider) ->
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ctx.get(), 3)
                .pattern("AA")
                .pattern("AA")
                .define('A', ModBlocks.LEMON_LOG.get())
                .unlockedBy("has_lemon_log", RegistrateRecipeProvider.has(ModBlocks.LEMON_LOG.get()))
                .save(provider)
        )
        .tag(ItemTags.LOGS, ModItemTags.LEMON_LOG)
        .burnTime(300)
        .build()
        .register();

    public static final BlockEntry<RotatedPillarBlock> STRIPPED_LEMON_WOOD = REGISTRATE
        .block("stripped_lemon_wood", RotatedPillarBlock::new)
        .tag(BlockTags.LOGS, BlockTags.LOGS_THAT_BURN, BlockTags.MINEABLE_WITH_AXE, ModBlockTags.LEMON_LOG)
        .properties(
            p -> BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)
        )
        .onRegisterAfter(Registries.BLOCK, ctx -> ((FireBlock) Blocks.FIRE).setFlammable(ctx, 5, 5))
        .blockstate((context, provider) ->
            provider.axisBlock(
                context.get(),
                provider.blockTexture(ModBlocks.STRIPPED_LEMON_LOG.get()),
                provider.blockTexture(ModBlocks.STRIPPED_LEMON_LOG.get())
            )
        )
        .loot(RegistrateBlockLootTables::dropSelf)
        .item()
        .tag(ItemTags.LOGS, ModItemTags.LEMON_LOG)
        .burnTime(300)
        .build()
        .register();

    public static final BlockEntry<Block> LEMON_PLANKS = REGISTRATE
        .block("lemon_planks", Block::new)
        .tag(BlockTags.PLANKS, BlockTags.MINEABLE_WITH_AXE)
        .properties(
            p -> BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
        )
        .onRegisterAfter(Registries.BLOCK, ctx -> ((FireBlock) Blocks.FIRE).setFlammable(ctx, 5, 20))
        .blockstate((context, provider) -> {
            provider.simpleBlock(context.get());
        })
        .loot(RegistrateBlockLootTables::dropSelf)
        .item()
        .recipe((ctx, provider) ->
            ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ctx.get(), 4)
                .requires(ModBlocks.LEMON_LOG.get())
                .unlockedBy("has_lemon_log_tag", RegistrateRecipeProvider.has(ModItemTags.LEMON_LOG))
                .save(provider)
        )
        .tag(ItemTags.PLANKS)
        .burnTime(300)
        .build()
        .register();

    public static final BlockEntry<StairBlock> LEMON_STAIRS = REGISTRATE
        .block("lemon_stairs", p -> new StairBlock(ModBlocks.LEMON_PLANKS.getDefaultState(), BlockBehaviour.Properties.ofFullCopy(ModBlocks.LEMON_PLANKS.get())))
        .tag(BlockTags.WOODEN_STAIRS, BlockTags.STAIRS, BlockTags.MINEABLE_WITH_AXE)
        .properties(
            p -> BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS)
        )
        .onRegisterAfter(Registries.BLOCK, ctx -> ((FireBlock) Blocks.FIRE).setFlammable(ctx, 5, 20))
        .blockstate((context, provider) -> {
            provider.stairsBlock(context.get(), AnvilCraftFooding.of("block/" + "lemon_planks"));
        })
        .item()
        .burnTime(300)
        .recipe((ctx, provider) ->
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ctx.get(), 4)
                .pattern("A  ")
                .pattern("AA ")
                .pattern("AAA")
                .define('A', ModBlocks.LEMON_PLANKS.get())
                .unlockedBy("has_lemon_planks", RegistrateRecipeProvider.has(ModBlocks.LEMON_PLANKS.get()))
                .save(provider)
        )
        .tag(ItemTags.WOODEN_STAIRS, ItemTags.STAIRS)
        .build()
        .register();

    public static final BlockEntry<FruitLeavesBlock> LEMON_LEAVE = REGISTRATE
        .block("lemon_leave", FruitLeavesBlock::new)
        .tag(BlockTags.LEAVES, BlockTags.MINEABLE_WITH_HOE)
        .properties(
            p -> BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)
        )
        .onRegisterAfter(Registries.BLOCK, ctx -> ((FireBlock) Blocks.FIRE).setFlammable(ctx, 30, 60))
        .blockstate((context, provider) -> {
            VariantBlockStateBuilder variantBuilder = provider.getVariantBuilder(context.get());
            ModModelProvider.leaveModel(provider, variantBuilder, state -> state.with(FruitLeavesBlock.AGE, 0), context.getName(), "0");
            ModModelProvider.leaveModel(provider, variantBuilder, state -> state.with(FruitLeavesBlock.AGE, 1), context.getName(), "1");
        })
        .loot((tables, block) ->
            tables.add(ModBlocks.LEMON_LEAVE.get(), tables.createLeavesDrops(ModBlocks.LEMON_LEAVE.get(), ModBlocks.LEMON_SAPLING.get(), 0.2F, 0.4f))
        )
        .item()
        .compostable(ModCompostable.LEAVES_CHANCE)
        .model((context, provider) -> {
            ResourceLocation itemKey = BuiltInRegistries.ITEM.getKey(context.get());
            ResourceLocation blockModel = AnvilCraftFooding.of("block/" + context.getName() + "_stage0");
            provider.withExistingParent(itemKey.toString(), blockModel);
        })
        .build()
        .register();

    public static final BlockEntry<SaplingBlock> LEMON_SAPLING = REGISTRATE
        .block("lemon_sapling", p -> new SaplingBlock(LEMON_TREE_GROWER, p))
        .tag(BlockTags.MINEABLE_WITH_AXE, BlockTags.SAPLINGS)
        .properties(
            p -> BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)
        )
        .blockstate(
            (context, provider) ->
                provider.simpleBlock(context.get(),
                    provider.models().cross(context.getName(), provider.blockTexture(context.get())).renderType("cutout")
                ))
        .loot(RegistrateBlockLootTables::dropSelf)
        .item()
        .tag(ItemTags.SAPLINGS)
        .compostable(ModCompostable.SAPLING_CHANCE)
        .burnTime(100)
        .model((ctx, provider) ->
            provider.withExistingParent(ctx.getName(), provider.mcLoc("item/generated"))
                .texture("layer0", AnvilCraftFooding.of("block/" + ctx.getName()).toString())
        )
        .build()
        .register();

    public static void register() {
    }
}
