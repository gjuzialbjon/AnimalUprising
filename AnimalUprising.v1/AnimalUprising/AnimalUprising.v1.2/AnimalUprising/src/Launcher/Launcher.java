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
