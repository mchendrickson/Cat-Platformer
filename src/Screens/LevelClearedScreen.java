package Screens;

import Engine.GraphicsHandler;
import Engine.KeyLocker;
import Engine.Screen;
import Engine.ScreenManager;
import SpriteFont.SpriteFont;

import java.awt.*;

// This class is for the level cleared screen
public class LevelClearedScreen extends Screen {
    protected SpriteFont winMessage;
    protected KeyLocker keyLocker;
    public LevelClearedScreen() {
    }

    @Override
    public void initialize() {
        winMessage = new SpriteFont("LEVEL CLEARED", 160, 270, "Comic Sans", 60, new Color(255, 215, 0));
        
        winMessage.setOutlineColor(Color.black);
        winMessage.setOutlineThickness(5);
    }
    

    @Override
    public void update() {

    }

    public void draw(GraphicsHandler graphicsHandler) {
        // paint entire screen black and dislpay level cleared text
        graphicsHandler.drawFilledRectangle(0, 0, ScreenManager.getScreenWidth(), ScreenManager.getScreenHeight(), Color.BLACK);
        winMessage.draw(graphicsHandler);
    }
}
