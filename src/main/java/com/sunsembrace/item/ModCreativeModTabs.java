package com.sunsembrace.item;

import com.sunsembrace.SunsEmbraceMod;
import com.sunsembrace.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
  public static final DeferredRegister<CreativeModeTab> CREATIVE_MOD_TABS =
      DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SunsEmbraceMod.MOD_ID);

  public static final RegistryObject<CreativeModeTab> SUNS_EMBRACE_TAB =
      CREATIVE_MOD_TABS.register(
          "suns_embrace_tab",
          () ->
              CreativeModeTab.builder()
                  .icon(() -> new ItemStack(ModBlocks.SOLAR_FURNACE.get()))
                  .title(Component.translatable("creativetab.sunsembrace.suns_embrace_tab"))
                  .displayItems(
                      (parameters, output) -> {
                        output.accept(ModBlocks.SOLAR_FURNACE.get());
                        output.accept(ModBlocks.SOLAR_BLAST_FURNACE.get());
                      })
                  .build());

  public static void register(IEventBus eventBus) {
    CREATIVE_MOD_TABS.register(eventBus);
  }
}
