package com.clussmanproductions.modroadworksreborn.items;

import com.clussmanproductions.modroadworksreborn.ModBlocks;
import com.clussmanproductions.modroadworksreborn.ModRoadworksReborn;
import com.clussmanproductions.modroadworksreborn.blocks.BlockStripeBase;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemExtraStripePainter extends Item {
	public ItemExtraStripePainter()
	{
		setRegistryName("extrastripepainter");
		setUnlocalizedName(ModRoadworksReborn.MODID + ".extrastripepainter");
		setCreativeTab(ModRoadworksReborn.ROADWORKSREBORN);
		setMaxStackSize(1);
	}
	
	@SideOnly(Side.CLIENT)
	public void initModel()
	{
		ModelResourceLocation step0 = new ModelResourceLocation(getRegistryName() + "_step0", "inventory");
		ModelResourceLocation step1 = new ModelResourceLocation(getRegistryName() + "_step1", "inventory");
		ModelResourceLocation step2 = new ModelResourceLocation(getRegistryName() + "_step2", "inventory");
		ModelResourceLocation step3 = new ModelResourceLocation(getRegistryName() + "_step3", "inventory");
		ModelResourceLocation step4 = new ModelResourceLocation(getRegistryName() + "_step4", "inventory");
		ModelResourceLocation step5 = new ModelResourceLocation(getRegistryName() + "_step5", "inventory");
		ModelResourceLocation step6 = new ModelResourceLocation(getRegistryName() + "_step6", "inventory");
		ModelResourceLocation step7 = new ModelResourceLocation(getRegistryName() + "_step7", "inventory");
		ModelResourceLocation step8 = new ModelResourceLocation(getRegistryName() + "_step8", "inventory");
		ModelResourceLocation step9 = new ModelResourceLocation(getRegistryName() + "_step9", "inventory");
		ModelResourceLocation step10 = new ModelResourceLocation(getRegistryName() + "_step10", "inventory");
		
		ModelBakery.registerItemVariants(this, step0, step1, step2, step3, step4, step5, step6, step7, step8, step9, step10);
		
		ModelLoader.setCustomMeshDefinition(this, new ItemMeshDefinition() {
			
			@Override
			public ModelResourceLocation getModelLocation(ItemStack stack) {
				switch(getStep(stack))
				{
					case 0:
						return step0;
					case 1:
						return step1;
					case 2:
						return step2;
					case 3:
						return step3;
					case 4:
						return step4;
					case 5:
						return step5;
					case 6:
						return step6;
					case 7:
						return step7;
					case 8:
						return step8;
					case 9:
						return step9;
					case 10:
						return step10;
					default:
						return null;
				}
			}
		});
	}
	
	private int getStep(ItemStack stack)
	{
		NBTTagCompound compound = getOrCreateTagCompound(stack);
		if (!compound.hasKey("step"))
		{
			compound.setInteger("step", 0);
		}
		
		return compound.getInteger("step");
	}
	
	private NBTTagCompound getOrCreateTagCompound(ItemStack stack)
	{
		NBTTagCompound tagCompound = stack.getTagCompound();
		if (tagCompound == null)
		{
			tagCompound = new NBTTagCompound();
			stack.setTagCompound(tagCompound);
		}
		return tagCompound;
	}
	
	public void increaseStep(ItemStack stack)
	{
		int step = getStep(stack);
		step++;
		
		if (step > 10)
		{
			step = 0;
		}
		
		NBTTagCompound compound = getOrCreateTagCompound(stack);
		compound.setInteger("step", step);
	}
	
	public String getName(ItemStack stack)
	{
		int step = getStep(stack);
		switch(step)
		{
			case 0:
				return "Corner";
			case 1:
				return "Corner with vertical extension";
			case 2:
				return "Corner with horizontal extension";
			case 3:
				return "Corner with both extensions";
			case 4:
				return "Stripe with upper extension";
			case 5:
				return "Stripe with bottom extension";
			case 6:
				return "Bottom half stripe with end extension";
			case 7:
				return "Upper half stripe with start extension";
			case 8:
				return "Stripe with middle extension";
			case 9:
				return "Extra small corner extension";
			case 10:
				return "Corner extension";
			default:
				return null;
		}
	}
	
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand,
			EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (worldIn.isRemote)
		{
			return EnumActionResult.SUCCESS;
		}
		
		BlockPos offset = pos.offset(facing);
		IBlockState offsetBlockState = worldIn.getBlockState(offset);
		Block offsetBlock = offsetBlockState.getBlock();
		
		if (!offsetBlock.isReplaceable(worldIn, offset))
		{
			return EnumActionResult.SUCCESS;
		}
		
		BlockStripeBase blockToPlace = getBlockToPlace(player.getHeldItemMainhand());
		IBlockState blockState = blockToPlace.getDefaultState().withProperty(BlockStripeBase.FACING, player.getHorizontalFacing());
		worldIn.setBlockState(offset, blockState);
		
		return EnumActionResult.SUCCESS;
	}
	
	private BlockStripeBase getBlockToPlace(ItemStack stack)
	{
		int step = getStep(stack);
		
		switch(step)
		{
			case 0:
				return ModBlocks.cornerStripe;
			case 1:
				return ModBlocks.cornerVerticalExtension;
			case 2:
				return ModBlocks.cornerHorizontalExtension;
			case 3:
				return ModBlocks.cornerBothExtensions;
			case 4:
				return ModBlocks.stripeUpperExtension;
			case 5:
				return ModBlocks.stripeBottomExtension;
			case 6:
				return ModBlocks.bottomStripeEndExtension;
			case 7:
				return ModBlocks.upperStripeStartExtension;
			case 8:
				return ModBlocks.stripeMiddleExtension;
			case 9:
				return ModBlocks.extraSmallCorner;
			case 10:
				return ModBlocks.cornerExtension;
			default:
				return null;
		}
	}
}
