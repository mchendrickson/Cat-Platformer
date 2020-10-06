package Enemies;

import java.awt.image.BufferedImage;

import Builders.FrameBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.ImageEffect;
import GameObject.SpriteSheet;
import Level.Enemy;
import Level.Player;
import Utils.AirGroundState;
import Utils.Direction;
import Utils.Point;
import Utils.Stopwatch;

public class Coin extends Enemy{

	public Coin(float x, float y) {
		super(ImageLoader.load("file:///C:/Users/andre/eclipse-workspace/SER-225-Game-Master/Resources/coin_flat.png"), x, y);
		// TODO Auto-generated constructor stub
	}
	
	public void initialize()
	{
		
	}

}
