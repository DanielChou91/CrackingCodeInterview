package oodesign.tictactoe;

public class Board {
	Piece[][]		cache ;
	
	public Board () {
		cache  =  new Piece[3][3];
	}
	
	public void put(Piece p, int x, int y) {
		if ( !isValidMove(x, y) ) {
			// direct error info to handler
			return;
		}
		if ( cache[x][y] != null ){
			System.err.println( "Please Check Your Move!");
			return ;
		}
		cache[x][y]  =  p;
	}
	public void clearAll () {
		cache  =  new Piece[3][3];
	}
	public boolean detectWin() {
		return false;
	}
	
	private boolean isValidMove (int x, int y) {
		return ( x < 3 && x >=0 && y <3 && y >= 0 );
	}
}
