package com.clussmanproductions.modroadworksreborn.items;

import com.clussmanproductions.modroadworksreborn.ModRoadworksReborn;
import com.clussmanproductions.modroadworksreborn.blocks.BlockStripeBase;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemPainterBase extends Item {
	private BlockStripeBase _blockToSet;
	public ItemPainterBase(String name, BlockStripeBase blockToSet)
	{
		setRegistryName(name);
		setUnlocalizedName(ModRoadworksReborn.MODID + "." + name);
		setCreativeTab(ModRoadworksReborn.ROADWORKSREBORN);
		setMaxStackSize(1);
		_blockToSet = blockToSet;
	}
	
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand,
			EnumFacing facing, float hitX, float hitY, float hitZ) {
		
		if (!worldIn.isRemote)
		{
			BlockPos offsetPos = pos.offset(facing);
			IBlockState blockState = worldIn.getBlockState(offsetPos);
			Block block = blockState.getBlock();
			
			if (block.isReplaceable(worldIn, offsetPos))
			{
				worldIn.setBlockState(offsetPos, _blockToSet.getDefaultState().withProperty(_blockToSet.FACING, player.getHorizontalFacing()));
			}
		}
		
		return EnumActionResult.SUCCESS;
	}
}
