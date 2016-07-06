package com.tetris.pieces;

public abstract class Piece {
	public static int ROWS = 3; 
	public static int COLS = 3; 
	int[][] piece; 
	
	public Piece() {
		piece = new int[3][3]; 
		createPiece();
	}
	
	public abstract void createPiece(); 
	
	public void rotateRight() {
		int aux1; 
		int aux2; 
		
		//Rotate corners
		aux1 = piece[0][0]; 
		aux2 = piece[0][2]; 
		piece[0][2] = aux1;
		aux1 = aux2; 
		aux2 = piece[2][2]; 
		piece[2][2] = aux1; 
		aux1 = aux2; 
		aux2 = piece[2][0]; 
		piece[2][0] = aux1;  
		aux1 = aux2; 
		aux2 = piece[0][0]; 
		piece[0][0] = aux1;
		
		//Rotate edges
		aux1 = piece[0][1];
		aux2 = piece[1][2]; 
		piece[1][2] = aux1; 
		aux1 = aux2; 
		aux2 = piece[2][1]; 
		piece[2][1] = aux1; 
		aux1 = aux2; 
		aux2 = piece[1][0]; 
		piece[1][0] = aux1; 
		aux1 = aux2; 
		aux2 = piece[0][1];
		piece[0][1] = aux1; 
	}
	
	public void rotateLeft() {
		int aux1; 
		int aux2; 
		
		//Rotate corners
		aux1 = piece[0][0]; 
		aux2 = piece[2][0]; 
		piece[2][0] = aux1;
		aux1 = aux2; 
		aux2 = piece[2][2]; 
		piece[2][2] = aux1; 
		aux1 = aux2; 
		aux2 = piece[0][2]; 
		piece[0][2] = aux1;  
		aux1 = aux2; 
		aux2 = piece[0][0]; 
		piece[0][0] = aux1;
		
		//Rotate edges
		aux1 = piece[0][1];
		aux2 = piece[1][0]; 
		piece[1][0] = aux1; 
		aux1 = aux2; 
		aux2 = piece[2][1]; 
		piece[2][1] = aux1; 
		aux1 = aux2; 
		aux2 = piece[1][2]; 
		piece[1][2] = aux1; 
		aux1 = aux2; 
		aux2 = piece[0][1];
		piece[0][1] = aux1; 
	}
	
	public int[][] getPiece() {
		return piece; 
	}
	
	public int getPart(int i, int j) {
		return piece[i][j]; 
	}
	
}
