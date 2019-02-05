package com.clussmanproductions.modroadworksreborn.network;

import com.clussmanproductions.modroadworksreborn.textrenderer.TextRenderItem;
import com.clussmanproductions.modroadworksreborn.textrenderer.TextRenderer;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketRenderTextOnClient implements IMessage {

	public String message;
	public String category;
	public int renderLength;
	@Override
	public void fromBytes(ByteBuf buf) {
		int messageLen = buf.readInt();
		
		byte[] message = new byte[messageLen];
		buf.readBytes(message, 0, messageLen);
		
		int categoryLen = buf.readInt();
		byte[] category = new byte[categoryLen];
		buf.readBytes(category, 0, categoryLen);
		
		renderLength = buf.readInt();
		
		this.message = new String(message);
		this.category = new String(category);
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(message.length());
		buf.writeBytes(message.getBytes());
		buf.writeInt(category.length());
		buf.writeBytes(category.getBytes());
		buf.writeInt(renderLength);
	}

	public static class Handler implements IMessageHandler<PacketRenderTextOnClient, IMessage>
	{

		@Override
		public IMessage onMessage(PacketRenderTextOnClient message, MessageContext ctx) {
			FMLCommonHandler.instance().getWorldThread(ctx.netHandler).addScheduledTask(() -> handle(message, ctx));
			
			return null;
		}
		
		private void handle(PacketRenderTextOnClient message, MessageContext ctx)
		{
			TextRenderer.addTextRender(new TextRenderItem(message.message, message.category, message.renderLength, 0, 0, TextRenderItem.Colors.WHITE));
		}
	}
}
