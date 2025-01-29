package moe.lobster.anvilcraft_fooding.event;

import dev.dubhe.anvilcraft.api.event.anvil.AnvilFallOnLandEvent;
import moe.lobster.anvilcraft_fooding.data.event.AddSeasoning;
import net.minecraft.core.BlockPos;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import org.jetbrains.annotations.NotNull;

public class AnvilEventListener {
    @SubscribeEvent
    public static void onLand(@NotNull AnvilFallOnLandEvent event) {
        Level level = event.getLevel();
        BlockPos pos = event.getPos();
        MinecraftServer server = level.getServer();
        if (null == server) return;
        BlockPos belowPos = pos.below();
        BlockState state = level.getBlockState(belowPos);
        if (state.is(Blocks.SCAFFOLDING)) {
            belowPos = belowPos.below();
            state = level.getBlockState(belowPos);
            if (state.is(Blocks.IRON_TRAPDOOR)) {
                AddSeasoning.addSeasoning(level, pos);
            }
        }
    }
}
