package oodesign.tictactoe;

public class GameController {
	private static GameController	instance;
	public GameController getInstance () {
		if ( instance == null ) {
			instance  =  new GameController();
		}
		return instance;
	}
	
	Player	white_player ;
	Player  black_player ;
	Board	board;
	
	Player	curPlayer    ;
	private GameController () {
		white_player  =  null;
		black_player  =  null;
		board		  =  new Board();
		curPlayer     =  null;
	}
	
	public void registerPlayer (Player p, Color c) {
		if ( c == Color.white ){
			white_player  =  p;
		} else if ( c == Color.black ){
			black_player = p;
		}
	}
	
	private void unRegisterPlayer(Color c) {
		if ( c == Color.white ){
			white_player  =  null;
		} else if ( c == Color.black ){
			black_player = null;
		}
	}
	private void start (Player p) {
		if ( p != white_player && p != black_player ) {
			// runtime error!
			return;
		}
		curPlayer  =  p;
	}
	
	private void end () {
		curPlayer  =  null;
		board.clearAll();
	}
	private void process () {
		if ( curPlayer == white_player) {
			curPlayer  =  black_player;
		} else 
			curPlayer  =  white_player;
	}
	public void actionListener (Action e) {
		switch (e.getActionType()) {
		case "start":
			start(white_player);
			break;
		case "quit":
			unRegisterPlayer(curPlayer.color);
			end();
			break;
		case "move":
			ActionMove mev  =  (ActionMove)e;
			curPlayer.put(board, mev.x, mev.y);
			process();
			break;
		default:
			break;
		}
	}
}
