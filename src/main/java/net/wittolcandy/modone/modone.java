package net.wittolcandy.modone;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.wittolcandy.modone.block.ModBlocks;
import net.wittolcandy.modone.item.moditems;
import net.wittolcandy.modone.world.feature.ModConfiguredFeatures;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(modone.MOD_ID)
public class modone {
    public static final String MOD_ID = "modone";
    private static final Logger LOGGER = LogUtils.getLogger();

    public modone()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        moditems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModConfiguredFeatures.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == CreativeModeTabs.INGREDIENTS) {

            event.accept(ModBlocks.Nullvoid_Block);
            event.accept(moditems.NULLVOID_SHARD);
        }

        if (event.getTab() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(moditems.APPLE_JUICE);
            event.accept(ModBlocks.Apple_Block);
        }
    }

        // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
        @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
        public static class ClientModEvents {
            @SubscribeEvent
            public static void onClientSetup(FMLClientSetupEvent event) {

            }
        }
    }
