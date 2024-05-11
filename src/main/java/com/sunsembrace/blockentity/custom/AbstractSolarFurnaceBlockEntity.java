package com.sunsembrace.blockentity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public abstract class AbstractSolarFurnaceBlockEntity extends AbstractFurnaceBlockEntity {
  public static final int MIN_SKY_LIGHT = 8;

  public AbstractSolarFurnaceBlockEntity(
      BlockEntityType<?> pType,
      BlockPos pPos,
      BlockState pBlockState,
      RecipeType<? extends AbstractCookingRecipe> pRecipeType) {
    super(pType, pPos, pBlockState, pRecipeType);
  }

  public void tick() {
    if (this.level != null) {
      BlockPos pos = this.getBlockPos();
      BlockState blockState = this.level.getBlockState(pos);

      if (this.level.getBrightness(LightLayer.SKY, pos.above()) >= MIN_SKY_LIGHT) {
        this.dataAccess.set(0, 100);
        this.dataAccess.set(1, 1000);

        if (!blockState.getValue(BlockStateProperties.LIT)) {
          level.setBlock(pos, blockState.setValue(BlockStateProperties.LIT, Boolean.TRUE), 2);
        }
      } else {
        if (blockState.getValue(BlockStateProperties.LIT)) {
          level.setBlock(pos, blockState.setValue(BlockStateProperties.LIT, Boolean.FALSE), 2);
        }
      }
    }
  }
}
