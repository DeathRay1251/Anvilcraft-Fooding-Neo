package moe.lobster.anvilcraft_fooding;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tterrag.registrate.Registrate;
import dev.dubhe.anvilcraft.config.AnvilCraftConfig;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import moe.lobster.anvilcraft_fooding.event.listener.AnvilDiePlayerEventListener;
import moe.lobster.anvilcraft_fooding.event.listener.AnvilEventListener;
import moe.lobster.anvilcraft_fooding.init.ModItems;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(AnvilCraftFooding.MOD_ID)
public class AnvilCraftFooding {
    public static final String MOD_ID = "anvilcraft_fooding";
    public static final String MOD_NAME = "AnvilCraft-Fooding";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);
    public static final Gson GSON =
        new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();
    public static AnvilCraftConfig config = AutoConfig.register(AnvilCraftConfig.class, JanksonConfigSerializer::new)
        .getConfig();

    public static final Registrate REGISTRATE = Registrate.create(MOD_ID);

    public AnvilCraftFooding(IEventBus modEventBus) {
        ModItems.register();
        registerEvents(modEventBus);

        LOGGER.info("Hi I'm MOE_LOBSTER");
        LOGGER.info("I↓ must↑ be→ the↓ reason↑ why→");
    }

    private static void registerEvents(@NotNull IEventBus eventBus) {
        NeoForge.EVENT_BUS.addListener(AnvilCraftFooding::registerCommand);
        NeoForge.EVENT_BUS.addListener(AnvilEventListener::onLand);
        NeoForge.EVENT_BUS.addListener(AnvilDiePlayerEventListener::diedPlayer);
    }

    public static @NotNull ResourceLocation of(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }

    public static void registerCommand(@NotNull RegisterCommandsEvent event) {

    }

}
