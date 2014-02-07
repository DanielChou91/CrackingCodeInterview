package oodesign.tictactoe;

public class ActionMove extends Action{
	int		x;
	int		y;
	public ActionMove (int x, int y) {
		this.x  =  x;
		this.y  =  y;
	}
	@Override
	public String getActionType() {
		// TODO Auto-generated method stub
		return "move";
	}
}
