package com.clussmanproductions.modroadworksreborn.textrenderer;

import java.util.ArrayList;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class TextRenderer {
	private static ArrayList<TextRenderItem> _renders = new ArrayList<TextRenderItem>();
	private static Boolean _lock = false;
	
	@SubscribeEvent
	public static void onRender(RenderGameOverlayEvent.Post e)
	{
		
		_lock = true;
		try
		{
			if (_renders.size() == 0)
			{
				return;
			}
			
			Minecraft minecraft = Minecraft.getMinecraft();
			
			if (minecraft == null)
			{
				return;
			}
			
			FontRenderer fontRenderer = minecraft.fontRenderer;
			
			ArrayList<TextRenderItem> rendersToRemove = new ArrayList<TextRenderItem>();
			for (TextRenderItem renderItem : _renders)
			{
				fontRenderer.drawStringWithShadow(renderItem.getText(), renderItem.getX(), renderItem.getY(), renderItem.getColor());
			}
		}
		finally
		{
			_lock = false;
		}
	}
	
	@SubscribeEvent
	public static void onTick(ClientTickEvent e)
	{
		if (e.phase == Phase.END)
		{
			ArrayList<TextRenderItem> rendersToRemove = new ArrayList<TextRenderItem>();
			
			_lock = true;
			try
			{
				for(TextRenderItem item : _renders)
				{
					item.elapse();
					
					if (item.getTicksRemaining() <= 0)
					{
						rendersToRemove.add(item);
					}
				}
				
				for(TextRenderItem itemToRemove : rendersToRemove)
				{
					_renders.remove(itemToRemove);
				}
			}
			finally
			{
				_lock = false;
			}
		}
	}
	
	public static void addTextRender(TextRenderItem item)
	{
		while (_lock)
		{
			
		}
		
		ArrayList<TextRenderItem> itemsToRemove = new ArrayList<TextRenderItem>();
		for(TextRenderItem anItem : _renders)
		{
			if (anItem.getCategory().equals(item.getCategory()))
			{
				itemsToRemove.add(anItem);
			}
		}
		
		for(TextRenderItem anItem : itemsToRemove)
		{
			_renders.remove(anItem);
		}
		
		_renders.add(item);
	}
}
