package com.clussmanproductions.modroadworksreborn.textrenderer;

public class TextRenderItem {
	private String _text;
	private String _category;
	private int _ticks;
	private int _ticksElapsed;
	private int _x;
	private int _y;
	private int _color;
	
	public TextRenderItem(String text, String category, int ticks, int x, int y, int color)
	{
		_text = text;
		_category = category;
		_ticks = ticks;
		_x = x;
		_y = y;
		_color = color;
	}
	
	public String getText()
	{
		return _text;
	}
	
	public String getCategory()
	{
		return _category;
	}
	
	public int getTicksRemaining()
	{
		return _ticks - _ticksElapsed;
	}
	
	public int getX()
	{
		return _x;
	}
	
	public int getY()
	{
		return _y;
	}
	
	public int getColor()
	{
		return _color;
	}
	
	public void elapse()
	{
		_ticksElapsed++;
	}
	
	public static class Colors
	{
		public static final int WHITE = 16777215; 
	}
}
