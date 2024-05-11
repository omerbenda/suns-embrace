package com.sunsembrace.blockentity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public abstract class AbstractSolarFurnaceBlockEntity extends AbstractFurnaceBlockEntity {
  public AbstractSolarFurnaceBlockEntity(
      BlockEntityType<?> pType,
      BlockPos pPos,
      BlockState pBlockState,
      RecipeType<? extends AbstractCookingRecipe> pRecipeType) {
    super(pType, pPos, pBlockState, pRecipeType);
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
}
