package com.clussmanproductions.modroadworksreborn;

import org.apache.logging.log4j.Logger;

import com.clussmanproductions.modroadworksreborn.proxy.CommonProxy;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ModRoadworksReborn.MODID, name = ModRoadworksReborn.MODNAME, version = ModRoadworksReborn.MODVERSION, useMetadata = true)
public class ModRoadworksReborn {
	public static final String MODID = "modroadworksreborn";
	public static final String MODNAME = "Roadworks Reborn";
	public static final String MODVERSION = "0.0.3";
	public static final CreativeTabs ROADWORKSREBORN = new CreativeTabs("Roadworks Reborn") {
		
		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(ModItems.sideStripePainter);
		}
	};
	
	@SidedProxy(clientSide = "com.clussmanproductions.modroadworksreborn.proxy.ClientProxy", serverSide = "com.clussmanproductions.modroadworksreborn.proxy.ServerProxy")
	public static CommonProxy proxy;
	
	@Mod.Instance
	public static ModRoadworksReborn instance;
	
	public static Logger logger;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent e)
	{
		logger = e.getModLog();
		proxy.preInit(e);
	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent e)
	{
		proxy.init(e);
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent e)
	{
		proxy.postInit(e);
	}
}
