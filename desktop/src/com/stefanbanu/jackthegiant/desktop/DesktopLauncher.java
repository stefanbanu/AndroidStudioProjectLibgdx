package com.stefanbanu.jackthegiant.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.stefanbanu.jackthegiant.GameMain;

import utils.GameProperties;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = GameProperties.WIDTH;
		config.height = GameProperties.HEIGHT;
		new LwjglApplication(new GameMain(), config);
	}
}
