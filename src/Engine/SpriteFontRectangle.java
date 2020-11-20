package Engine;

import java.awt.Point;
import java.awt.Rectangle;

import SpriteFont.SpriteFont;

public class SpriteFontRectangle extends Rectangle{
	protected SpriteFont attachedFont;
	protected int itemPos;
	public SpriteFontRectangle(Point p) {
		super(p);
	}
	
	public void setSpriteFont(SpriteFont font) {
		attachedFont = font;
	}
	
	public SpriteFont getSpriteFont() {
		return attachedFont;
	}
	
	public void setItemPos(int newItemPos) {
		itemPos = newItemPos;
	}
	
	public int getItemPos() {
		return itemPos;
	}
	
}
