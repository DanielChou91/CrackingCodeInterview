package oodesign.tictactoe;

public class Player {
	Color	color ;
	public Player (Color color) {
		this.color  =  color;
	}
	
	public void put(Board b, int x, int y) {
		Piece	p  =  new Piece(color);
		b.put(p, x, y);
	}
	
}
