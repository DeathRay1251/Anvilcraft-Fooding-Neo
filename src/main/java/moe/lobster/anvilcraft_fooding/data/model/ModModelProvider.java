package moe.lobster.anvilcraft_fooding.data.model;

import com.tterrag.registrate.providers.RegistrateBlockstateProvider;
import moe.lobster.anvilcraft_fooding.AnvilCraftFooding;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.VariantBlockStateBuilder;

import java.util.function.Function;

public class ModModelProvider {
    public static void leaveModel(RegistrateBlockstateProvider provider, VariantBlockStateBuilder variantBuilder, Function<VariantBlockStateBuilder.PartialBlockstate, VariantBlockStateBuilder.PartialBlockstate> stateFactory, String name, String stage) {
        String path = name + "_stage" + stage;
        ResourceLocation location = AnvilCraftFooding.of("block/" + path);
        BlockModelBuilder stageModel = provider.models().leaves(path, location).renderType("cutout");
        VariantBlockStateBuilder.PartialBlockstate state = stateFactory.apply(variantBuilder.partialState());
        variantBuilder.addModels(state, new ConfiguredModel(stageModel));
    }
}
