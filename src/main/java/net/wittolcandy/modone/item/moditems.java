package net.wittolcandy.modone.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.wittolcandy.modone.modone;

public class moditems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, modone.MOD_ID);

public static final RegistryObject<Item> ZIRCON = ITEMS.register("zircon",() -> new Item(new Item.Properties().))

    public static void register(IEventBus eventBus) {ITEMS.register(eventBus);}
}
