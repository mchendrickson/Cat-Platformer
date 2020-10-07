package Screens;

import Engine.GraphicsHandler;
import Engine.Key;
import Engine.KeyLocker;
import Engine.Screen;
import Game.ScreenCoordinator;
import Level.Map;

public class InstructionsScreen extends Screen {
	protected ScreenCoordinator screenCoordinator;
    protected KeyLocker keyLocker = new KeyLocker();
    protected Map background;
    
	public InstructionsScreen(ScreenCoordinator screenCoordinator) {
	        this.screenCoordinator = screenCoordinator;
	}
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
	keyLocker.lockKey(Key.SPACE);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw(GraphicsHandler graphicsHandler) {
		// TODO Auto-generated method stub

	}

}
