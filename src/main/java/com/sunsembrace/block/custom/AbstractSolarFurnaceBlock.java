package com.sunsembrace.block.custom;

import com.sunsembrace.blockentity.ModBlockEntities;
import com.sunsembrace.blockentity.custom.AbstractSolarFurnaceBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public abstract class AbstractSolarFurnaceBlock extends AbstractFurnaceBlock {
  public AbstractSolarFurnaceBlock(Properties pProperties) {
    super(pProperties);
  }

  @Override
  public <T extends BlockEntity> BlockEntityTicker<T> getTicker(
      Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
    return pLevel.isClientSide
        ? null
        : createTickerHelper(
            pBlockEntityType, ModBlockEntities.SOLAR_FURNACE_BLOCK_ENTITY.get(), this::tick);
  }

  @Override
  public int getLightEmission(BlockState state, BlockGetter level, BlockPos pos) {
    return 0;
  }

  public void tick(
      Level pLevel, BlockPos pPos, BlockState pState, AbstractFurnaceBlockEntity pBlockEntity) {
    AbstractFurnaceBlockEntity.serverTick(pLevel, pPos, pState, pBlockEntity);

    if (pBlockEntity instanceof AbstractSolarFurnaceBlockEntity abstractSolarFurnaceBlockEntity) {
      abstractSolarFurnaceBlockEntity.tick();
    }
  }
}
