package net.wittolcandy.modone.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.wittolcandy.modone.item.moditems;
import net.wittolcandy.modone.modone;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, modone.MOD_ID);

    public static final RegistryObject<Block> Apple_Block = registerBlock("apple_block",
            ()-> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> Nullvoid_Block = registerBlock("nullvoid_block",
            ()-> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL)
                    .strength(10f).requiresCorrectToolForDrops()));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name,  RegistryObject<T> block) {
        return moditems.ITEMS.register(name, () -> new BlockItem(block.get(),
       new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);

    }
}
