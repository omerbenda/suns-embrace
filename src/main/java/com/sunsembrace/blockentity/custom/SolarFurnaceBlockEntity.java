package com.sunsembrace.blockentity.custom;

import com.sunsembrace.blockentity.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.FurnaceMenu;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public class SolarFurnaceBlockEntity extends AbstractFurnaceBlockEntity {
  public SolarFurnaceBlockEntity(BlockPos pPos, BlockState pBlockState) {
    super(
        ModBlockEntities.SOLAR_FURNACE_BLOCK_ENTITY.get(), pPos, pBlockState, RecipeType.SMELTING);
  }

  public void tick() {
    this.dataAccess.set(0, 100);
    this.dataAccess.set(1, 1000);
    BlockPos pos = this.getBlockPos();

    if (this.level != null) {
      BlockState blockState = this.level.getBlockState(pos);

      if (!blockState.getValue(BlockStateProperties.LIT)) {
        level.setBlock(pos, blockState.setValue(BlockStateProperties.LIT, Boolean.TRUE), 2);
      }
    }
  }

  @Override
  protected Component getDefaultName() {
    return Component.translatable("container.sunsembrace.solar_furnace");
  }

  @Override
  protected AbstractContainerMenu createMenu(int pId, Inventory pInv) {
    return new FurnaceMenu(pId, pInv, this, this.dataAccess);
  }
}
