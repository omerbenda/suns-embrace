package com.sunsembrace.block.custom;

import com.mojang.serialization.MapCodec;
import com.sunsembrace.blockentity.ModBlockEntities;
import com.sunsembrace.blockentity.custom.SolarBlastFurnaceBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class SolarBlastFurnaceBlock extends AbstractSolarFurnaceBlock {
  public static final MapCodec<SolarBlastFurnaceBlock> CODEC =
      simpleCodec(SolarBlastFurnaceBlock::new);

  public SolarBlastFurnaceBlock(Properties pProperties) {
    super(pProperties);
  }

  @Override
  public <T extends BlockEntity> BlockEntityType<T> getBlockEntityType() {
    return (BlockEntityType<T>) ModBlockEntities.SOLAR_BLAST_FURNACE_BLOCK_ENTITY.get();
  }

  @Override
  protected void openContainer(Level pLevel, BlockPos pPos, Player pPlayer) {
    BlockEntity blockEntity = pLevel.getBlockEntity(pPos);

    if (blockEntity instanceof SolarBlastFurnaceBlockEntity solarBlastFurnaceBlockEntity) {
      pPlayer.openMenu(solarBlastFurnaceBlockEntity);
    }
  }

  @Nullable
  @Override
  public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
    return ModBlockEntities.SOLAR_BLAST_FURNACE_BLOCK_ENTITY.get().create(pPos, pState);
  }

  public MapCodec<SolarBlastFurnaceBlock> codec() {
    return CODEC;
  }
}
