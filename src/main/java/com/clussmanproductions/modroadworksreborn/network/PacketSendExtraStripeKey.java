package com.clussmanproductions.modroadworksreborn.network;

import com.clussmanproductions.modroadworksreborn.items.ItemArrowPainter;
import com.clussmanproductions.modroadworksreborn.items.ItemArrowPainterYellow;
import com.clussmanproductions.modroadworksreborn.items.ItemExtraStripePainter;
import com.clussmanproductions.modroadworksreborn.items.ItemExtraStripePainterYellow;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketSendExtraStripeKey implements IMessage {
	
	@Override
	public void fromBytes(ByteBuf buf) {
		
	}

	@Override
	public void toBytes(ByteBuf buf) {
		
	}
	
	public static class Handler implements IMessageHandler<PacketSendExtraStripeKey, IMessage>
	{

		@Override
		public IMessage onMessage(PacketSendExtraStripeKey message, MessageContext ctx) {
			FMLCommonHandler.instance().getWorldThread(ctx.netHandler).addScheduledTask(() -> handle(message, ctx));
			return null;
		}
		
		private void handle(PacketSendExtraStripeKey message, MessageContext ctx)
		{
			EntityPlayerMP player = ctx.getServerHandler().player;
			ItemStack stack = player.getHeldItemMainhand();
			Item item = stack.getItem();
			
			if (item instanceof ItemExtraStripePainter)
			{
				ItemExtraStripePainter painter = (ItemExtraStripePainter)item;
				painter.increaseStep(stack);
				
				PacketRenderTextOnClient renderPacket = new PacketRenderTextOnClient();
				renderPacket.message = "Extrastyle: " + painter.getName(stack);
				renderPacket.category = "00";
				renderPacket.renderLength = 200;
				
				PacketHandler.INSTANCE.sendTo(renderPacket, player);
			}
			else if (item instanceof ItemExtraStripePainterYellow)
			{
				ItemExtraStripePainterYellow painter = (ItemExtraStripePainterYellow)item;
				painter.increaseStep(stack);
				
				PacketRenderTextOnClient renderPacket = new PacketRenderTextOnClient();
				renderPacket.message = "Extrastyle: " + painter.getName(stack);
				renderPacket.category = "00";
				renderPacket.renderLength = 200;
				
				PacketHandler.INSTANCE.sendTo(renderPacket, player);
			}
			else if (item instanceof ItemArrowPainter)
			{
				ItemArrowPainter painter = (ItemArrowPainter)item;
				painter.increaseStep(stack);
				
				PacketRenderTextOnClient renderPacket = new PacketRenderTextOnClient();
				renderPacket.message = "Arrow: " + painter.getName(stack);
				renderPacket.category = "00";
				renderPacket.renderLength = 200;
				
				PacketHandler.INSTANCE.sendTo(renderPacket, player);
			}
			else if (item instanceof ItemArrowPainterYellow)
			{
				ItemArrowPainterYellow painter = (ItemArrowPainterYellow)item;
				painter.increaseStep(stack);
				
				PacketRenderTextOnClient renderPacket = new PacketRenderTextOnClient();
				renderPacket.message = "Arrow: " + painter.getName(stack);
				renderPacket.category = "00";
				renderPacket.renderLength = 200;
				
				PacketHandler.INSTANCE.sendTo(renderPacket, player);
			}
		}
	}
}
