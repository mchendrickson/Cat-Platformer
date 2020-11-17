package Screens;

import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import Engine.GraphicsHandler;
import Engine.Screen;
import Game.GameState;
import Game.ScreenCoordinator;
import Level.Map;
import Level.Player;
import Level.PlayerListener;
import Maps.HillsMap;
import Maps.PlatformMap;
import Maps.TestMap;
import Maps.TreesMap;
import Maps.TutorialMap;
import Maps.UndergroundMap;
import Players.Cat;
import SpriteFont.SpriteFont;
import Utils.Stopwatch;

// This class is for when the platformer game is actually being played
public class PlayLevelScreen extends Screen implements PlayerListener {
    protected ScreenCoordinator screenCoordinator;
    protected Map map;
    protected Player player;
    protected PlayLevelScreenState playLevelScreenState;
    protected Stopwatch screenTimer = new Stopwatch();
    protected LevelClearedScreen levelClearedScreen;
    protected LevelLoseScreen levelLoseScreen;
    protected SpriteFont healthText;
    protected Queue<Map> mapList;
    protected SpriteFont coinText;

    public PlayLevelScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
        mapList = new LinkedList<Map>();
        mapList.add(new TutorialMap());
        mapList.add(new TestMap());
        mapList.add(new TreesMap());
        mapList.add(new PlatformMap());
        mapList.add(new HillsMap());
        mapList.add(new UndergroundMap());
        
      
    }

    public void initialize() {
        // define/setup map
        this.map = mapList.poll();
        this.map.reset();

        // setup player
        this.player = new Cat(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y);
        this.player.setMap(map);
        this.player.addListener(this);
        this.player.setLocation(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y);
        this.playLevelScreenState = PlayLevelScreenState.RUNNING;
        
        // add text
        healthText = new SpriteFont("HEALTH: " + player.getPlayerHealth(), 50, 50, "Comic Sans", 30, new Color(49, 207, 240));
        healthText.setOutlineColor(Color.black);
        healthText.setOutlineThickness(3);
        
        coinText = new SpriteFont("Coins: " + player.getPlayerHealth(), 50, 80, "Comic Sans", 30, new Color(237, 216, 73));
        coinText.setOutlineColor(Color.black);
        coinText.setOutlineThickness(3);
    }

    public void update() {
        // based on screen state, perform specific actions
        switch (playLevelScreenState) {
            // if level is "running" update player and map to keep game logic for the platformer level going
            case RUNNING:
                player.update();
                map.update(player);
                updateHealthText();
                updateCoinText();
                break;
            // if level has been completed, bring up level cleared screen
            case LEVEL_COMPLETED:
                levelClearedScreen = new LevelClearedScreen();
                levelClearedScreen.initialize();
                screenTimer.setWaitTime(2500);
                playLevelScreenState = PlayLevelScreenState.LEVEL_WIN_MESSAGE;
                break;
            // if level cleared screen is up and the timer is up for how long it should stay out, go back to main menu
            case LEVEL_WIN_MESSAGE:
                if (screenTimer.isTimeUp()) {
                    levelClearedScreen = null;
                    
                    //Cycle through maps
                    if(!mapList.isEmpty()) {
                    	initialize();
                    }else {
                    	goBackToMenu();
                    }   
                }
                
                break;
            // if player died in level, bring up level lost screen
            case PLAYER_DEAD:
                levelLoseScreen = new LevelLoseScreen(this);
                levelLoseScreen.initialize();
                playLevelScreenState = PlayLevelScreenState.LEVEL_LOSE_MESSAGE;
                break;
            // wait on level lose screen to make a decision (either resets level or sends player back to main menu)
            case LEVEL_LOSE_MESSAGE:
                levelLoseScreen.update();
                break;
        }
    }

    public void draw(GraphicsHandler graphicsHandler) {
        // based on screen state, draw appropriate graphics
        switch (playLevelScreenState) {
            case RUNNING:
            case LEVEL_COMPLETED:
            case PLAYER_DEAD:
                map.draw(graphicsHandler);
                player.draw(graphicsHandler);
                healthText.draw(graphicsHandler);
                coinText.draw(graphicsHandler);
                break;
            case LEVEL_WIN_MESSAGE:
                levelClearedScreen.draw(graphicsHandler);
                break;
            case LEVEL_LOSE_MESSAGE:
                levelLoseScreen.draw(graphicsHandler);
                break;
        }
    }

    public PlayLevelScreenState getPlayLevelScreenState() {
        return playLevelScreenState;
    }

    @Override
    public void onLevelCompleted() {
        playLevelScreenState = PlayLevelScreenState.LEVEL_COMPLETED;
    }

    @Override
    public void onDeath() {
        playLevelScreenState = PlayLevelScreenState.PLAYER_DEAD;
    }

    public void resetLevel() {
        Queue tempMapList = new LinkedList<Map>();
        tempMapList.add(map);
        for(Map currMap : mapList) {
        	tempMapList.add(currMap);
        }
        mapList = tempMapList;
    	initialize();
    }

    public void updateHealthText() {
    	if(healthText.getText() != "HEALTH: " + player.getPlayerHealth()) {
    		healthText.setText("HEALTH: " + player.getPlayerHealth());
    	}
    }
    public void updateCoinText() {
    	if(coinText.getText() != "Coin: " + player.getPlayerCoin()) {
    		coinText.setText("Coins: " + player.getPlayerCoin());
    	}
    }
    public void goBackToMenu() {
        screenCoordinator.setGameState(GameState.MENU);
    }

    // This enum represents the different states this screen can be in
    public enum PlayLevelScreenState {
        RUNNING, LEVEL_COMPLETED, PLAYER_DEAD, LEVEL_WIN_MESSAGE, LEVEL_LOSE_MESSAGE, NOT_RUNNING;
    }
}
