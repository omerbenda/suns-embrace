package com.sunsembrace.blockentity.custom;

import com.sunsembrace.blockentity.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.BlastFurnaceMenu;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.state.BlockState;

public class SolarSmokerBlockEntity extends AbstractSolarFurnaceBlockEntity {
  public SolarSmokerBlockEntity(BlockPos pPos, BlockState pBlockState) {
    super(ModBlockEntities.SOLAR_SMOKER_BLOCK_ENTITY.get(), pPos, pBlockState, RecipeType.SMOKING);
  }

  @Override
  protected Component getDefaultName() {
    return Component.translatable("container.sunsembrace.solar_smoker");
  }

  @Override
  protected AbstractContainerMenu createMenu(int pId, Inventory pInv) {
    return new BlastFurnaceMenu(pId, pInv, this, this.dataAccess);
  }
}
