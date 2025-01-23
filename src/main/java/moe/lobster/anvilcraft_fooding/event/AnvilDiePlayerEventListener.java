package moe.lobster.anvilcraft_fooding.event;

import dev.dubhe.anvilcraft.api.event.anvil.AnvilHurtEntityEvent;
import moe.lobster.anvilcraft_fooding.data.foodsystem.IHasFoodsData;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.SubscribeEvent;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Random;

public class AnvilDiePlayerEventListener {
    @SuppressWarnings("DataFlowIssue")
    @SubscribeEvent
    public static void diedPlayer(@NotNull AnvilHurtEntityEvent event) {
        Entity hurtedEntity = event.getHurtedEntity();
        if (!(hurtedEntity instanceof LivingEntity livingEntity)) return;
        if(livingEntity.isAlive())  return;
        if (livingEntity.level().isClientSide()) return;
        if (!(livingEntity instanceof IHasFoodsData player)) return;
        CompoundTag playerFoodsData = player.getPlayerFoodsData().copy();
        if(playerFoodsData.isEmpty())   return;
        List<String> tasteList = playerFoodsData.getAllKeys().stream().toList();
        Random random = new Random();
        int tmp = random.nextInt(0, tasteList.size());
        CompoundTag outcomeData = new CompoundTag();
        for(String key : playerFoodsData.getAllKeys()){
            if(!key.equals(tasteList.get(tmp))){
                outcomeData.put(key, playerFoodsData.get(key));
            }
        }
        player.setPlayerFoodsData(outcomeData);
    }
}
