package com.clussmanproductions.modroadworksreborn;

import com.clussmanproductions.modroadworksreborn.items.ItemArrowPainter;
import com.clussmanproductions.modroadworksreborn.items.ItemArrowPainterYellow;
import com.clussmanproductions.modroadworksreborn.items.ItemExtraStripePainter;
import com.clussmanproductions.modroadworksreborn.items.ItemExtraStripePainterYellow;
import com.clussmanproductions.modroadworksreborn.items.ItemMidStripePainter;
import com.clussmanproductions.modroadworksreborn.items.ItemMidStripePainterYellow;
import com.clussmanproductions.modroadworksreborn.items.ItemSideStripePainter;
import com.clussmanproductions.modroadworksreborn.items.ItemSideStripePainterYellow;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@ObjectHolder("modroadworksreborn")
public class ModItems {
	@GameRegistry.ObjectHolder("sidestripepainter")
	public static ItemSideStripePainter sideStripePainter;
	@GameRegistry.ObjectHolder("sidestripepainteryellow")
	public static ItemSideStripePainterYellow sideStripePainterYellow;
	@GameRegistry.ObjectHolder("midstripepainter")
	public static ItemMidStripePainter midStripePainter;
	@GameRegistry.ObjectHolder("midstripepainteryellow")
	public static ItemMidStripePainterYellow midStripePainterYellow;
	@GameRegistry.ObjectHolder("extrastripepainter")
	public static ItemExtraStripePainter extraStripePainter;
	@GameRegistry.ObjectHolder("extrastripepainteryellow")
	public static ItemExtraStripePainterYellow extraStripePainterYellow;
	@GameRegistry.ObjectHolder("arrowpainter")
	public static ItemArrowPainter arrowPainter;
	@GameRegistry.ObjectHolder("arrowpainteryellow")
	public static ItemArrowPainterYellow arrowPainterYellow;
}
