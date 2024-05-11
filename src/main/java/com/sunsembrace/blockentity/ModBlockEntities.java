package com.sunsembrace.blockentity;

import com.sunsembrace.SunsEmbraceMod;
import com.sunsembrace.block.ModBlocks;
import com.sunsembrace.blockentity.custom.SolarBlastFurnaceBlockEntity;
import com.sunsembrace.blockentity.custom.SolarFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
  public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
      DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, SunsEmbraceMod.MOD_ID);

  public static final RegistryObject<BlockEntityType<SolarFurnaceBlockEntity>>
      SOLAR_FURNACE_BLOCK_ENTITY =
          BLOCK_ENTITIES.register(
              "solar_furnace_block_entity",
              () ->
                  BlockEntityType.Builder.of(
                          SolarFurnaceBlockEntity::new, ModBlocks.SOLAR_FURNACE.get())
                      .build(null));

  public static final RegistryObject<BlockEntityType<SolarBlastFurnaceBlockEntity>>
      SOLAR_BLAST_FURNACE_BLOCK_ENTITY =
          BLOCK_ENTITIES.register(
              "solar_blast_furnace_block_entity",
              () ->
                  BlockEntityType.Builder.of(
                          SolarBlastFurnaceBlockEntity::new, ModBlocks.SOLAR_BLAST_FURNACE.get())
                      .build(null));

  public static void register(IEventBus eventBus) {
    BLOCK_ENTITIES.register(eventBus);
  }
}
