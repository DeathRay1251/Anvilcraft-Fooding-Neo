package moe.lobster.anvilcraft_fooding.init;

import com.tterrag.registrate.util.entry.ItemEntry;
import moe.lobster.anvilcraft_fooding.data.ModFoods;
import moe.lobster.anvilcraft_fooding.data.foodsystem.Tastes;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.neoforged.neoforge.common.Tags;

import static moe.lobster.anvilcraft_fooding.AnvilCraftFooding.MOD_ID;
import static moe.lobster.anvilcraft_fooding.AnvilCraftFooding.REGISTRATE;

public class ModItems {


    public static final ItemEntry<? extends Item > CHILI = REGISTRATE
            .item( "chili",p -> new Item( p.food( ModFoods.CHILI ) ))
            .properties(properties -> properties.component( DataComponents.CUSTOM_DATA,foodData( new FoodTag()
                    .add( Tastes.HOT.get(),1 )))
            )
            .tag( Tags.Items.FOODS )
            .register();


    public static CustomData foodData(FoodTag foodTag){
        CompoundTag compoundTag= new CompoundTag();
        compoundTag.put( MOD_ID,foodTag );
        return CustomData.of( compoundTag );
    }

    public static class FoodTag extends CompoundTag{
        public FoodTag add( String key, int value) {
            this.putInt(key, value);
            return this;
        }
    }
    public static void test( ItemStack itemStack ){

    }
    public static void register() {

    }

}
