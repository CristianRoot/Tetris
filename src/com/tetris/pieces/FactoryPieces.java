package com.tetris.pieces;

import com.tetris.game.GameParameters;

public class FactoryPieces {

	private class PieceI extends Piece {
		
		public PieceI() {
			super(); 
		}

		@Override
		public void createPiece() {
			piece[1][0] = GameParameters.PIECE_ID;
			piece[1][1] = GameParameters.PIECE_ID;
			piece[1][2] = GameParameters.PIECE_ID;
		}
		
	}
	private class PieceJ extends Piece {
		
		public PieceJ() {
			super(); 
		}
		
		@Override
		public void createPiece() {
			piece[1][0] = GameParameters.PIECE_ID;
			piece[1][1] = GameParameters.PIECE_ID;
			piece[1][2] = GameParameters.PIECE_ID;
			piece[2][2] = GameParameters.PIECE_ID;
		}
		
	}
	private class PieceL extends Piece {

		public PieceL() {
			super();
		}
		
		@Override
		public void createPiece() {
			piece[1][0] = GameParameters.PIECE_ID;
			piece[1][1] = GameParameters.PIECE_ID;
			piece[1][2] = GameParameters.PIECE_ID;
			piece[2][0] = GameParameters.PIECE_ID;
		}

	}
	private class PieceO extends Piece {
		
		public PieceO() {
			super(); 
		}

		@Override
		public void rotateRight() {};
		
		@Override
		public void rotateLeft() {};
		
		@Override
		public void createPiece() {
			piece[1][0] = GameParameters.PIECE_ID;
			piece[1][1] = GameParameters.PIECE_ID;
			piece[2][0] = GameParameters.PIECE_ID;
			piece[2][1] = GameParameters.PIECE_ID;
		}
		
	}
	private class PieceS extends Piece {
		
		public PieceS() {
			super(); 
		}

		@Override
		public void createPiece() {
			piece[2][0] = GameParameters.PIECE_ID;
			piece[2][1] = GameParameters.PIECE_ID;
			piece[1][1] = GameParameters.PIECE_ID;
			piece[1][2] = GameParameters.PIECE_ID;
		}
		
	}
	private class PieceT extends Piece {
		
		public PieceT() {
			super(); 
		}

		@Override
		public void createPiece() {
			piece[2][0] = GameParameters.PIECE_ID;
			piece[2][1] = GameParameters.PIECE_ID;
			piece[2][2] = GameParameters.PIECE_ID;
			piece[1][1] = GameParameters.PIECE_ID;
		}
		
	}
	private class PieceZ extends Piece {
		
		public PieceZ() {
			super(); 
		}
		
		@Override
		public void createPiece() {
			piece[1][0] = GameParameters.PIECE_ID;
			piece[1][1] = GameParameters.PIECE_ID;
			piece[2][1] = GameParameters.PIECE_ID;
			piece[2][2] = GameParameters.PIECE_ID;
		}
		
	}
	
	private static FactoryPieces instance = getInstance(); 
	
	private FactoryPieces() {
		
	}
	
	public static FactoryPieces getInstance() {
		if(instance == null)
			instance = new FactoryPieces(); 
		
		return instance; 
	}
	
	public Piece getRandomPiece() {
		int opt = (int)(Math.random() * 7) +1; 
		Piece pieceToReturn = null; 
		
		switch(opt) {
		case 1: 
			pieceToReturn = new PieceI(); 
			break; 
		case 2: 
			pieceToReturn = new PieceJ(); 
			break; 
		case 3: 
			pieceToReturn = new PieceL(); 
			break; 
		case 4: 
			pieceToReturn = new PieceO(); 
			break; 
		case 5: 
			pieceToReturn = new PieceS(); 
			break; 
		case 6: 
			pieceToReturn = new PieceT(); 
			break; 
		case 7: 
			pieceToReturn = new PieceZ(); 
			break; 
		}
		
		return pieceToReturn; 
	}
}
