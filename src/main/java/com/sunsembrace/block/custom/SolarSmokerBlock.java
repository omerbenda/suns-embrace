package com.sunsembrace.block.custom;

import com.sunsembrace.blockentity.ModBlockEntities;
import com.sunsembrace.blockentity.custom.SolarSmokerBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class SolarSmokerBlock extends AbstractSolarFurnaceBlock {
  public SolarSmokerBlock(Properties pProperties) {
    super(pProperties);
  }

  @Override
  public <T extends BlockEntity> BlockEntityType<T> getBlockEntityType() {
    return (BlockEntityType<T>) ModBlockEntities.SOLAR_SMOKER_BLOCK_ENTITY.get();
  }

  @Override
  protected void openContainer(Level pLevel, BlockPos pPos, Player pPlayer) {
    BlockEntity blockEntity = pLevel.getBlockEntity(pPos);

    if (blockEntity instanceof SolarSmokerBlockEntity solarSmokerBlockEntity) {
      pPlayer.openMenu(solarSmokerBlockEntity);
    }
  }
}
