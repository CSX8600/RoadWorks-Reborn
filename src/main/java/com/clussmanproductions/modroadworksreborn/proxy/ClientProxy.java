package com.clussmanproductions.modroadworksreborn.proxy;

import org.lwjgl.input.Keyboard;

import com.clussmanproductions.modroadworksreborn.ModItems;
import com.clussmanproductions.modroadworksreborn.network.PacketHandler;
import com.clussmanproductions.modroadworksreborn.network.PacketSendExtraStripeKey;
import com.clussmanproductions.modroadworksreborn.textrenderer.TextRenderItem;
import com.clussmanproductions.modroadworksreborn.textrenderer.TextRenderer;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {
	private static KeyBinding[] keyBindings = new KeyBinding[1];
	
	@Override
	public void preInit(FMLPreInitializationEvent e) {
		super.preInit(e);
	}
	
	@Override
	public void init(FMLInitializationEvent e) {
		super.init(e);
		
		keyBindings[0] = new KeyBinding("key.extrastripepainter.change", Keyboard.KEY_X, "key.roadworksreborn.category");
		ClientRegistry.registerKeyBinding(keyBindings[0]);
	}
	
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event)
	{

		ModItems.extraStripePainter.initModel();
		ModItems.extraStripePainterYellow.initModel();
		ModItems.arrowPainter.initModel();
		ModItems.arrowPainterYellow.initModel();
	}
	
	@SubscribeEvent()
	public static void onEvent(KeyInputEvent e)
	{
		if (keyBindings[0].isPressed())
		{
			PacketHandler.INSTANCE.sendToServer(new PacketSendExtraStripeKey());
		}
	}
}
