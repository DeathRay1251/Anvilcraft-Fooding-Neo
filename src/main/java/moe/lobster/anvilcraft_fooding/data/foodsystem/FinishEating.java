package moe.lobster.anvilcraft_fooding.data.foodsystem;

import moe.lobster.anvilcraft_fooding.utils.IHasFoodsDataInjector;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;

import java.util.Random;
import java.util.Set;

import static moe.lobster.anvilcraft_fooding.data.foodsystem.Rewards.emotionLimit;
import static moe.lobster.anvilcraft_fooding.data.foodsystem.Rewards.giveRewards;
import static moe.lobster.anvilcraft_fooding.data.foodsystem.Rewards.likeList;
import static moe.lobster.anvilcraft_fooding.data.foodsystem.Rewards.unlikeList;

public class FinishEating {
    //MOD_ID -> {tastes -> {(times,1),(Buff,0),(Like,0)} }
    @SuppressWarnings("DataFlowIssue")
    public static void onFinishEating(IHasFoodsDataInjector player, CompoundTag compoundTag) {
        if (compoundTag == null) return;
        CompoundTag playerFoodsData = player.getPlayerFoodsData().copy();
        CompoundTag newPlayerFoodsData = new CompoundTag();
        Set<String> keysFood = compoundTag.getAllKeys();
        for (String key : keysFood) {
            if (playerFoodsData.contains(key)) {
                CompoundTag infoTag = playerFoodsData.getCompound(key).copy();
                int like = infoTag.getInt("Like");
                int times = infoTag.getInt("Times");
                int buff = infoTag.getInt("Buff");
                int depth = compoundTag.getInt(key);
                times += 1;
                if (times == emotionLimit) {
                    Random random = new Random();
                    like = random.nextInt(2) * 2 - 1;
                    if (like == 1) {
                        buff = random.nextInt(0, likeList.size());
                    } else {
                        buff = random.nextInt(0, unlikeList.size());
                    }
                }
                giveRewards((ServerPlayer) player, like, times, buff, depth);
                CompoundTag newInfoTag = new CompoundTag();
                newInfoTag.putInt("Like", like);
                newInfoTag.putInt("Times", times);
                newInfoTag.putInt("Buff", buff);
                newPlayerFoodsData.put(key, newInfoTag);
            } else {
                CompoundTag infoTag = new CompoundTag();
                infoTag.putInt("Like", 0);
                infoTag.putInt("Times", 1);
                infoTag.putInt("Buff", 0);
                newPlayerFoodsData.put(key, infoTag);
            }
        }
        Set<String> keysPlayer = playerFoodsData.getAllKeys();
        for (String key : keysPlayer) {
            if (!newPlayerFoodsData.contains(key)) {
                newPlayerFoodsData.put(key, playerFoodsData.get(key));
            }
        }
        player.setPlayerFoodsData(newPlayerFoodsData);
    }


}
