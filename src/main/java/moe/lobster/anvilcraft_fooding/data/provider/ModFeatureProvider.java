package moe.lobster.anvilcraft_fooding.data.provider;

import moe.lobster.anvilcraft_fooding.AnvilCraftFooding;
import moe.lobster.anvilcraft_fooding.data.feature.ModFeatureUtils;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModFeatureProvider extends DatapackBuiltinEntriesProvider {

    private static final RegistrySetBuilder BUILDER =
        new RegistrySetBuilder().add(Registries.CONFIGURED_FEATURE, ModFeatureUtils::bootstrap);

    public ModFeatureProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(AnvilCraftFooding.MOD_ID));
    }
}
