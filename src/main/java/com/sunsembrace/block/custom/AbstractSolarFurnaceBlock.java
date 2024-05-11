package com.sunsembrace.block.custom;

import com.sunsembrace.blockentity.custom.AbstractSolarFurnaceBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractSolarFurnaceBlock extends AbstractFurnaceBlock {
  public AbstractSolarFurnaceBlock(Properties pProperties) {
    super(pProperties);
  }

  public abstract <T extends BlockEntity> BlockEntityType<T> getBlockEntityType();

  @Override
  public <T extends BlockEntity> BlockEntityTicker<T> getTicker(
      Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
    return pLevel.isClientSide
        ? null
        : createTickerHelper(pBlockEntityType, this.getBlockEntityType(), this::tick);
  }

  @Override
  public int getLightEmission(BlockState state, BlockGetter level, BlockPos pos) {
    return 0;
  }

  @Nullable
  @Override
  public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
    return getBlockEntityType().create(pPos, pState);
  }

  public void tick(Level pLevel, BlockPos pPos, BlockState pState, BlockEntity pBlockEntity) {
    if (pBlockEntity instanceof AbstractSolarFurnaceBlockEntity abstractSolarFurnaceBlockEntity) {
      AbstractFurnaceBlockEntity.serverTick(pLevel, pPos, pState, abstractSolarFurnaceBlockEntity);
      abstractSolarFurnaceBlockEntity.tick();
    }
  }
}
