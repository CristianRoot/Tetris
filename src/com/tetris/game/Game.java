package com.tetris.game;
import java.io.IOException;

import com.tetris.frontend.FrontEnd;
import com.tetris.pieces.FactoryPieces;
import com.tetris.pieces.Piece;


/**
 * Tetris 
 * 
 * @author Cristian
 */
public class Game {
	private static Board board; 
	private static Piece activePiece; 
	private static int[] centerOfPiece; 
	private static boolean endGame;
	
	public static void main(String args[]) throws IOException {
		board = new Board();
		centerOfPiece = new int[2];
		endGame = false; 
		
		startGame(); 
	}
	
	private static void startGame() throws IOException {
		takeNewPiece();
		loopGame(); 
	}
	
	private static void takeNewPiece() {
		FactoryPieces factoryPieces = FactoryPieces.getInstance(); 
		
		activePiece = factoryPieces.getRandomPiece(); 
		centerOfPiece[0] = 1; 
		centerOfPiece[1] = 1; 
		board.insertPiece(activePiece, centerOfPiece);
	}
	
	private static void loopGame() throws IOException {
		int option = 0;
		boolean exit = false; 
		boolean actionPerformed; 
		
		while(!exit && !endGame) {
			FrontEnd.clear(); 
			FrontEnd.printBoard(board);
			FrontEnd.printMenu(); 
			actionPerformed = false; 
			
			while(!actionPerformed && !exit) {
				option = Utilities.requestIntegerOption(1,6); 
				
				if(option == GameParameters.EXIT)
					exit = true; 
				else
					actionPerformed = performAction(option);
			}
			
			if(pieceIsPlaced()) {
				board.fixPiece(activePiece, centerOfPiece);
				
				if(board.arePieceInLimitRow())
					endGame = true; 
				else {
					updateBoard(); 
					takeNewPiece();
				}
			}
		}
		
		if(endGame) 
			FrontEnd.gameOver(board); 
		else if(exit)
			FrontEnd.goodBye(board); 
	}
	
	private static void updateBoard() {
		int i = GameParameters.ROWS-1;
		
		while(i>GameParameters.LIMIT_ROW) 
			if(!board.cleanRow(i))
				i--;
	}
	
	private static boolean pieceIsPlaced() {
		boolean isPlaced = false; 
		int[] centerUnderPiece = centerOfPiece.clone(); 
		
		centerUnderPiece[0]++; 
		if(!board.isValidPosition(activePiece, centerUnderPiece))
			isPlaced = true;
			
		return isPlaced; 
	}
	
	private static boolean performAction(int opt) {
		boolean isActionPerformed = false; 
		
		switch(opt) {
		case GameParameters.DROP: 
			isActionPerformed = drop(); 
			break; 
		case GameParameters.MOVE_RIGHT: 
			isActionPerformed = moveRight();
			break; 
		case GameParameters.MOVE_LEFT: 
			isActionPerformed = moveLeft();
			break; 
		case GameParameters.MOVE_DOWN: 
			isActionPerformed = moveDown();
			break; 
		case GameParameters.ROTATE: 
			isActionPerformed = rotate();
		}
		
		return isActionPerformed; 
	}
	
	private static boolean drop() {
		boolean actionPerformed = false; 
		boolean canDown = true; 
		
		while(canDown) {
			if(moveDown()) {
				canDown = true;
				actionPerformed = true; 
			} else
				canDown = false; 
		}
		
		return actionPerformed; 
	}
	
	private static boolean moveRight() {
		boolean actionPerformed = false; 
		int[] futureCenter = centerOfPiece.clone();
		
		futureCenter[1]++; 
		board.removePiece(activePiece, centerOfPiece);
		
		if(board.insertPiece(activePiece, futureCenter)) {
			actionPerformed = true; 
			centerOfPiece[1]++; 
		} else 
			board.insertPiece(activePiece, centerOfPiece); 
		
		return actionPerformed; 
	}
	
	private static boolean moveLeft() {
		boolean actionPerformed = false; 
		int[] futureCenter = centerOfPiece.clone();
		
		futureCenter[1]--; 
		board.removePiece(activePiece, centerOfPiece);
		
		if(board.insertPiece(activePiece, futureCenter)) {
			actionPerformed = true; 
			centerOfPiece[1]--; 
		} else 
			board.insertPiece(activePiece, centerOfPiece); 
		
		return actionPerformed; 
	}
	
	private static boolean moveDown() {
		boolean actionPerformed = false; 
		int[] futureCenter = centerOfPiece.clone();
		
		futureCenter[0]++; 
		board.removePiece(activePiece, centerOfPiece);
		
		if(board.insertPiece(activePiece, futureCenter)) {
			actionPerformed = true; 
			centerOfPiece[0]++; 
		} else 
			board.insertPiece(activePiece, centerOfPiece); 
		
		return actionPerformed; 
	}
	
	private static boolean rotate() {
		boolean actionPerformed = false; 
		
		board.removePiece(activePiece, centerOfPiece);
		activePiece.rotateRight(); 
		
		if(board.insertPiece(activePiece, centerOfPiece)) {
			actionPerformed = true; 
		} else {
			activePiece.rotateLeft();
			board.insertPiece(activePiece, centerOfPiece); 
		}
		
		return actionPerformed; 
	}
	
}
