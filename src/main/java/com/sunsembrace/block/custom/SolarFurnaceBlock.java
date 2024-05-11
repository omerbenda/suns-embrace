package com.sunsembrace.block.custom;

import com.sunsembrace.blockentity.ModBlockEntities;
import com.sunsembrace.blockentity.custom.SolarFurnaceBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class SolarFurnaceBlock extends AbstractSolarFurnaceBlock {
  public SolarFurnaceBlock(Properties properties) {
    super(properties);
  }

  @Override
  public <T extends BlockEntity> BlockEntityType<T> getBlockEntityType() {
    return (BlockEntityType<T>) ModBlockEntities.SOLAR_FURNACE_BLOCK_ENTITY.get();
  }

  @Override
  protected void openContainer(Level pLevel, BlockPos pPos, Player pPlayer) {
    BlockEntity blockEntity = pLevel.getBlockEntity(pPos);

    if (blockEntity instanceof SolarFurnaceBlockEntity solarFurnaceBlockEntity) {
      pPlayer.openMenu(solarFurnaceBlockEntity);
    }
  }
}
