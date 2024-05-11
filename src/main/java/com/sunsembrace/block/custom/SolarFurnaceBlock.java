package com.sunsembrace.block.custom;

import com.mojang.serialization.MapCodec;
import com.sunsembrace.blockentity.ModBlockEntities;
import com.sunsembrace.blockentity.custom.SolarFurnaceBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class SolarFurnaceBlock extends AbstractSolarFurnaceBlock {
  public static final MapCodec<SolarFurnaceBlock> CODEC = simpleCodec(SolarFurnaceBlock::new);

  public SolarFurnaceBlock(Properties properties) {
    super(properties);
  }

  @Override
  protected MapCodec<? extends SolarFurnaceBlock> codec() {
    return CODEC;
  }

  @Override
  protected void openContainer(Level pLevel, BlockPos pPos, Player pPlayer) {
    BlockEntity blockEntity = pLevel.getBlockEntity(pPos);

    if (blockEntity instanceof SolarFurnaceBlockEntity solarFurnaceBlockEntity) {
      pPlayer.openMenu(solarFurnaceBlockEntity);
    }
  }

  @Nullable
  @Override
  public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
    return ModBlockEntities.SOLAR_FURNACE_BLOCK_ENTITY.get().create(pPos, pState);
  }
}
