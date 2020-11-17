package Screens;

import Engine.*;
import Game.GameState;
import Game.ScreenCoordinator;
import GameObject.SpriteSheet;
import Level.Map;
import Maps.TitleScreenMap;
import SpriteFont.SpriteFont;

import java.awt.*;

// This class is for the instructions screen
public class InstructionsScreen extends Screen {
    protected ScreenCoordinator screenCoordinator;
    protected Map background;
    protected KeyLocker keyLocker = new KeyLocker();
    protected SpriteFont instructionsLabel;
    protected SpriteFont movementLabel;
    protected SpriteFont objectiveLabel;
    protected SpriteFont walrusLabel;
    protected SpriteFont returnInstructionsLabel;
    protected SpriteFont walrusText;
    protected SpriteSheet coin;
    
    public InstructionsScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
    }

    @Override
    public void initialize() {
        // setup graphics on screen (background map, spritefont text)
        background = new TitleScreenMap();
        background.setAdjustCamera(false);
        instructionsLabel = new SpriteFont("INSTRUCTIONS", 15, 35, "Comic Sans", 30, new Color(49, 207, 240));
        movementLabel = new SpriteFont("Move using either the WASD keys or the Arrow keys", 15, 140, "Comic Sans", 25, new Color(255, 215, 0));
        objectiveLabel = new SpriteFont("Collect coins and avoid the enemies until you reach \nthe golden cube to pass the level", 15, 220, "Comic Sans",25, new Color(255, 215, 0));
        walrusLabel = new SpriteFont("Press space to interact with the Walruses", 15, 320, "Comic Sans", 25, new Color(255, 215, 0));
        returnInstructionsLabel = new SpriteFont("Press Space to return to the menu", 15, 560, "Comic Sans", 30, new Color(49, 207, 240));
        
        instructionsLabel.setOutlineColor(Color.black);
        instructionsLabel.setOutlineThickness(3);
        
        movementLabel.setOutlineColor(Color.black);
        movementLabel.setOutlineThickness(2.5f);
        
        objectiveLabel.setOutlineColor(Color.black);
        objectiveLabel.setOutlineThickness(2.5f);
        
        walrusLabel.setOutlineColor(Color.black);
        walrusLabel.setOutlineThickness(2.5f);
        
        returnInstructionsLabel.setOutlineColor(Color.black);
        returnInstructionsLabel.setOutlineThickness(2);
        
        keyLocker.lockKey(Key.SPACE);
    }

    public void update() {
        background.update(null);

        if (Keyboard.isKeyUp(Key.SPACE)) {
            keyLocker.unlockKey(Key.SPACE);
        }

        // if space is pressed, go back to main menu
        if (!keyLocker.isKeyLocked(Key.SPACE) && Keyboard.isKeyDown(Key.SPACE)) {
            screenCoordinator.setGameState(GameState.MENU);
        }
    }

    public void draw(GraphicsHandler graphicsHandler) {
    	background.draw(graphicsHandler);
    	instructionsLabel.draw(graphicsHandler);
        movementLabel.draw(graphicsHandler);
        objectiveLabel.drawWithParsedNewLines(graphicsHandler);
        walrusLabel.draw(graphicsHandler);
        returnInstructionsLabel.draw(graphicsHandler);
    }
}
