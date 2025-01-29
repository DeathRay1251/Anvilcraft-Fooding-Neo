package moe.lobster.anvilcraft_fooding.init;

import moe.lobster.anvilcraft_fooding.data.foodsystem.Reward;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import java.util.ArrayList;
import java.util.List;

public class Rewards {
    public static final int emotionLimit = 4;
    public static List<Reward> likeList = new ArrayList<>();
    public static List<Reward> unlikeList = new ArrayList<>();

    public static void register() {
        Reward like1 = RewardBuilder.create()
            .addEffct(MobEffects.MOVEMENT_SPEED)
            .addEffct(MobEffects.DIG_SPEED)
            .build(1);
        Reward like2 = RewardBuilder.create()
            .addEffct(MobEffects.HEAL)
            .addEffct(MobEffects.HEALTH_BOOST)
            .build(1);
        Reward like3 = RewardBuilder.create()
            .addEffct(MobEffects.DAMAGE_RESISTANCE)
            .build(1);
        Reward like4 = RewardBuilder.create()
            .addEffct(MobEffects.DAMAGE_BOOST)
            .build(1);
        Reward like5 = RewardBuilder.create()
            .addEffct(MobEffects.FIRE_RESISTANCE)
            .addEffct(MobEffects.WATER_BREATHING)
            .build(1);
        Reward like6 = RewardBuilder.create()
            .addEffct(MobEffects.NIGHT_VISION)
            .build(1);
        Reward like7 = RewardBuilder.create()
            .addEffct(MobEffects.REGENERATION)
            .addEffct(MobEffects.HEAL)
            .build(1);
        Reward like8 = RewardBuilder.create()
            .addEffct(MobEffects.DAMAGE_RESISTANCE)
            .addEffct(MobEffects.DAMAGE_BOOST)
            .build(1);
        Reward like9 = RewardBuilder.create()
            .addEffct(MobEffects.DOLPHINS_GRACE)
            .addEffct(MobEffects.WATER_BREATHING)
            .build(1);
        Reward like10 = RewardBuilder.create()
            .addEffct(MobEffects.CONDUIT_POWER)
            .build(1);
        Reward like11 = RewardBuilder.create()
            .addEffct(MobEffects.ABSORPTION)
            .addEffct(MobEffects.DAMAGE_RESISTANCE)
            .addEffct(MobEffects.FIRE_RESISTANCE)
            .build(1);
        Reward like12 = RewardBuilder.create()
            .addEffct(MobEffects.INVISIBILITY)
            .addEffct(MobEffects.NIGHT_VISION)
            .build(1);
        Reward like13 = RewardBuilder.create()
            .addEffct(MobEffects.JUMP)
            .addEffct(MobEffects.MOVEMENT_SPEED)
            .build(1);
        Reward like14 = RewardBuilder.create()
            .addEffct(MobEffects.LUCK)
            .addItem(Items.GOLD_NUGGET)
            .build(1);
        Reward like15 = RewardBuilder.create()
            .addEffct(MobEffects.CONDUIT_POWER)
            .addItem(Items.PRISMARINE_SHARD)
            .addItem(Items.PRISMARINE_CRYSTALS)
            .build(1);
        Reward like16 = RewardBuilder.create()
            .addEffct(MobEffects.HERO_OF_THE_VILLAGE)
            .addItem(Items.EMERALD)
            .build(1);
        Reward unlike1 = RewardBuilder.create()
            .addEffct(MobEffects.HARM)
            .addEffct(MobEffects.POISON)
            .build(0);
        Reward unlike2 = RewardBuilder.create()
            .addEffct(MobEffects.HUNGER)
            .addEffct(MobEffects.CONFUSION)
            .build(0);
        Reward unlike3 = RewardBuilder.create()
            .addEffct(MobEffects.BLINDNESS)
            .build(0);
    }


    public static void registerLike(Reward reward) {
        likeList.add(reward);
    }

    public static void registerUnlike(Reward reward) {
        unlikeList.add(reward);
    }

    public static void giveRewards(ServerPlayer player, int like, int times, int buff, int depth) {
        if (like == 0) return;
        List<Item> items;
        List<Holder<MobEffect>> effects;
        if (like == 1) {
            items = likeList.get(buff).getItemList();
            effects = likeList.get(buff).getEffectList();

        } else {
            items = unlikeList.get(buff).getItemList();
            effects = unlikeList.get(buff).getEffectList();
        }
        if (!items.isEmpty()) {
            for (Item item : items) {
                ItemStack itemStack = new ItemStack(item);
                itemStack.setCount((int) Math.sqrt(Math.sqrt(depth)));
                double chance = Math.random();
                if (chance <= ((double) times / (times + 46))) {
                    ItemEntity itemEntity = new ItemEntity(player.level(), player.xOld, player.yOld, player.zOld, itemStack);
                    player.level().addFreshEntity(itemEntity);
                }
            }
        }
        if (!effects.isEmpty()) {
            for (Holder<MobEffect> effect : effects) {
                int duration = (int) Math.ceil(Math.sqrt(times)) * 20;
                int amplifier = (int) Math.ceil(Math.sqrt(Math.sqrt(depth)));
                player.addEffect(new MobEffectInstance(effect, duration, amplifier));
            }
        }

    }

    public static class RewardBuilder {
        Reward tag = new Reward();
        List<Holder<MobEffect>> effects;
        List<Item> items;

        private RewardBuilder() {
//            this.tag = new CompoundTag();
            this.effects = new ArrayList<>();
            this.items = new ArrayList<>();
        }

        public static RewardBuilder create() {
            return new RewardBuilder();
        }

        public RewardBuilder addEffct(Holder<MobEffect> effect) {
            this.effects.add(effect);
            return this;
        }

        public RewardBuilder addItem(Item item) {
            this.items.add(item);
            return this;
        }

        public Reward build(int isLike) {
            this.tag.setItemList(items);
            this.tag.setEffectList(effects);
            if (isLike == 1) {
                registerLike(this.tag);
            } else {
                registerUnlike(this.tag);
            }
            return this.tag;
        }
    }
}
