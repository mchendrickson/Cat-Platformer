package Screens;

import Engine.*;
import Game.GameState;
import Game.ScreenCoordinator;
import Level.Audio;
import Level.Map;
import Maps.TitleScreenMap;
import SpriteFont.SpriteFont;
import Utils.Stopwatch;

import java.awt.*;
import java.util.LinkedList;

// This is the class for the main menu screen
public class MenuScreen extends Screen {
    protected ScreenCoordinator screenCoordinator;
    protected int currentMenuItemHovered = 0; // current menu item being "hovered" over
    protected int menuItemSelected = -1;
    protected SpriteFont playGame;
    protected SpriteFont credits;
    protected SpriteFont instructions;
    protected Map background;
    protected Stopwatch keyTimer = new Stopwatch();
    protected int pointerLocationX, pointerLocationY;
    protected KeyLocker keyLocker = new KeyLocker();
    protected boolean useMouseControl;
    protected Point lastMovedMousePos;
    protected LinkedList<SpriteFont> spriteFontList;
    protected LinkedList<SpriteFontRectangle> rectList;
    public MenuScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
    }

    @Override
    public void initialize() {
        playGame = new SpriteFont("PLAY GAME", 200, 150, "Comic Sans", 30, new Color(49, 207, 240));
        playGame.setOutlineColor(Color.black);
        playGame.setOutlineThickness(3);
        
        credits = new SpriteFont("CREDITS", 200, 250, "Comic Sans", 30, new Color(49, 207, 240));
        credits.setOutlineColor(Color.black);
        credits.setOutlineThickness(3);
        
        instructions = new SpriteFont("INSTRUCTIONS", 200, 350, "Comic Sans", 30, new Color(49, 207, 240));
        instructions.setOutlineColor(Color.black);
        instructions.setOutlineThickness(3);
        
        background = new TitleScreenMap();
        background.setAdjustCamera(false);
        keyTimer.setWaitTime(200);
        menuItemSelected = -1;
        keyLocker.lockKey(Key.SPACE);
        keyLocker.lockKey(Key.ENTER);
        
        //Add all of our sprites to a list so we can get their coordinates
        spriteFontList = new LinkedList<SpriteFont>();
        spriteFontList.add(playGame);
        spriteFontList.add(credits);
        spriteFontList.add(instructions);
        
        
        
    }
    
    //Get the bounds for each of our SpriteFonts, and then create rectangles from those bounds, then create a list of those rectangles.
    public void createBounds() {
    	
    	int itemPos = 0;
    	rectList = new LinkedList<SpriteFontRectangle>();
    	for(SpriteFont font : spriteFontList) {
    		
    		SpriteFontRectangle fontRect = new SpriteFontRectangle(new Point((int)font.getX(),(int)font.getY()));
    		fontRect.width = (int) font.getWidth();
    		fontRect.height = (int) font.getHeight();
    		fontRect.setSpriteFont(font);
    		
    		//itemPos tells us what scene number to load when we click the spritefont
    		fontRect.setItemPos(itemPos);
    		itemPos++;
    		rectList.add(fontRect);
    	}
    }
    
    public void selectViaMouse() {
    	//Get the bounds
    	createBounds();
    	
    	//For all the spritefonts, check if the mouse position lies inside the rectangle, if so and we click, load the level
    	for(SpriteFontRectangle rect : rectList) {
    		
    		//if the width is zero, we didn't add them correctly
    		if(rect.width != 0) {
    			
    			if(rect.contains(Keyboard.getMousePos())){
    				currentMenuItemHovered = rect.getItemPos();
    				
    				//Key press decides to open the level
    				if(Keyboard.getMousePressed()) {
    					
    					menuItemSelected = currentMenuItemHovered;
    					if (menuItemSelected == 0) {
    		                screenCoordinator.setGameState(GameState.LEVEL);
    		            } else if (menuItemSelected == 1) {
    		                screenCoordinator.setGameState(GameState.CREDITS);
    		            } else if(menuItemSelected == 2) {
    		            	screenCoordinator.setGameState(GameState.INSTRUCTIONS);
    		            }
    				}
    			
    			}
    		
    		}	
    	}
    	
    }
    
    
    public void selectViaKeyboard() {
    	// if down or up is pressed, change menu item "hovered" over (blue square in front of text will move along with currentMenuItemHovered changing)
        if ((Keyboard.isKeyDown(Key.DOWN) || Keyboard.isKeyDown(Key.S)) && keyTimer.isTimeUp()) {
            keyTimer.reset();
            currentMenuItemHovered++;
        } else if ((Keyboard.isKeyDown(Key.UP) || Keyboard.isKeyDown(Key.W)) && keyTimer.isTimeUp()) {
            keyTimer.reset();
            currentMenuItemHovered--;
        }
        //System.out.println(currentMenuItemHovered);
        // if down is pressed on last menu item or up is pressed on first menu item, "loop" the selection back around to the beginning/end
        
        if (Keyboard.isKeyUp(Key.SPACE)) {
            keyLocker.unlockKey(Key.SPACE);
        }
        
        if (Keyboard.isKeyUp(Key.ENTER)) {
            keyLocker.unlockKey(Key.ENTER);
        }
        // if space is pressed on menu item, change to appropriate screen based on which menu item was chosen
        
        if ((!keyLocker.isKeyLocked(Key.SPACE) && Keyboard.isKeyDown(Key.SPACE)) || (!keyLocker.isKeyLocked(Key.ENTER) && Keyboard.isKeyDown(Key.ENTER))) {
            menuItemSelected = currentMenuItemHovered;
            if (menuItemSelected == 0) {
                screenCoordinator.setGameState(GameState.LEVEL);
            } else if (menuItemSelected == 1) {
                screenCoordinator.setGameState(GameState.CREDITS);
            } else if(menuItemSelected == 2) {
            	screenCoordinator.setGameState(GameState.INSTRUCTIONS);
            }
        }
        
    }
    
    public void update() {
        // update background map (to play tile animations)	
    	background.update(null);
        mouseOrKeyboard();
        
    }
    
    //When we move the mouse, we want to disable movement via the W, S, and arrow keys
    public void mouseOrKeyboard() {
    	if(Keyboard.getMousePos() != lastMovedMousePos || Keyboard.getMousePressed()) {
    		selectViaMouse();
    		lastMovedMousePos = Keyboard.getMousePos();
    	}else {
    		selectViaKeyboard();
    	}
    	
    	//If we cycle to high or too low with keys, cycle back to the bottom or top respectively
    	if (currentMenuItemHovered > 2) {
            currentMenuItemHovered = 0;
        } else if (currentMenuItemHovered == 1) {
            currentMenuItemHovered = 1;
        } else if(currentMenuItemHovered == 2) {
        	currentMenuItemHovered = 2;
        } else if(currentMenuItemHovered < 0){
        	currentMenuItemHovered = 2;
        }

        // sets location for blue square in front of text (pointerLocation) and also sets color of spritefont text based on which menu item is being hovered
        if (currentMenuItemHovered == 0) {
            playGame.setColor(new Color(255, 215, 0));
            credits.setColor(new Color(49, 207, 240));
            instructions.setColor(new Color(49, 207, 240));
            pointerLocationX = 170;
            pointerLocationY = 130;
        } else if (currentMenuItemHovered == 1) {
            playGame.setColor(new Color(49, 207, 240));
            credits.setColor(new Color(255, 215, 0));
            instructions.setColor(new Color(49, 207, 240));
            pointerLocationX = 170;
            pointerLocationY = 230;
        } else if(currentMenuItemHovered == 2) {
        	playGame.setColor(new Color(49, 207, 240));
            credits.setColor(new Color(49, 207, 240));
            instructions.setColor(new Color(255, 215, 0));
            pointerLocationX = 170;
            pointerLocationY = 330;
        }
    }
    

    public void draw(GraphicsHandler graphicsHandler) {
        background.draw(graphicsHandler);
        playGame.draw(graphicsHandler);
        credits.draw(graphicsHandler);
        instructions.draw(graphicsHandler);
        
        //Set the width and height for our rectangles by getting the literal width from the pixels the font takes up
        playGame.setWidth(graphicsHandler.getFontWidth(playGame.getFont(), playGame.getText()));
        credits.setWidth(graphicsHandler.getFontWidth(credits.getFont(), credits.getText()));
        instructions.setWidth(graphicsHandler.getFontWidth(instructions.getFont(), instructions.getText()));
        
        playGame.setHeight(graphicsHandler.getFontHeight(playGame.getFont()));
        credits.setHeight(graphicsHandler.getFontHeight(credits.getFont()));
        instructions.setHeight(graphicsHandler.getFontHeight(instructions.getFont()));
        
        graphicsHandler.drawFilledRectangleWithBorder(pointerLocationX, pointerLocationY, 20, 20, new Color(49, 207, 240), Color.black, 2);
        
    }

    public int getMenuItemSelected() {
        return menuItemSelected;
    }
}
