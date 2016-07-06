package com.tetris.game;

import com.tetris.pieces.Piece;

public class Board {
	private int[][] board; 

	public Board() {
		board = new int[GameParameters.ROWS][GameParameters.COLS]; 
		createBoard();
	}
	
	private void createBoard() {
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[i].length; j++) {
				if(i<GameParameters.LIMIT_ROW)
					board[i][j] = GameParameters.HEADER_POSITION;
				else if(i == GameParameters.LIMIT_ROW)
					board[i][j] = GameParameters.LIMIT_POSITION;
				else
					board[i][j] = GameParameters.VACANT_POSITION; 
			}
		}
	}
	
	public boolean insertPiece(Piece piece, int[] centerCoordinates) {
		boolean inserted = false; 
		
		if(isValidPosition(piece, centerCoordinates)) {
			for(int i=0; i<Piece.ROWS; i++) {
				for(int j=0; j<Piece.COLS; j++) {
					if(piece.getPart(i, j) == GameParameters.PIECE_ID) {
						int k = centerCoordinates[0] + (i-1);
						int l = centerCoordinates[1] + (j-1); 
					
						board[k][l] = GameParameters.PIECE_ID; 
					}
				}
			}
			inserted = true; 
		}
		
		return inserted; 
	}
	
	public void removePiece(Piece piece, int[] centerCoordinates) {
		for(int i=0; i<Piece.ROWS; i++) {
			for(int j=0; j<Piece.COLS; j++) {
				if(piece.getPart(i, j) == GameParameters.PIECE_ID) {
					int k = centerCoordinates[0] + (i-1);
					int l = centerCoordinates[1] + (j-1); 
				
					board[k][l] = k < GameParameters.LIMIT_ROW ? GameParameters.HEADER_POSITION 
							: k == GameParameters.LIMIT_ROW ? GameParameters.LIMIT_POSITION 
							: GameParameters.VACANT_POSITION; 
				}
			}
		}
	}
	
	public void fixPiece(Piece piece, int[] centerCoordinates) {
		for(int i=0; i<Piece.ROWS; i++) {
			for(int j=0; j<Piece.COLS; j++) {
				if(piece.getPart(i,j) == GameParameters.PIECE_ID) {
					int k = centerCoordinates[0] + (i-1);
					int l = centerCoordinates[1] + (j-1); 
				
					board[k][l] = GameParameters.PIECES_IN_PLACE_POSITION; 
				}
			}
		}
	}
	
	public boolean isValidPosition(Piece pic, int[] center) {
		boolean isValid = true; 
		int i,j;
		
		i=0; 
		while(i<Piece.ROWS && isValid) {
			j=0; 
			while(j<Piece.COLS && isValid) {
				if(pic.getPart(i,j) == GameParameters.PIECE_ID) {
					int k = center[0] + (i-1);
					int l = center[1] + (j-1); 
				
					if(k >= 0 && k < GameParameters.ROWS && l >= 0 && l < board[k].length) {
						if(board[k][l] == GameParameters.PIECES_IN_PLACE_POSITION) {
							isValid = false; 
						}
					} else {
						isValid = false; 
					}
				}
				
				j++; 
			}
			i++; 
		}
		
		return isValid; 
	}
	
	public boolean arePieceInLimitRow() {
		boolean thereArePieces = false; 
		int i = 0; 
		
		while(i < GameParameters.COLS && !thereArePieces) {
			if(board[GameParameters.LIMIT_ROW][i] == GameParameters.PIECES_IN_PLACE_POSITION)
				thereArePieces = true; 
			else 
				i++;
		}
		
		return thereArePieces; 
	}
	
	public boolean cleanRow(int row) {
		int i=0; 
		boolean filled = true; 
		
		while(i<GameParameters.COLS && filled) {
			if(board[row][i] != GameParameters.PIECES_IN_PLACE_POSITION)
				filled = false; 
			else
				i++; 
		}
		
		if(filled) {
			for(int j=0; j<GameParameters.COLS; j++)
				board[row][j] = GameParameters.VACANT_POSITION; 
			
			dropAllFrom(row-1); 
		}
		
		return filled; 
	}
	
	private void dropAllFrom(int row) {
		int nextRow; 
		
		while(row > GameParameters.LIMIT_ROW) {
			nextRow = row+1; 
			for(int i=0; i<GameParameters.COLS; i++) 
				board[nextRow][i] = board[row][i]; 
			row--;
		}
		
		nextRow = row+1; 
		for(int i=0; i<GameParameters.COLS; i++) 
			board[nextRow][i] = GameParameters.VACANT_POSITION;  
	}
	
	public int get(int i, int j) {
		return board[i][j]; 
	}

}
