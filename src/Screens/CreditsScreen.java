package Screens;

import Engine.*;
import Game.GameState;
import Game.ScreenCoordinator;
import Level.Map;
import Maps.TitleScreenMap;
import SpriteFont.SpriteFont;

import java.awt.*;

// This class is for the credits screen
public class CreditsScreen extends Screen {
    protected ScreenCoordinator screenCoordinator;
    protected Map background;
    protected KeyLocker keyLocker = new KeyLocker();
    protected SpriteFont creditsLabel;
    protected SpriteFont createdByLabel;
    protected SpriteFont contributorsLabel;
    protected SpriteFont returnInstructionsLabel;

    public CreditsScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
    }

    @Override
    public void initialize() {
        // setup graphics on screen (background map, spritefont text)
        background = new TitleScreenMap();
        background.setAdjustCamera(false);
        creditsLabel = new SpriteFont("CREDITS", 15, 35, "Comic Sans", 30, new Color(49, 207, 240));
        createdByLabel = new SpriteFont("Created by Alex Thimineur for Quinnipiac's SER 225 Course.", 15, 140, "Comic Sans", 25, new Color(255, 215, 0));
        contributorsLabel = new SpriteFont("Modified during Quinnipiac's SER 225 Course by Matthew Hendrickson, \nAndrew DePass, Jake DeBroffe, Christian Cooper. \n\n\n\nThank you to QU Alumni Brian Carducci, Joseph White,\nand Alex Hutman for their contributions. ", 15, 250, "Comic Sans", 25, new Color(255, 215, 0));
        returnInstructionsLabel = new SpriteFont("Press Space to return to the menu", 15, 560, "Comic Sans", 30, new Color(49, 207, 240));
        
        creditsLabel.setOutlineColor(Color.black);
        creditsLabel.setOutlineThickness(3);
        
        createdByLabel.setOutlineColor(Color.black);
        createdByLabel.setOutlineThickness(2.5f);
        
        contributorsLabel.setOutlineColor(Color.black);
        contributorsLabel.setOutlineThickness(2.5f);
        
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
        creditsLabel.draw(graphicsHandler);
        createdByLabel.draw(graphicsHandler);
        contributorsLabel.drawWithParsedNewLines(graphicsHandler);
        returnInstructionsLabel.draw(graphicsHandler);
    }
}
