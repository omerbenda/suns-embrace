package com.sunsembrace.item;

import com.sunsembrace.SunsEmbraceMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
  public static final DeferredRegister<Item> ITEMS =
      DeferredRegister.create(ForgeRegistries.ITEMS, SunsEmbraceMod.MOD_ID);

  public static final RegistryObject<Item> SOLAR_PANEL =
      ITEMS.register("solar_panel", () -> new Item(new Item.Properties()));

  public static void register(IEventBus eventBus) {
    ITEMS.register(eventBus);
  }
}
