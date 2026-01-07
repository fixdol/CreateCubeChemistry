package com.fxd927.createcubechemistry;

import com.fxd927.createcubechemistry.entry.CCCItems;
import com.mojang.logging.LogUtils;
//import com.simibubi.create.foundation.data.CreateRegistrate;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(CreateCubeChemistry.MODID)
public class CreateCubeChemistry
{
    public static final String MODID = "createcubechemistry";
    private static final Logger LOGGER = LogUtils.getLogger();
    //public static final CreateRegistrate REGISTRATE = CreateRegistrate.create("createcubechemistry");

    public CreateCubeChemistry()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        registerEntries(modEventBus);
        modEventBus.register(this);
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void registerEntries(IEventBus modEventBus) {
        CCCItems.register();
        //REGISTRATE.registerEventListeners(modEventBus);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        LOGGER.info("HELLO FROM COMMON SETUP");
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        LOGGER.info("HELLO from server starting");
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
