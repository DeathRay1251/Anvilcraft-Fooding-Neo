package moe.lobster.anvilcraft_fooding.data.loader;

import com.tterrag.registrate.providers.RegistrateRecipeProvider;

public class RecipeHandler {
    public static void init(RegistrateRecipeProvider provider){
        MeshRecipeLoader.init(provider);
    }
}
