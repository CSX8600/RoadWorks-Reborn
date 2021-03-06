package com.clussmanproductions.modroadworksreborn.blocks;

import com.clussmanproductions.modroadworksreborn.ModRoadworksReborn;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockTar extends Block {
	public BlockTar()
	{
		super(Material.ROCK);
		setRegistryName("tar");
		setUnlocalizedName(ModRoadworksReborn.MODID + ".tar");
		setCreativeTab(ModRoadworksReborn.ROADWORKSREBORN);
		setHardness(1.5F);
	}
	
	@SideOnly(Side.CLIENT)
	public void initModel()
	{
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}
}
