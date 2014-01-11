package chapter9;

public class Q9_2 {

	public static void main (String[] args) {
		System.out.println( possibleMoves(5, 0));
	}
	public static int possibleMoves (int x, int y) {
		// bottom up approach
		// initialize the table
		int[][]		s   =   new int[x+1][y+1];
		// top row
		for ( int i=0; i <= x; ++i )
			s[i][0]  =  1;
		// left column
		for ( int i=1; i <= y; ++i )
			s[0][i]  =  1;

		// build up the table
		for ( int i=1 ; i <= x; ++i ) {
			for ( int j=1; j <= y; ++j ) {
				s[i][j]  =  s[i-1][j] + s[i][j-1];
			}
		}
		return s[x][y];
	}
}
