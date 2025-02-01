package moe.lobster.anvilcraft_fooding.data;

import com.tterrag.registrate.providers.ProviderType;
import moe.lobster.anvilcraft_fooding.AnvilCraftFooding;
import moe.lobster.anvilcraft_fooding.data.loader.RecipeHandler;
import moe.lobster.anvilcraft_fooding.data.provider.ModFeatureProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;


@EventBusSubscriber(modid = AnvilCraftFooding.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class AnvilCraftFoodingDatagen {
    @SubscribeEvent
    public static void onGatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        PackOutput packOutput = generator.getPackOutput();
        generator.addProvider(event.includeServer(), new ModFeatureProvider(packOutput, lookupProvider));
    }

    //    @SubscribeEvent
//    public static void gatherData(GatherDataEvent event) {
//        DataGenerator generator = event.getGenerator();
//        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
//        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
//        PackOutput packOutput = generator.getPackOutput();
//
//        generator.addProvider(event.includeServer(), new ModRegistryProvider(packOutput, lookupProvider));
//        generator.addProvider(event.includeServer(), new ModLootTableProvider(packOutput, lookupProvider));
//        generator.addProvider(
//            event.includeServer(), new ModPoiTagProvider(packOutput, lookupProvider, existingFileHelper));
//        generator.addProvider(event.includeServer(), new ModFurnaceFuelProvider(packOutput, lookupProvider));
//        generator.addProvider(event.includeServer(), new ModDamageTypeProvider(packOutput, lookupProvider));
//        generator.addProvider(
//            event.includeServer(), new ModDamageTypeTagProvider(packOutput, lookupProvider, existingFileHelper));
//    }
    public static void init() {
        AnvilCraftFooding.REGISTRATE.addDataGenerator(ProviderType.RECIPE, RecipeHandler::init);
    }
}
