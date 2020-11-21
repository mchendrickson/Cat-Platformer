package NPCs;

import Builders.FrameBuilder;


import Engine.GraphicsHandler;
import Engine.ImageLoader;
import Engine.Message;
import GameObject.Frame;
import GameObject.ImageEffect;
import GameObject.SpriteSheet;
import Level.Map;
import Level.NPC;
import Level.Player;
import SpriteFont.SpriteFont;
import Utils.Point;

import java.awt.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;



// This class is for the walrus NPC
public class Walrus extends NPC {
	private String messageText;
	private int textLength;
	private Queue<SpriteFont> messageQueue;
    public Walrus(Point location, Map map) {
        super(location.x, location.y, new SpriteSheet(ImageLoader.load("Walrus.png"), 24, 24), "TAIL_DOWN", 5000);

        setMessage("Hello!");
        interactMessage = new SpriteFont("Press Space to Interact",getX(), getY() - 10, "Arial", 12, Color.BLACK);
        textLength = 130;
       
    }
    

    public void setMessage(String message) {
    	messageText = message;
    }
    
    public void setMessage()
    {
    	interactMessage = messageQueue.peek();
    	messageQueue.remove();
    }

    public void setTextLength(int newTextLength) {
    	textLength = newTextLength;
    }
    @Override
    protected SpriteFont createMessage() {
    	return new SpriteFont(messageText, getX(), getY() - 10, "Arial", 12, Color.BLACK);
    }

    public void update(Player player) {
        // while npc is being talked to, it raises its tail up (in excitement?)
        if (talkedTo) {
            currentAnimationName = "TAIL_UP";
        } else {
            currentAnimationName = "TAIL_DOWN";
        }
        super.update(player);
    }

    @Override
    public HashMap<String, Frame[]> getAnimations(SpriteSheet spriteSheet) {
        return new HashMap<String, Frame[]>() {{
           put("TAIL_DOWN", new Frame[] {
                   new FrameBuilder(spriteSheet.getSprite(0, 0), 0)
                           .withScale(3)
                           .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                           .build()
           });
            put("TAIL_UP", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(1, 0), 0)
                            .withScale(3)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .build()
            });
        }};
    }



    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
    }

    @Override
    public void drawMessage(GraphicsHandler graphicsHandler) {
    	String tempMessageText = messageText;
    	if(talkedTo) {
    	// draws a box with a border (think like a speech box)
        graphicsHandler.drawFilledRectangleWithBorder(Math.round(getCalibratedXLocation() - 2), Math.round(getCalibratedYLocation() - 24), textLength, 25, Color.WHITE, Color.BLACK, 2);

        // draws message "Hello" in the above speech box
        message.setLocation(getCalibratedXLocation() + 2, getCalibratedYLocation() - 8);
        message.draw(graphicsHandler);
        }else {

        graphicsHandler.drawFilledRectangleWithBorder(Math.round(getCalibratedXLocation() - 2), Math.round(getCalibratedYLocation() - 24), 130, 25, new Color(50,50,50,100), Color.BLACK, 2);

        // draws message "Hello" in the above speech box
        interactMessage.setLocation(getCalibratedXLocation() + 2, getCalibratedYLocation() - 8);
        interactMessage.draw(graphicsHandler);
        }
    	setMessage(tempMessageText);
    	//setMessage();
    	
    }
}
