package com.sunsembrace.block.custom;

import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;

public class SolarBlock extends Block {
  public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
  public static final BooleanProperty LIT = BlockStateProperties.LIT;

  public SolarBlock(Properties p_49795_) {
    super(p_49795_);

    this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(LIT, Boolean.FALSE));
  }

  @Override
  public BlockState getStateForPlacement(BlockPlaceContext pContext) {
    return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
  }

  @Override
  protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
    pBuilder.add(FACING, LIT);
  }
}
