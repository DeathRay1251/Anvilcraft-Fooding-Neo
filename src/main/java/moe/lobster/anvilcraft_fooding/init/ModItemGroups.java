package moe.lobster.anvilcraft_fooding.init;

import moe.lobster.anvilcraft_fooding.AnvilCraftFooding;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;


public class ModItemGroups {
    private static final DeferredRegister<CreativeModeTab> DF =
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AnvilCraftFooding.MOD_ID);
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ANVILCRAFT_FOODING =
        DF.register("anvilcraft_fooding", () -> CreativeModeTab.builder()
            .icon(ModItems.CHILI::asStack)
            .displayItems((ctx, entries) -> {})
            .title(AnvilCraftFooding.REGISTRATE.addLang(
                "itemGroup",AnvilCraftFooding.of("fooding"),"AnvilCraftFooding: Fooding"))
            .withTabsBefore(
                dev.dubhe.anvilcraft.init.ModItemGroups.ANVILCRAFT_BUILD_BLOCK.getId()
            )
            .build()
        );

    public static void register(IEventBus modEventBus) {
        DF.register(modEventBus);
    }
}
