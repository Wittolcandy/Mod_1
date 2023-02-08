package net.wittolcandy.modone.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.wittolcandy.modone.modone;

public class moditems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, modone.MOD_ID);

    public static final RegistryObject<Item> APPLE_JUICE = ITEMS.register("apple_juice",
            () -> new Item(new Item.Properties().food(Foods.Apple_Juice)));

    public static class Foods {
        public static final FoodProperties Apple_Juice = new FoodProperties.Builder()
                .nutrition(6)
                .saturationMod(4)
                .alwaysEat()
                .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 3), 1.0f)
                .build();
    }

    public static final RegistryObject<Item> NULLVOID_SHARD = ITEMS.register("nullvoid_shard",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}





