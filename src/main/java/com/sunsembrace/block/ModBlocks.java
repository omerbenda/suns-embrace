package com.sunsembrace.block;

import com.sunsembrace.SunsEmbraceMod;
import com.sunsembrace.block.custom.SolarBlastFurnaceBlock;
import com.sunsembrace.block.custom.SolarFurnaceBlock;
import com.sunsembrace.block.custom.SolarSmokerBlock;
import com.sunsembrace.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
  public static final DeferredRegister<Block> BLOCKS =
      DeferredRegister.create(ForgeRegistries.BLOCKS, SunsEmbraceMod.MOD_ID);

  public static final RegistryObject<Block> SOLAR_FURNACE =
      registerBlock("solar_furnace", () -> new SolarFurnaceBlock(BlockBehaviour.Properties.copy(Blocks.FURNACE)));

  public static final RegistryObject<Block> SOLAR_BLAST_FURNACE =
      registerBlock(
          "solar_blast_furnace",
          () -> new SolarBlastFurnaceBlock(BlockBehaviour.Properties.copy(Blocks.BLAST_FURNACE)));

  public static final RegistryObject<Block> SOLAR_SMOKER =
      registerBlock("solar_smoker", () -> new SolarSmokerBlock(BlockBehaviour.Properties.copy(Blocks.SMOKER)));

  private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
    RegistryObject<T> registeredBlock = BLOCKS.register(name, block);
    registerBlockItem(name, registeredBlock);

    return registeredBlock;
  }

  private static <T extends Block> RegistryObject<Item> registerBlockItem(
      String name, RegistryObject<T> block) {
    return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
  }

  public static void register(IEventBus eventBus) {
    BLOCKS.register(eventBus);
  }
}
