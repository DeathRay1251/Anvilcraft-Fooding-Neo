package moe.lobster.anvilcraft_fooding.event;

import dev.dubhe.anvilcraft.api.event.anvil.AnvilHurtEntityEvent;
import moe.lobster.anvilcraft_fooding.data.DiePlayer;
import moe.lobster.anvilcraft_fooding.utils.IHasFoodsDataInjector;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.SubscribeEvent;
import org.jetbrains.annotations.NotNull;

public class AnvilDiePlayerEventListener {
    @SuppressWarnings("DataFlowIssue")
    @SubscribeEvent
    public static void diedPlayer(@NotNull AnvilHurtEntityEvent event) {
        Entity hurtedEntity = event.getHurtedEntity();
        if (!(hurtedEntity instanceof LivingEntity livingEntity)) return;
        if (livingEntity.isAlive()) return;
        if (livingEntity.level().isClientSide()) return;
        if (!(livingEntity instanceof IHasFoodsDataInjector player)) return;
        DiePlayer.diePlayer(player);
    }
}
