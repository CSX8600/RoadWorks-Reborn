package com.clussmanproductions.modroadworksreborn.proxy;

import com.clussmanproductions.modroadworksreborn.ModBlocks;
import com.clussmanproductions.modroadworksreborn.ModItems;
import com.clussmanproductions.modroadworksreborn.blocks.BlockBottomStripeEndExtension;
import com.clussmanproductions.modroadworksreborn.blocks.BlockBottomStripeEndExtensionYellow;
import com.clussmanproductions.modroadworksreborn.blocks.BlockCornerBothExtensions;
import com.clussmanproductions.modroadworksreborn.blocks.BlockCornerBothExtensionsYellow;
import com.clussmanproductions.modroadworksreborn.blocks.BlockCornerExtension;
import com.clussmanproductions.modroadworksreborn.blocks.BlockCornerExtensionYellow;
import com.clussmanproductions.modroadworksreborn.blocks.BlockCornerHorizontalExtension;
import com.clussmanproductions.modroadworksreborn.blocks.BlockCornerHorizontalExtensionYellow;
import com.clussmanproductions.modroadworksreborn.blocks.BlockCornerStripe;
import com.clussmanproductions.modroadworksreborn.blocks.BlockCornerStripeYellow;
import com.clussmanproductions.modroadworksreborn.blocks.BlockCornerVerticalExtension;
import com.clussmanproductions.modroadworksreborn.blocks.BlockCornerVerticalExtensionYellow;
import com.clussmanproductions.modroadworksreborn.blocks.BlockExtraSmallCorner;
import com.clussmanproductions.modroadworksreborn.blocks.BlockExtraSmallCornerYellow;
import com.clussmanproductions.modroadworksreborn.blocks.BlockForward;
import com.clussmanproductions.modroadworksreborn.blocks.BlockForwardLeft;
import com.clussmanproductions.modroadworksreborn.blocks.BlockForwardLeftYellow;
import com.clussmanproductions.modroadworksreborn.blocks.BlockForwardRight;
import com.clussmanproductions.modroadworksreborn.blocks.BlockForwardRightLeft;
import com.clussmanproductions.modroadworksreborn.blocks.BlockForwardRightLeftYellow;
import com.clussmanproductions.modroadworksreborn.blocks.BlockForwardRightYellow;
import com.clussmanproductions.modroadworksreborn.blocks.BlockForwardYellow;
import com.clussmanproductions.modroadworksreborn.blocks.BlockLeft;
import com.clussmanproductions.modroadworksreborn.blocks.BlockLeftYellow;
import com.clussmanproductions.modroadworksreborn.blocks.BlockMidStripe;
import com.clussmanproductions.modroadworksreborn.blocks.BlockMidStripeYellow;
import com.clussmanproductions.modroadworksreborn.blocks.BlockRight;
import com.clussmanproductions.modroadworksreborn.blocks.BlockRightLeft;
import com.clussmanproductions.modroadworksreborn.blocks.BlockRightLeftYellow;
import com.clussmanproductions.modroadworksreborn.blocks.BlockRightYellow;
import com.clussmanproductions.modroadworksreborn.blocks.BlockSideStripe;
import com.clussmanproductions.modroadworksreborn.blocks.BlockSideStripeYellow;
import com.clussmanproductions.modroadworksreborn.blocks.BlockStripeBottomExtension;
import com.clussmanproductions.modroadworksreborn.blocks.BlockStripeBottomExtensionYellow;
import com.clussmanproductions.modroadworksreborn.blocks.BlockStripeMiddleExtension;
import com.clussmanproductions.modroadworksreborn.blocks.BlockStripeMiddleExtensionYellow;
import com.clussmanproductions.modroadworksreborn.blocks.BlockStripeUpperExtension;
import com.clussmanproductions.modroadworksreborn.blocks.BlockStripeUpperExtensionYellow;
import com.clussmanproductions.modroadworksreborn.blocks.BlockTar;
import com.clussmanproductions.modroadworksreborn.blocks.BlockUpperStripeStartExtension;
import com.clussmanproductions.modroadworksreborn.blocks.BlockUpperStripeStartExtensionYellow;
import com.clussmanproductions.modroadworksreborn.items.ItemArrowPainter;
import com.clussmanproductions.modroadworksreborn.items.ItemArrowPainterYellow;
import com.clussmanproductions.modroadworksreborn.items.ItemExtraStripePainter;
import com.clussmanproductions.modroadworksreborn.items.ItemExtraStripePainterYellow;
import com.clussmanproductions.modroadworksreborn.items.ItemMidStripePainter;
import com.clussmanproductions.modroadworksreborn.items.ItemMidStripePainterYellow;
import com.clussmanproductions.modroadworksreborn.items.ItemSideStripePainter;
import com.clussmanproductions.modroadworksreborn.items.ItemSideStripePainterYellow;
import com.clussmanproductions.modroadworksreborn.network.PacketHandler;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber
public class CommonProxy {	
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> e)
	{
		registerItem(e, new ItemSideStripePainter());
		registerItem(e, new ItemSideStripePainterYellow());
		registerItem(e, new ItemMidStripePainter());
		registerItem(e, new ItemMidStripePainterYellow());
		registerItem(e, new ItemExtraStripePainter());
		registerItem(e, new ItemExtraStripePainterYellow());
		registerItem(e, new ItemArrowPainter());	
		registerItem(e, new ItemArrowPainterYellow());
		
		e.getRegistry().register(new ItemBlock(ModBlocks.tar).setRegistryName(ModBlocks.tar.getRegistryName()));
	}
	
	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public static void registerModels(ModelRegistryEvent e)
	{
		registerModel(ModItems.sideStripePainter);
		registerModel(ModItems.sideStripePainterYellow);
		registerModel(ModItems.midStripePainter);
		registerModel(ModItems.midStripePainterYellow);
		
		ModBlocks.tar.initModel();
	}
	
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> e)
	{
		registerBlock(e, new BlockSideStripe());
		registerBlock(e, new BlockSideStripeYellow());
		registerBlock(e, new BlockMidStripe());
		registerBlock(e, new BlockMidStripeYellow());
		registerBlock(e, new BlockCornerStripe());
		registerBlock(e, new BlockBottomStripeEndExtension());
		registerBlock(e, new BlockCornerBothExtensions());
		registerBlock(e, new BlockCornerExtension());
		registerBlock(e, new BlockCornerHorizontalExtension());
		registerBlock(e, new BlockCornerVerticalExtension());
		registerBlock(e, new BlockExtraSmallCorner());
		registerBlock(e, new BlockStripeBottomExtension());
		registerBlock(e, new BlockStripeMiddleExtension());
		registerBlock(e, new BlockStripeUpperExtension());
		registerBlock(e, new BlockUpperStripeStartExtension());
		registerBlock(e, new BlockCornerStripeYellow());
		registerBlock(e, new BlockBottomStripeEndExtensionYellow());
		registerBlock(e, new BlockCornerBothExtensionsYellow());
		registerBlock(e, new BlockCornerExtensionYellow());
		registerBlock(e, new BlockCornerHorizontalExtensionYellow());
		registerBlock(e, new BlockCornerVerticalExtensionYellow());
		registerBlock(e, new BlockExtraSmallCornerYellow());
		registerBlock(e, new BlockStripeBottomExtensionYellow());
		registerBlock(e, new BlockStripeMiddleExtensionYellow());
		registerBlock(e, new BlockStripeUpperExtensionYellow());
		registerBlock(e, new BlockUpperStripeStartExtensionYellow());
		registerBlock(e, new BlockForward());
		registerBlock(e, new BlockRight());
		registerBlock(e, new BlockLeft());
		registerBlock(e, new BlockForwardRight());
		registerBlock(e, new BlockForwardLeft());
		registerBlock(e, new BlockRightLeft());
		registerBlock(e, new BlockForwardRightLeft());
		registerBlock(e, new BlockForwardYellow());
		registerBlock(e, new BlockRightYellow());
		registerBlock(e, new BlockLeftYellow());
		registerBlock(e, new BlockForwardRightYellow());
		registerBlock(e, new BlockForwardLeftYellow());
		registerBlock(e, new BlockRightLeftYellow());
		registerBlock(e, new BlockForwardRightLeftYellow());
		registerBlock(e, new BlockTar());
	}
	
	public void preInit(FMLPreInitializationEvent e)
	{
		PacketHandler.registerMessages("roadworksreborn");
	}
	
	public void init(FMLInitializationEvent e)
	{
		
	}
	
	public void postInit(FMLPostInitializationEvent e)
	{
		
	}
	
	private static void registerItem(RegistryEvent.Register<Item> e, Item item)
	{
		e.getRegistry().register(item);
	}
	
	private static void registerBlock(RegistryEvent.Register<Block> e, Block block)
	{
		e.getRegistry().register(block);
	}
	
	private static void registerModel(Item item)
	{
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}
