package Game;

import Engine.DefaultScreen;

import Engine.GraphicsHandler;
import Engine.Screen;
import Level.Audio;
import Screens.CreditsScreen;
import Screens.InstructionsScreen;
import Screens.MenuScreen;
import Screens.PlayLevelScreen;
import Screens.PlayLevelScreen.PlayLevelScreenState;

/*
 * Based on the current game state, this class determines which Screen should be shown
 * There can only be one "currentScreen", although screens can have "nested" screens
 */
public class ScreenCoordinator extends Screen {
	// currently shown Screen
	protected Screen currentScreen = new DefaultScreen();
	protected PlayLevelScreenState currentPlayableState = PlayLevelScreenState.NOT_RUNNING;
	// keep track of gameState so ScreenCoordinator knows which Screen to show
	protected GameState gameState;
	protected GameState previousGameState;

	public GameState getGameState() {
		return gameState;
		
	}

	// Other Screens can set the gameState of this class to force it to change the currentScreen
	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}

	@Override
	public void initialize() {
		// start game off with Menu Screen
		gameState = GameState.MENU;
	}

	@Override
	public void update() {
		do {
			// if previousGameState does not equal gameState, it means there was a change in gameState
			// this triggers ScreenCoordinator to bring up a new Screen based on what the gameState is
			if (previousGameState != gameState) {
				switch(gameState) {
					case MENU:
						currentScreen = new MenuScreen(this);
						break;
					case INSTRUCTIONS:
						currentScreen = new InstructionsScreen(this);
						break;
					case LEVEL:
						currentScreen = new PlayLevelScreen(this);
						break;
					case CREDITS:
						currentScreen = new CreditsScreen(this);
						break;
				}
				//System.out.println(currentScreen.getClass());
				currentScreen.initialize();
			}
			previousGameState = gameState;

			// call the update method for the currentScreen
			currentScreen.update();
		} while (previousGameState != gameState);
		
	}
	public PlayLevelScreenState getScreenState() {
		PlayLevelScreen temp;
		temp = (PlayLevelScreen)currentScreen;
		return temp.getPlayLevelScreenState();
	}

	@Override
	public void draw(GraphicsHandler graphicsHandler) {
		// call the draw method for the currentScreen
		currentScreen.draw(graphicsHandler);
	}
	public Screen getCurrentScreen() {
		return currentScreen;
	}

	
	
}
