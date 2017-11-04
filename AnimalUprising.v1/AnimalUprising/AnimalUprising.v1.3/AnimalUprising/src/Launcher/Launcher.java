/*
 * Author: Bora Ecer
 * Date: 1 November 2017
 * Version: v1
 * Class for main function.
 */



package Launcher;
import GameControl.*;
import GameModel.*;
import UIManagement.*;

public class Launcher {
	
	public static void main(String[] args) {
		GameManager game = new GameManager("Animal Uprising", 600, 600, new InputManager(), new ObjectManager());
		game.start();
	}
	
}
