package com.clussmanproductions.modroadworksreborn.items;

import com.clussmanproductions.modroadworksreborn.ModBlocks;
import com.clussmanproductions.modroadworksreborn.ModRoadworksReborn;
import com.clussmanproductions.modroadworksreborn.blocks.BlockSideStripe;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemSideStripePainter extends ItemPainterBase {
	public ItemSideStripePainter()
	{
		super("sidestripepainter", ModBlocks.sideStripe);
	}
}
