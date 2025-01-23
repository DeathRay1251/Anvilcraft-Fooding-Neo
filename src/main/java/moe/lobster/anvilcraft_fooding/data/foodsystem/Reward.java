package moe.lobster.anvilcraft_fooding.data.foodsystem;

import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.Item;

import java.util.ArrayList;
import java.util.List;

public class Reward {
    private List<Item> items;
    private List<Holder<MobEffect>> effects;

    public Reward(List<Item> items, List<Holder<MobEffect>> effects) {
        this.items = items;
        this.effects = effects;
    }
    public Reward(){
        items = new ArrayList<>();
        effects = new ArrayList<>();
    }
    public List<Item> getItemList(){
        return this.items;
    }
    public List<Holder<MobEffect>> getEffectList(){
        return this.effects;
    }
    public void setItemList(List<Item> items){
        this.items.clear();
        this.items.addAll(items);
    }
    public void setEffectList(List<Holder<MobEffect>> effects){
        this.effects.clear();
        this.effects.addAll(effects);
    }
}
