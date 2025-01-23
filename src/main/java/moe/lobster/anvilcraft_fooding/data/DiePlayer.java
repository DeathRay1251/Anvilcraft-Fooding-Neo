package moe.lobster.anvilcraft_fooding.data;

import moe.lobster.anvilcraft_fooding.utils.IHasFoodsDataInjector;
import net.minecraft.nbt.CompoundTag;

import java.util.List;
import java.util.Random;

public class DiePlayer {
    @SuppressWarnings("DataFlowIssue")
    public static void diePlayer(IHasFoodsDataInjector player) {
        CompoundTag playerFoodsData = player.getPlayerFoodsData().copy();
        if (playerFoodsData.isEmpty()) return;
        List<String> tasteList = playerFoodsData.getAllKeys().stream().toList();
        Random random = new Random();
        int tmp = random.nextInt(0, tasteList.size());
        CompoundTag outcomeData = new CompoundTag();
        for (String key : playerFoodsData.getAllKeys()) {
            if (!key.equals(tasteList.get(tmp))) {
                outcomeData.put(key, playerFoodsData.get(key));
            }
        }
        player.setPlayerFoodsData(outcomeData);
    }
}
