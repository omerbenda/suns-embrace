package com.sunsembrace;

import com.sunsembrace.block.ModBlocks;
import com.sunsembrace.blockentity.ModBlockEntities;
import com.sunsembrace.item.ModCreativeModTabs;
import com.sunsembrace.item.ModItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(SunsEmbraceMod.MOD_ID)
public class SunsEmbraceMod {
  public static final String MOD_ID = "sunsembrace";

  public SunsEmbraceMod() {
    IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

    ModItems.register(modEventBus);
    ModBlocks.register(modEventBus);
    ModBlockEntities.register(modEventBus);
    ModCreativeModTabs.register(modEventBus);

    modEventBus.addListener(this::commonSetup);
    MinecraftForge.EVENT_BUS.register(this);
  }

  private void commonSetup(final FMLCommonSetupEvent event) {}
}
