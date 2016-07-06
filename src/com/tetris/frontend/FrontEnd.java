package com.tetris.frontend;

import com.tetris.game.Board;
import com.tetris.game.GameParameters;

public class FrontEnd {

	public static void printMenu() {
		System.out.println("");
		System.out.println("1. Drop ");
		System.out.println("2. Right ");
		System.out.println("3. Left ");
		System.out.println("4. Down ");
		System.out.println("5. Rotate ");
		System.out.println("6. Exit ");
	}
	
	public static void printBoard(Board board) {
		for(int i=0; i<GameParameters.ROWS; i++) {
			for(int j=0; j<GameParameters.COLS; j++) {
				System.out.print(" " 
						+ (board.get(i,j) == GameParameters.VACANT_POSITION ? "-" 
								: board.get(i,j) == GameParameters.PIECES_IN_PLACE_POSITION || board.get(i,j) == GameParameters.PIECE_ID ? "*" 
										: " ") 
						+ " "); 
			}
			System.out.println("");
		}
	}
	
	public static void printRealBoard(Board board) {
		for(int i=0; i<GameParameters.ROWS; i++) {
			for(int j=0; j<GameParameters.COLS; j++) {
				System.out.print(" " + (board.get(i,j)) + " "); 
			}
			System.out.println("");
		}
	}
	
	public static void clear() {
		for(int i=0; i<28; i++)
			System.out.println("");
	}
	
	public static void gameOver(Board board) {
		clear(); 
		printBoard(board);
		System.out.println("");
		System.out.println("\tGAME OVER");
	}
	
	public static void goodBye(Board board) {
		clear(); 
		printBoard(board);
		System.out.println("");
		System.out.println("\tGOOD GAME. BYE!");
	}
	
	public static void print(String txt) {
		System.out.print(txt);
	}
}
