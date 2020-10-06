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

public class Coins extends Enemy{

	public Coins(BufferedImage image, float x, float y) {
		super("file:///C:/Users/andre/eclipse-workspace/SER-225-Game-Master/Resources/coin_flat.png", 0, 0);
		// TODO Auto-generated constructor stub
	}

}
